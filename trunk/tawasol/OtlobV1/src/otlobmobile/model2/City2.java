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
    public static final String METHOD_NAME = "GetCitiesByCountryID";
    public static final String SOAP_ACTION = "http://OtlobzService/GetCitiesByCountryID";
    //Class fields
    private int id;
    private String cityName;
    private int countryId;
    private int ssoId;
    private int flashIndex;
    private boolean isActive;

    public City2() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getFlashIndex() {
        return flashIndex;
    }

    public void setFlashIndex(int flashIndex) {
        this.flashIndex = flashIndex;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getSsoId() {
        return ssoId;
    }

    public void setSsoId(int ssoId) {
        this.ssoId = ssoId;
    }

    public static Vector parseCities(SoapObject soap, int countryId) {
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
                        // Extension Data
                        
                        break;
                    case 1:
                        c.setCityName(s);
                        break;
                    case 2:
                        //Override countryId becuz it always come with 0 from the webservice 
                        c.setCountryId(countryId);
                        break;
                    case 3:
                        c.setFlashIndex(Integer.parseInt(s));
                        break;
                    case 4:
                        c.setId(Integer.parseInt(s));
                        break;
                    case 5:
                        c.setSsoId(Integer.parseInt(s));
                        break;
                    case 6:
                        c.setIsActive((s.equals("true")) ? true : false);
                        break;

                }
            }
            cities.addElement(c);

        }
        System.out.println("Found cities:" + cities.size());

        return cities;
    }

    public String toString() {
        return "City " + id + " : " + cityName;
    }
}
