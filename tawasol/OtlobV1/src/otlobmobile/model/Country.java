/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

/**
 *
 * @author Mahmoud.Ismail
 */
public class Country {

    public String countryName;
    public String countryNameL2;
    public String currencyName;
    public int id;
    public int ssoID;
    public int timeZone;
    public boolean isActive;
    public boolean isSelected;

    public Country() {
    }

    public Country(String countryName, String countryNameL2, String currencyName, int id, int ssoID, int timeZone, boolean isActive, boolean isSelected) {
        this.countryName = countryName;
        this.countryNameL2 = countryNameL2;
        this.currencyName = currencyName;
        this.id = id;
        this.ssoID = ssoID;
        this.timeZone = timeZone;
        this.isActive = isActive;
        this.isSelected = isSelected;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameL2() {
        return countryNameL2;
    }

    public void setCountryNameL2(String countryNameL2) {
        this.countryNameL2 = countryNameL2;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public int getSsoID() {
        return ssoID;
    }

    public void setSsoID(int ssoID) {
        this.ssoID = ssoID;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }
}
