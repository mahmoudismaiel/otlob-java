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
public class Area {

    //Static Otlob Web Service parameters
    public static final String NAMESPACE = "http://tempuri.org/";
    public static final String METHOD_NAME = "GetCityAreas";
    public static final String SOAP_ACTION = "http://tempuri.org/IDataDisplayingWCF/GetCityAreas";
    //Class fields
    private String areaName;
    private String areaNameL2;
    private int cityID;
    private int id;
    private boolean isActive;
    private int attachedToBranchID;
    private int ssoID;
    private City parent;

    public Area() {
    }

    public Area(City parent) {
        this.parent = parent;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaNameL2() {
        return areaNameL2;
    }

    public void setAreaNameL2(String areaNameL2) {
        this.areaNameL2 = areaNameL2;
    }

    public int getAttachedToBranchID() {
        return attachedToBranchID;
    }

    public void setAttachedToBranchID(int attachedToBranchID) {
        this.attachedToBranchID = attachedToBranchID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
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

    public City getCity() {
        return parent;
    }

    public void setParent(City parent) {
        this.parent = parent;
    }

    public int getSsoID() {
        return ssoID;
    }

    public void setSsoID(int ssoID) {
        this.ssoID = ssoID;
    }

    public static Vector parseCityAreas(SoapObject soap, City parent) {
        Vector areas = new Vector();
        SoapObject content;
        Area a;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            a = new Area(parent);
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        a.setAreaName(s);
                        break;
                    case 1:
                        a.setAreaNameL2(s);
                        break;
                    case 2:
                        a.setAttachedToBranchID(Integer.parseInt(s));
                        break;
                    case 3:
                        // a.setCountryId(Integer.parseInt(s));
                        break;
                    case 4:
                        // a.setFlashIndex(Integer.parseInt(s));
                        break;
                    case 5:
                        a.setId(Integer.parseInt(s));
                        break;
                    case 6:
                        // a.setSsoID(Integer.parseInt(s));
                        break;
                    case 7:
                        a.setSsoID(Integer.parseInt(s));
                        break;
                    case 8:
                        a.setIsActive((s.equals("true")) ? true : false);
                        break;
                }
            }
            areas.addElement(a);

        }
      //  System.out.println("Found Areas:" + areas.size());

        return areas;
    }

    public String toString() {
        return "Area " + id + " : " + areaName;
    }
}
