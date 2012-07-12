/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

/**
 *
 * @author Mahmoud.Ismail
 */
public class Address {

    private int addressID;
    private String addressName;
    private int addressType;
    private String apartment;
    private int areaID;
    private String building;
    private int cityID;
    private String company;
    private int countryID;
    private String directions;
    private String floor;
    private boolean isAddressDefault;
    private String street;
    private long telephone;
    private short telephoneArea;
    private short telephoneCountry;
    private short telephoneExtension;
    private String userName;
    private String zipCode;

    public Address(
            String userName,
            String addressName,
            int addressType,
            int countryID,
            int cityID,
            int areaID,
            String building,
            String street,
            String floor,
            String apartment,
            long telephone,
            short telephoneCountry,
            short telephoneArea,
            String company) {
        this.userName = userName;
        this.addressName = addressName;
        this.addressType = addressType;
        this.countryID = countryID;
        this.cityID = cityID;
        this.areaID = areaID;
        this.building = building;
        this.street = street;
        this.floor = floor;
        this.apartment = apartment;
        this.telephone = telephone;
        this.telephoneCountry = telephoneCountry;
        this.telephoneArea = telephoneArea;
        this.company = company;
    }

    public Address(
            String userName,
            String addressName,
            int addressType,
            int countryID,
            int cityID,
            int areaID,
            String building,
            String street,
            String floor,
            String apartment,
            long telephone,
            short telephoneCountry,
            short telephoneArea,
            String zipCode,
            short telephoneExtension,
            String directions,
            String company,
            boolean isAddressDefault) {
        this.userName = userName;
        this.addressName = addressName;
        this.addressType = addressType;
        this.countryID = countryID;
        this.cityID = cityID;
        this.areaID = areaID;
        this.building = building;
        this.street = street;
        this.floor = floor;
        this.apartment = apartment;
        this.telephone = telephone;
        this.telephoneCountry = telephoneCountry;
        this.telephoneArea = telephoneArea;
        this.company = company;
        
        this.zipCode = zipCode;
        this.telephoneExtension = telephoneExtension;
        this.directions = directions;
        this.isAddressDefault = isAddressDefault;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public int getAreaID() {
        return areaID;
    }

    public void setAreaID(int areaID) {
        this.areaID = areaID;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean isIsAddressDefault() {
        return isAddressDefault;
    }

    public void setIsAddressDefault(boolean isAddressDefault) {
        this.isAddressDefault = isAddressDefault;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public short getTelephoneArea() {
        return telephoneArea;
    }

    public void setTelephoneArea(short telephoneArea) {
        this.telephoneArea = telephoneArea;
    }

    public short getTelephoneCountry() {
        return telephoneCountry;
    }

    public void setTelephoneCountry(short telephoneCountry) {
        this.telephoneCountry = telephoneCountry;
    }

    public short getTelephoneExtension() {
        return telephoneExtension;
    }

    public void setTelephoneExtension(short telephoneExtension) {
        this.telephoneExtension = telephoneExtension;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
