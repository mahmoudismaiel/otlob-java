/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

/**
 *
 * @author Mahmoud.Ismail
 */
public class Branch implements KvmSerializable {

    //Static Otlob Web Service parameters for getting BRANCH data by Category
    public static final String NAMESPACE = "http://tempuri.org/";
    public static final String METHOD_NAME = "GetBranchesByAreaIDCategoryID";
    public static final String SOAP_ACTION = "http://tempuri.org/IDataDisplayingWCF/GetBranchesByAreaIDCategoryID";
    //Static Otlob Web Service parameters for getting BRANCH profile
    public static final String METHOD_NAME_BRANCH_PROFILE = "GetBranchProfile";
    public static final String SOAP_ACTION_BRANCH_PROFILE = "http://tempuri.org/IDataDisplayingWCF/GetBranchProfile";
    //Class fields
    private Area area;
    private Category category;
    private String branchAddress;
    private String branchAddressL2;
    private double branchDelivery;
    private double branchDiscount;
    private double branchMinCharge;
    private boolean branchExtraRates;
    private String branchName;
    private String branchNameL2;
    private boolean branchOnline;
    private double branchTaxes;
    private String branchLogo;
    private String branchMenuLogo;
    private double closingTime;
    private String closingTime12h;
    private short dayOff;
    private int deliverIn;
    private double discount;
    private String faxNumber;
    private int id;
    private boolean multiAreaRules;
    private String OHstatusName;
    private int openingTime;
    private String openingTime12h;
    private String isClosed;
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

