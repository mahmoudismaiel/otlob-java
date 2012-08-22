/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.webclient;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.xmlpull.v1.XmlPullParserException;
import otlobmobile.model2.City2;
import otlobmobile.model.Branch;
import otlobmobile.model2.Area2;
import otlobmobile.model2.Branch2;
import otlobmobile.model2.Category2;
import otlobmobile.model2.MobileItemCategory;

/**
 *
 * @author Mahmoud.Ismail
 */
public class OtlobGatewayV3Client {

    public static final String SERVICE_URL = "http://www.otlob.com/OtlobGatewayV3/service.asmx?wsdl";

    public static SoapObject getCountryCities(int countryID, String culture) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("countryID", new Integer(countryID));

        return callWebServiceMethod(City2.NAMESPACE,
                City2.METHOD_NAME,
                City2.SOAP_ACTION,
                SERVICE_URL,
                props);

    }

    public static SoapObject getCityAreas(String culture, int cityID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("cityID", new Integer(cityID));

        return callWebServiceMethod(Area2.NAMESPACE,
                Area2.METHOD_NAME,
                Area2.SOAP_ACTION,
                SERVICE_URL,
                props);

    }

    public static SoapObject getCategoriesByAreaID(String culture, int areaID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));

        return callWebServiceMethod(Category2.NAMESPACE,
                Category2.METHOD_NAME,
                Category2.SOAP_ACTION,
                SERVICE_URL,
                props);
    }

    public static SoapObject getBranchesByAreaIDCategoryID(String culture, int areaID, int categoryID, int countryID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));
        props.put("categoryID", new Integer(categoryID));
        props.put("countryID", new Integer(countryID));


        return callWebServiceMethod(Branch2.NAMESPACE,
                Branch2.METHOD_NAME,
                Branch2.SOAP_ACTION,
                SERVICE_URL,
                props);

    } 

    public static SoapObject getBranchProfile(String culture, int branchID, int areaID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));
        props.put("branchID", new Integer(branchID));
        //  props.put("branchID", Boolean.TRUE);

        return callWebServiceMethod(Branch.NAMESPACE,
                Branch.METHOD_NAME_BRANCH_PROFILE,
                Branch.SOAP_ACTION_BRANCH_PROFILE,
                SERVICE_URL,
                props);

    }

    public static SoapObject getMenuForMObile(String culture, int branchID, int providerID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("branchID", new Integer(branchID));
        props.put("Provider_Id", new Integer(providerID));


        return callWebServiceMethod(MobileItemCategory.NAMESPACE,
                MobileItemCategory.METHOD_NAME_FOR_MOBILE,
                MobileItemCategory.SOAP_ACTION_FOR_MOBILE,
                SERVICE_URL,
                props);

    }

    /**
     * Calls Otlob web service method
     * 
     * @param NAMESPACE 
     * @param METHOD_NAME_FOR_MOBILE
     * @param SOAP_ACTION_FOR_MOBILE
     * @param URL
     * @param requestProperties
     * @return SoapObject represent method return objects
     */
    public static SoapObject callWebServiceMethod(String NAMESPACE,
            String METHOD_NAME,
            String SOAP_ACTION,
            String URL,
            Hashtable requestProperties) {


        //create a SOAP object
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        //add method arguments
        Enumeration e = requestProperties.keys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            Object value = requestProperties.get(key);
            //add Property to request
            request.addProperty(key, value);

        }
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        System.out.println("request: " + request);

        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
        envelope.encodingStyle = SoapEnvelope.ENV;
        envelope.implicitTypes = false;


        //  envelope.addMapping(NAMESPACE, "branch", new Branch().getClass());
        HttpTransport j2meHttpTransport = new HttpTransport(URL);
        try {
            //if you want to debug, uncomment next line
            //j2meHttpTransport.debug = true;            
            j2meHttpTransport.call(SOAP_ACTION, envelope);
        } catch (SoapFault ex) {
            System.out.println(ex.detail.getElement(0).getText(0));
            System.out.println(ex.faultstring);
            System.out.println(ex.faultcode);
            System.out.println(ex.faultactor);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }

        //  System.out.println("bodyIn error: \n"+envelope.bodyIn);
        SoapObject content = (SoapObject) envelope.bodyIn;
        //System.out.println("bodyIn: \n" + content.toString());

        content = (SoapObject) content.getProperty(0);
        //System.out.println(content.toString());
        return content;
    }
}
