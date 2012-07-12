/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.webclient;

import otlobmobile.model.City;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransport;
import org.xmlpull.v1.XmlPullParserException;
import otlobmobile.model.Area;

/**
 *
 * @author Mahmoud.Ismail
 */
public class OtlobDataDisplayClient {
    public static final String SERVISE_URL = "http://services.otlob.com/DataDisplayingWCF.svc?wsdl";
 
    public static SoapObject getCountryCities(String culture, int countryID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("countryID", new Integer(countryID));

        return callWebServiceMethod(City.NAMESPACE,
                City.METHOD_NAME,
                City.SOAP_ACTION,
                SERVISE_URL,
                props);

    }

    public static SoapObject getCityAreas(String culture, int cityID) {
        Hashtable props = new Hashtable();
        props.put("culture", culture);
        props.put("cityID", new Integer(cityID));

        return callWebServiceMethod(Area.NAMESPACE,
                Area.METHOD_NAME,
                Area.SOAP_ACTION,
                SERVISE_URL,
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
        SoapObject content = (SoapObject) envelope.bodyIn;
       // System.out.println(content.toString());
        content = (SoapObject) content.getProperty(0);
        System.out.println(content.toString());

        return content;
    }
}