    public Branch(Category category, Area area) {
        this.category = category;
        this.area = area;
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

    public double getBranchMinCharge() {
        return branchMinCharge;
    }

    public void setBranchMinCharge(double branchMinCharge) {
        this.branchMinCharge = branchMinCharge;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String isClosed() {
        return isClosed;
    }

    public void setClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public String getOpeningTime12h() {
        return openingTime12h;
    }

    public void setOpeningTime12h(String openingTime12h) {
        this.openingTime12h = openingTime12h;
    }

    public double getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(double closingTime) {
        this.closingTime = closingTime;
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

    public String getClosingTime12h() {
        return closingTime12h;
    }

    public void setClosingTime12h(String closingTime12h) {
        this.closingTime12h = closingTime12h;
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
        return discount;
    }

    public void setDiscout(double discout) {
        this.discount = discout;
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

    /**
     * Used by Get Branch profile
     * @param soap
     * @param category
     * @param area
     * @return
     */
    public static Branch parseBranchProfile(SoapObject soap, Category category, Area area) {
        // Vector branches = new Vector();
        // SoapObject content;
        Branch b = new Branch(category, area);
        Provider p = new Provider();

        for (int j = 0; j < soap.getPropertyCount(); j++) {
            String s = String.valueOf(soap.getProperty(j));
            switch (j) {
                case 6:
                    b.branchLogo = s;                    
                    break;
                case 8:
                    b.branchMenuLogo = s;
                    break;
                case 11:
                    b.branchAddress = s;
                    break;
                case 13:
                    b.branchDelivery = Double.parseDouble(s);
                    break;
                case 14:
                    b.branchDiscount = Double.parseDouble(s);
                    break;
                case 15:
                    b.branchExtraRates = (s.equals("true")) ? true : false;
                    break;
                case 16:
                    b.branchMinCharge = Double.parseDouble(s);
                    break;
                case 17:
                    b.branchName = s;
                    break;
                case 19:
                    b.branchOnline = (s.equals("true")) ? true : false;
                    break;
                case 21:
                    b.branchTaxes = Double.parseDouble(s);
                    break;
                case 26:
                    b.closingTime = Double.parseDouble(s);
                    break;
                case 27:
                    b.closingTime12h = s;
                    break;
                case 29:
                    b.dayOff = Short.parseShort(s);
                    break;
                case 30:
                    b.deliverIn = Integer.parseInt(s);
                    break;
                case 32:
                    b.discount = Double.parseDouble(s);
                    break;
                case 35:
                    b.id = Integer.parseInt(s);
                    break;
                case 36:
                    b.isClosed = s;
                    break;
                case 38:
                    b.multiAreaRules = (s.equals("true")) ? true : false;
                    break;
                case 40:
                    b.openingTime = Integer.parseInt(s);
                    break;
                case 41:
                    b.openingTime12h = s;
                    break;

                case 53:
                    p.id = Integer.parseInt(s);
                    break;
                case 54:
                    p.name = s;
                    break;
                case 56:
                    b.rules = (s.equals("true")) ? true : false;
                    break;
                default:

            }
            //branches.addElement(b);

        }
        //System.out.println("Found Branches:" + branches.size());
        b.setProvider(p);
        return b;
    }

    public String toString() {
        return "Branch " + id + " : " + branchName;
    }

    public Object getProperty(int i) {
        switch (i) {
            case 0:
                return new Integer(area.getId());
            case 1:
                return area.getAreaName();
            case 3:
                return new Integer(0);
            case 6:
                return branchLogo;
            case 8:
                return branchMenuLogo;
            case 11:
                return branchAddress;
            case 13:
                return new Double(branchDelivery).toString();
            case 14:
                return new Double(branchDiscount).toString();
            case 15:
                return (branchExtraRates ? Boolean.TRUE : Boolean.FALSE);
            case 16:
                return new Double(branchMinCharge).toString();
            case 17:
                return branchName;
            case 19:
                return (branchOnline ? Boolean.TRUE : Boolean.FALSE);
            case 20:
                return new Integer(0);
            case 21:
                return new Double(branchTaxes).toString();
            case 22:
                return new Integer(0);
            case 24:
                return new Integer(category.getId());
            case 25:
                return category.getCategoryName();
            case 26:
                return new Double(closingTime).toString();
            case 27:
                return closingTime12h;
            case 28:
                return new Integer(0);
            case 29:
                return new Integer(dayOff);
            case 30:
                return new Integer(deliverIn);
            case 31:
                return "+";
            case 32:
                return new Double(discount).toString();
            case 35:
                return new Integer(id);
            case 36:
                return isClosed;
            case 37:
                return new Integer(0);
            case 38:
                return (multiAreaRules ? Boolean.TRUE : Boolean.FALSE);
            case 40:
                return new Integer(openingTime);
            case 41:
                return openingTime12h;
            case 42:
                return new Integer(0);
            case 44:
                return new Integer(0);
            case 47:
                return new Integer(0);
            case 48:
                return new Integer(0);
            case 53:
                return new Integer(provider.getId());
            case 54:
                return provider.getName();
            case 56:
                return (rules ? Boolean.TRUE : Boolean.FALSE);
            case 61:
            case 62:
            case 63:
            case 64:
                return new Integer(0);
            default:
                return null;
        }
    }

    public int getPropertyCount() {
        return 65;
    }

    public void setProperty(int i, Object o) {
        Branch b = this;
        String s = o.toString();
        switch (i) {
            case 6:
                b.branchLogo = s;
                break;
            case 8:
                b.branchMenuLogo = s;
                break;
            case 11:
                b.branchAddress = s;
                break;
            case 13:
                b.branchDelivery = Double.parseDouble(s);
                break;
            case 14:
                b.branchDiscount = Double.parseDouble(s);
                break;
            case 15:
                b.branchExtraRates = (s.equals("true")) ? true : false;
                break;
            case 16:
                b.branchMinCharge = Double.parseDouble(s);
                break;
            case 17:
                b.branchName = s;
                break;
            case 19:
                b.branchOnline = (s.equals("true")) ? true : false;
                break;
            case 21:
                b.branchTaxes = Double.parseDouble(s);
                break;
            case 26:
                b.closingTime = Double.parseDouble(s);
                break;
            case 27:
                b.closingTime12h = s;
                break;
            case 29:
                b.dayOff = Short.parseShort(s);
                break;
            case 30:
                b.deliverIn = Integer.parseInt(s);
                break;
            case 32:
                b.discount = Double.parseDouble(s);
                break;
            case 35:
                b.id = Integer.parseInt(s);
                break;
            case 36:
                b.isClosed = s;
                break;
            case 38:
                b.multiAreaRules = (s.equals("true")) ? true : false;
                break;
            case 40:
                b.openingTime = Integer.parseInt(s);
                break;
            case 41:
                b.openingTime12h = s;
                break;

            case 53:
                b.getProvider().setId(Integer.parseInt(s));
                break;
            case 54:
                b.getProvider().setName(s);
                break;
            case 56:
                b.rules = (s.equals("true")) ? true : false;
                break;
            default:

        }
    }

    public void getPropertyInfo(int i, Hashtable hshtbl, PropertyInfo pi) {
        switch (i) {
            case 0:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "AreaID";
                break;
            case 1:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Area_Name";
                break;
            case 2:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "BR_Title";
                break;
            case 3:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "BR_Value";
                break;
            case 4:
                pi.type = PropertyInfo.VECTOR_CLASS;
                pi.name = "BranchAreas";
                break;
            case 5:
                pi.type = PropertyInfo.VECTOR_CLASS;
                pi.name = "BranchItems";
                break;
            case 6:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "BranchLogo";
                break;
            case 7:
                pi.type = PropertyInfo.VECTOR_CLASS;
                pi.name = "BranchMembers";
                break;
            case 8:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "BranchMenuLogo";
                break;
            case 9:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "BranchRates";
                break;
            case 10:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "BranchRules";
                break;
            case 11:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Branch_Address";
                break;
            case 12:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Address_L2";
                break;
            case 13:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Delivery";
                break;
            case 14:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Discount";
                break;
            case 15:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Discount";
                break;
            case 16:
                pi.type = PropertyInfo.BOOLEAN_CLASS;
                pi.name = "Branch_ExtraRates";
                break;
            case 17:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Mincharge";
                break;
            case 18:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Branch_Name";
                break;
            case 19:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Branch_Name_L2";
                break;
            case 20:
                pi.type = PropertyInfo.BOOLEAN_CLASS;
                pi.name = "Branch_Online";
                break;
            case 21:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "Branch_Order_ID";
                break;
            case 22:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Taxes";
                break;
            case 23:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Branch_Tips";
                break;
            case 24:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "BrancheRules";
                break;
            case 25:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "Category_Id";
                break;
            case 26:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Category_Name";
                break;
            case 27:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "ClosingTime";
                break;
            case 28:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "ClosingTime12h";
                break;
            case 29:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "CountryTimeZone";
                break;
            case 30:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "DayOff";
                break;
            case 31:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "DeliverIn";
                break;
            case 32:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Delivery_Charge_Type";
                break;
            case 33:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Discount";
                break;
            case 34:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "Discount_Type";
                break;
            case 35:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "FaxNumber";
                break;
            case 36:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "Id";
                break;
            case 37:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "IsClosed";
                break;
            case 38:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "MemberBranchPrice";
                break;
            case 39:
                pi.type = PropertyInfo.BOOLEAN_CLASS;
                pi.name = "MultiAreaRules";
                break;
            case 40:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OBranchHstatusName";
                break;
            case 41:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OpeningTime";
                break;
            case 42:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OpeningTime12h";
                break;
            case 43:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OrderBranchNumber";
                break;
            case 44:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OrderBranchStatus";
                break;
            case 45:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Branch_Name_L2";
                break;
            case 46:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OrderBranchStatusId";
                break;
            case 47:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OrderBranchStatusUiMessage";
                break;
            case 48:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "OrderBranchTrackingDate";
                break;
            case 49:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "OrderbranchPrice";
                break;
            case 50:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "Parent_Status";
                break;
            case 51:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Phone1";
                break;
            case 52:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Phone2";
                break;
            case 53:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Phone3";
                break;
            case 54:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "ProviderDescription";
                break;
            case 55:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "Provider_Id";
                break;
            case 56:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "Provider_Name";
                break;
            case 57:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "REASONBRANCH_TEXT";
                break;
            case 58:
                pi.type = PropertyInfo.BOOLEAN_CLASS;
                pi.name = "Rules";
                break;
            case 59:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "SHORTBranchNAME";
                break;
            case 60:
                pi.type = PropertyInfo.STRING_CLASS;
                pi.name = "SHORT_Branch_NAME2";
                break;
            case 61:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "StrDayOff";
                break;
            case 62:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "StrDayOffAREG";
                break;
            case 63:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "SubTotal";
                break;
            case 64:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "TimeLimit";
                break;
            case 65:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "TipsShare";
                break;
            case 66:
                pi.type = PropertyInfo.INTEGER_CLASS;
                pi.name = "UserOrderID";
                break;
            default:
                pi.type = PropertyInfo.OBJECT_CLASS;
                pi.name = "default";
        }
    }
}