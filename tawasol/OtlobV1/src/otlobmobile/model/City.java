/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

import java.util.Vector;
import org.ksoap2.serialization.SoapObject;

/**
 *
 * @author Mahmoud.Ismail
 */
public class City {

    //Static Otlob Web Service parameters    
    public static final String NAMESPACE = "http://tempuri.org/";
    public static final String METHOD_NAME = "GetCitiesByCountryID";
    public static final String SOAP_ACTION = "http://tempuri.org/IDataDisplayingWCF/GetCitiesByCountryID";    
    //Class fields
    private int id;
    private int ssoID;
    private int countryId;
    private String cityName;
    private String cityNameL2;
    private int flashIndex;
    private boolean isActive;
    private Vector cityAreas;

    public City() {
    }

    public Vector getCityAreas() {
        return cityAreas;
    }

    public void setCityAreas(Vector cityAreas) {
        this.cityAreas = cityAreas;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityNameL2() {
        return cityNameL2;
    }

    public void setCityNameL2(String cityNameL2) {
        this.cityNameL2 = cityNameL2;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getSsoID() {
        return ssoID;
    }

    public void setSsoID(int ssoID) {
        this.ssoID = ssoID;
    }

    public static Vector parseCities(SoapObject soap) {
        Vector cities = new Vector();
        SoapObject content;
        City c;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            c = new City();
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        c.setCityAreas(null);
                        break;
                    case 1:
                        c.setCityName(s);
                        break;
                    case 2:
                        c.setCityNameL2(s);
                        break;
                    case 3:
                        c.setCountryId(Integer.parseInt(s));
                        break;
                    case 4:
                        c.setFlashIndex(Integer.parseInt(s));
                        break;
                    case 5:
                        c.setId(Integer.parseInt(s));
                        break;
                    case 6:
                        c.setSsoID(Integer.parseInt(s));
                        break;
                    case 7:
                        c.setIsActive((s.equals("true")) ? true : false);
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
