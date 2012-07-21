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
public class Branch {

    //Static Otlob Web Service parameters for getting BRANCH data by Category
    public static final String NAMESPACE = "http://tempuri.org/";
    public static final String METHOD_NAME = "GetBranchesByAreaIDCategoryID";
    public static final String SOAP_ACTION = "http://tempuri.org/IDataDisplayingWCF/GetBranchesByAreaIDCategoryID";
    //Static Otlob Web Service parameters for getting BRANCH profile
    public static final String METHOD_NAME_BRANCH_PROFILE = "GetBranchProfile";
    public static final String SOAP_ACTION_BRANCH_PROFILE  = "http://tempuri.org/IDataDisplayingWCF/GetBranchProfile";
    //Class fields
    private Area area;
    private Category category;
    private String branchAddress;
    private String branchAddressL2;
    private double branchDelivery;
    private double branchDiscount;
    private boolean branchExtraRates;
    private String branchName;
    private String branchNameL2;
    private boolean branchOnline;
    private double branchTaxes;
    private String branchLogo;
    private String branchMenuLogo;
    private int closingTime;
    private short dayOff;
    private int deliverIn;
    private double discout;
    private String faxNumber;
    private int id;
    private boolean multiAreaRules;
    private String OHstatusName;
    private int openingTime;
    private int parentStatus;
    private String phone1;
    private String phone2;
    private String phone3;
    private Provider provider;
    private String REASON_TEXT;
    private boolean rules;
    private String SHORT_NAME;
    private int timeLimit;
    private Vector branchRates;
    private Vector branchRules;
    private Vector branchAreas;
    private Vector branchItems;

    public Branch() {
    }

    public Branch(Category category) {
        this.category = category;
    }

    public String getOHstatusName() {
        return OHstatusName;
    }

    public void setOHstatusName(String OHstatusName) {
        this.OHstatusName = OHstatusName;
    }

    public String getREASON_TEXT() {
        return REASON_TEXT;
    }

    public void setREASON_TEXT(String REASON_TEXT) {
        this.REASON_TEXT = REASON_TEXT;
    }

    public String getSHORT_NAME() {
        return SHORT_NAME;
    }

    public void setSHORT_NAME(String SHORT_NAME) {
        this.SHORT_NAME = SHORT_NAME;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchAddressL2() {
        return branchAddressL2;
    }

    public void setBranchAddressL2(String branchAddressL2) {
        this.branchAddressL2 = branchAddressL2;
    }

    public Vector getBranchAreas() {
        return branchAreas;
    }

    public void setBranchAreas(Vector branchAreas) {
        this.branchAreas = branchAreas;
    }

    public double getBranchDelivery() {
        return branchDelivery;
    }

    public void setBranchDelivery(double branchDelivery) {
        this.branchDelivery = branchDelivery;
    }

    public double getBranchDiscount() {
        return branchDiscount;
    }

    public void setBranchDiscount(double branchDiscount) {
        this.branchDiscount = branchDiscount;
    }

    public boolean isBranchExtraRates() {
        return branchExtraRates;
    }

    public void setBranchExtraRates(boolean branchExtraRates) {
        this.branchExtraRates = branchExtraRates;
    }

    public Vector getBranchItems() {
        return branchItems;
    }

    public void setBranchItems(Vector branchItems) {
        this.branchItems = branchItems;
    }

    public String getBranchLogo() {
        return branchLogo;
    }

    public void setBranchLogo(String branchLogo) {
        this.branchLogo = branchLogo;
    }

    public String getBranchMenuLogo() {
        return branchMenuLogo;
    }

    public void setBranchMenuLogo(String branchMenuLogo) {
        this.branchMenuLogo = branchMenuLogo;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchNameL2() {
        return branchNameL2;
    }

    public void setBranchNameL2(String branchNameL2) {
        this.branchNameL2 = branchNameL2;
    }

    public boolean isBranchOnline() {
        return branchOnline;
    }

    public void setBranchOnline(boolean branchOnline) {
        this.branchOnline = branchOnline;
    }

    public Vector getBranchRates() {
        return branchRates;
    }

    public void setBranchRates(Vector branchRates) {
        this.branchRates = branchRates;
    }

    public Vector getBranchRules() {
        return branchRules;
    }

    public void setBranchRules(Vector branchRules) {
        this.branchRules = branchRules;
    }

    public double getBranchTaxes() {
        return branchTaxes;
    }

    public void setBranchTaxes(double branchTaxes) {
        this.branchTaxes = branchTaxes;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }

    public short getDayOff() {
        return dayOff;
    }

    public void setDayOff(short dayOff) {
        this.dayOff = dayOff;
    }

    public int getDeliverIn() {
        return deliverIn;
    }

    public void setDeliverIn(int deliverIn) {
        this.deliverIn = deliverIn;
    }

    public double getDiscout() {
        return discout;
    }

    public void setDiscout(double discout) {
        this.discout = discout;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMultiAreaRules() {
        return multiAreaRules;
    }

    public void setMultiAreaRules(boolean multiAreaRules) {
        this.multiAreaRules = multiAreaRules;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getParentStatus() {
        return parentStatus;
    }

    public void setParentStatus(int parentStatus) {
        this.parentStatus = parentStatus;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public boolean isRules() {
        return rules;
    }

    public void setRules(boolean rules) {
        this.rules = rules;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public static Vector parseCategoryBraches(SoapObject soap, Category parent) {
        Vector areas = new Vector();
        SoapObject content;
        Branch a;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            a = new Branch(parent);
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
//                    case 0:
//                        a.setAreaName(s);
//                        break;
//                    case 1:
//                        a.setAreaNameL2(s);
//                        break;
//                    case 2:
//                        a.setAttachedToBranchID(Integer.parseInt(s));
//                        break;
//                    case 3:
//                        // a.setCountryId(Integer.parseInt(s));
//                        break;
//                    case 4:
//                        // a.setFlashIndex(Integer.parseInt(s));
//                        break;
//                    case 5:
//                        a.setId(Integer.parseInt(s));
//                        break;
//                    case 6:
//                        // a.setSsoID(Integer.parseInt(s));
//                        break;
//                    case 7:
//                        a.setSsoID(Integer.parseInt(s));
//                        break;
//                    case 8:
//                        a.setIsActive((s.equals("true")) ? true : false);
//                        break;
                }
            }
            areas.addElement(a);

        }
        System.out.println("Found Branches:" + areas.size());

        return areas;
    }

    public String toString() {
        return "Branch " + id + " : " + branchName;
    }
}
