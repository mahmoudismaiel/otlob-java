/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.webclient;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.xmlpull.v1.XmlPullParserException;
import otlobmobile.model.City;
import otlobmobile.model.Area;
import otlobmobile.model.AreaInfo;
import otlobmobile.model.Category;
import otlobmobile.model.Branch;

/**
 *
 * @author Mahmoud.Ismail
 */
public class OtlobDataDisplayClient {

    public static final String SERVICE_URL = "http://services.otlob.com/DataDisplayingWCF.svc?wsdl";

    public static SoapObject getCountryCities(String culture, int countryID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("countryID", new Integer(countryID));

        return callWebServiceMethod(City.NAMESPACE,
                City.METHOD_NAME,
                City.SOAP_ACTION,
                SERVICE_URL,
                props);

    }

    public static SoapObject getCityAreas(String culture, int cityID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("cityID", new Integer(cityID));

        return callWebServiceMethod(Area.NAMESPACE,
                Area.METHOD_NAME,
                Area.SOAP_ACTION,
                SERVICE_URL,
                props);

    }

    public static SoapObject getCategoriesByAreaID(String culture, int areaID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));

        return callWebServiceMethod(Category.NAMESPACE,
                Category.METHOD_NAME,
                Category.SOAP_ACTION,
                SERVICE_URL,
                props);

    }

    public static SoapObject getAreaInfo(String culture, int areaID, int countryID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));
        props.put("countryID", new Integer(countryID));

        return callWebServiceMethod(AreaInfo.NAMESPACE,
                AreaInfo.METHOD_NAME,
                AreaInfo.SOAP_ACTION,
                SERVICE_URL,
                props);

    }

    public static SoapObject getBranchesByAreaIDCategoryID(String culture, int areaID, int categoryID, int countryID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));
        props.put("categoryID", new Integer(categoryID));
        props.put("countryID", new Integer(countryID));
//         props.put("areaID", new Integer(75644));
//        props.put("categoryID", new Integer(-1));
//        props.put("countryID", new Integer(2));
        
        return callWebServiceMethod(Branch.NAMESPACE,
                Branch.METHOD_NAME,
                Branch.SOAP_ACTION,
                SERVICE_URL,
                props);

    }
    
     public static SoapObject getBranchProfile(String culture, int branchID,int areaID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("areaID", new Integer(areaID));        
        props.put("branchID", new Integer(branchID));
//         
        
        return callWebServiceMethod(Branch.NAMESPACE,
                Branch.METHOD_NAME_BRANCH_PROFILE,
                Branch.SOAP_ACTION_BRANCH_PROFILE,
                SERVICE_URL,
                props);

    }
    
    

    /**
     * Calls Otlob web service method
     * 
     * @param NAMESPACE 
     * @param METHOD_NAME
     * @param SOAP_ACTION
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
        
       // System.out.println("request: "+request);
        
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);

        // envelope.addMapping(NAMESPACE, "anyType", new Country().getClass());
        HttpTransport j2meHttpTransport = new HttpTransport(URL);
        try {
            //if you want to debug, uncomment next line
            //j2meHttpTransport.debug = true;
            j2meHttpTransport.call(SOAP_ACTION, envelope);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (XmlPullParserException ex) {
            ex.printStackTrace();
        }
        //  System.out.println("bodyIn error: \n"+envelope.bodyIn);
        SoapObject content = (SoapObject) envelope.bodyIn;
       // System.out.println("bodyIn: \n" + content.toString());
        content = (SoapObject) content.getProperty(0);
        // System.out.println(content.toString());

        return content;
    }
}
