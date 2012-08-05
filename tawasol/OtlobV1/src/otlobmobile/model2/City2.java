/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model2;

import java.util.Vector;
import org.ksoap2.serialization.SoapObject;

/**
 *
 * @author Mahmoud.Ismail
 */
public class City2 {

    //Static Otlob Web Service parameters
    public static final String NAMESPACE = "http://OtlobzService/";
    public static final String METHOD_NAME = "GetAllCitiesByCountryID";
    public static final String SOAP_ACTION = "http://OtlobzService/GetAllCitiesByCountryID";  
    //Class fields
    private int id;    
    private String cityName;
    private String cityNameAR;
   

    public City2() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNameAR() {
        return cityNameAR;
    }

    public void setCityNameAR(String cityNameAR) {
        this.cityNameAR = cityNameAR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public static Vector parseCities(SoapObject soap) {
        Vector cities = new Vector();
        SoapObject content;
        City2 c;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            c = new City2();
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        c.setId(Integer.parseInt(s));
                        break;
                    case 1:
                        c.setCityName(s);
                        break;
                    case 2:
                        c.setCityNameAR(s);
                        break;
                    
                }
            }
            cities.addElement(c);

        }
        //System.out.println("Found cities:" + cities.size());

        return cities;
    }

    public String toString() {
        return "City "+id +" : "+cityName; 
    }
    
    
}
