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
public class Area2 {

    //Static Otlob Web Service parameters
    public static final String NAMESPACE = "http://OtlobzService/";
    public static final String METHOD_NAME = "GetCityAreas";
    public static final String SOAP_ACTION = "http://OtlobzService/GetCityAreas";
    //Class fields
    private String areaName;
    private int id;
    private int ssoID;
    private City2 parent;

    public Area2() {
    }

    public Area2(City2 parent) {
        this.parent = parent;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City2 getCity() {
        return parent;
    }

    public void setParent(City2 parent) {
        this.parent = parent;
    }

    public int getSsoID() {
        return ssoID;
    }

    public void setSsoID(int ssoID) {
        this.ssoID = ssoID;
    }

    public static Vector parseCityAreas(SoapObject soap, City2 parent) {
        Vector areas = new Vector();
        SoapObject content;
        Area2 a;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            a = new Area2(parent);
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                       // Extension Data
                        break;
                    case 1:
                        a.setAreaName(s);
                        break;
                    case 2:
                        a.setId(Integer.parseInt(s));
                        break;
                    case 3:
                         a.setSsoID(Integer.parseInt(s));
                        break;
                    
                }
            }
            areas.addElement(a);

        }
          System.out.println("Found Areas:" + areas.size());

        return areas;
    }

    public String toString() {
        return "Area " + id + " : " + areaName;
    }
}
