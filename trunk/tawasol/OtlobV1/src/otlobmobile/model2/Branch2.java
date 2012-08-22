/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model2;

import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Label;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import org.ksoap2.serialization.SoapObject;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;

/**
 *
 * @author Mahmoud.Ismail
 */
public class Branch2 {

    //Static Otlob Web Service parameters for getting BRANCH data by Category2
    public static final String NAMESPACE = "http://OtlobzService/";
    public static final String METHOD_NAME = "GetBranchesByAreaIDCategoryID";
    public static final String SOAP_ACTION = "http://OtlobzService/GetBranchesByAreaIDCategoryID";
    //Static Otlob Web Service parameters for getting BRANCH profile
    public static final String METHOD_NAME_BRANCH_PROFILE = "GetBranchProfile";
    public static final String SOAP_ACTION_BRANCH_PROFILE = "http://tempuri.org/IDataDisplayingWCF/GetBranchProfile";
    //Class fields
    private Area2 area;
    private Category2 category;
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
    private boolean isClosed;
    private Provider2 provider;
    private int timeLimit;

    public Branch2() {
    }

    public Branch2(Category2 category, Area2 area) {
        this.category = category;
        this.area = area;
    }

    public String getOHstatusName() {
        return OHstatusName;
    }

    public void setOHstatusName(String OHstatusName) {
        this.OHstatusName = OHstatusName;
    }

    public Area2 getArea() {
        return area;
    }

    public void setArea(Area2 area) {
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

    public Category2 getCategory() {
        return category;
    }

    public void setCategory(Category2 category) {
        this.category = category;
    }

    public void setBranchExtraRates(boolean branchExtraRates) {
        this.branchExtraRates = branchExtraRates;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
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

    public Provider2 getProvider() {
        return provider;
    }

    public void setProvider(Provider2 provider) {
        this.provider = provider;
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
    public static Vector parseBranchProfile(SoapObject soap, Category2 category, Area2 area) {
        Vector branches = new Vector();
        SoapObject content;
        Branch2 b = null;
        Provider2 p = new Provider2();
        int currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            b = new Branch2(category, area);
            p = new Provider2();
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                //  System.out.println(s);

                switch (j) {
                    case 0:
                        //Extension Data
                        break;
                    case 1:
                        //AreaID 
                        break;

                    case 2:
                        b.branchLogo = s;
                        break;
                    case 3:
                        b.branchMenuLogo = s;
                        break;
                    case 4:
                        b.branchAddress = s;
                        break;
                    case 5:
                        b.branchDelivery = Double.parseDouble(s);
                        break;
                    case 6:
                        b.branchDiscount = Double.parseDouble(s);
                        break;
                    case 7:
                        b.branchMinCharge = Double.parseDouble(s);
                        b.branchMinCharge /= 1.0;
                        break;
                    case 8:
                        b.branchName = s;
                        break;
                    case 9:
                        b.branchTaxes = Double.parseDouble(s);
                        break;
                    case 10:
                        b.closingTime12h = s;
                        b.closingTime = convert(s);
                        break;
                    case 11:
                        b.deliverIn = Integer.parseInt(s);
                        break;
                    case 12:
                        b.id = Integer.parseInt(s);
                        break;
                    case 13:
                        //b.isClosed = s;

                        break;
                    case 14:
                        b.openingTime = Integer.parseInt(s);
                        //  System.out.println("O:" + b.openingTime + " , C:" + b.closingTime + " , T:" + currentTime);
                        b.isClosed = calculateIsClosed(b, currentTime);
                        break;
                    case 15:
                        b.openingTime12h = s;
                        break;
                    case 16:
                        p.id = Integer.parseInt(s);
                        break;
                }
            }
            b.setProvider(p);
            branches.addElement(b);
        }
        System.out.println("Found Branches:" + branches.size());
        b.setProvider(p);
        return branches;
    }

    public String toString() {
        return "Branch " + id + " : " + branchName + ", Provider ID:" + provider.id;
    }

    public static Container addStaticContainer(Branch2 branch, Command cmd) {
        final Container cc = new Container(new BoxLayout(BoxLayout.X_AXIS));
        cc.getStyle().setPadding(0, 0, 0, 0);
        cc.getStyle().setMargin(0, 0, 0, 0);
        ObjectButton btn = new ObjectButton(branch.getBranchName());
        btn.setObject(branch);
        btn.addActionListener(cmd);
        btn.setIcon(GUIManager.loadImage(branch.getBranchMenuLogo()));
        btn.getSelectedStyle().setBgColor(0xEEA336, true);
        btn.getSelectedStyle().setFgColor(0x000000, true);

        if (branch.isClosed) {
            Label closed = new Label(GUIManager.getImage("", "closed"));
            closed.getStyle().setMargin(0, 0, 0, 0);
            closed.getStyle().setPadding(0, 0, 0, 0);
            btn.setPreferredSize(new Dimension((int) ((GUIManager.DISPLAY_WIDTH * 0.98) - closed.getPreferredW()), closed.getPreferredH()));

            cc.addComponent(btn);
            cc.addComponent(closed);
        } else {
            btn.setPreferredW((int) ((GUIManager.DISPLAY_WIDTH * 0.98)));
            cc.addComponent(btn);
        }
        return cc;
    }

    static int convert(String time) {

        // System.out.println(time);
        // System.out.println(time.substring(time.indexOf(" ")).toUpperCase());
        boolean pm = "PM".equals(time.substring(time.indexOf(" ") + 1).toUpperCase());
        int h = Integer.parseInt(time.substring(0, time.indexOf(" ")));

        if (!pm) {
            if (h == 12) {
                h = 0;
            }
        } else {
            h = 12 + h;
        }
        //System.out.println("PM: " + pm + " , h:" + h);
        return h;
    }

    private static boolean calculateIsClosed(Branch2 b, int currentTime) {
        int o = b.openingTime;
        double c = b.closingTime;
        int t = currentTime;

        if (o == c) {
            return false;
        }

        if (o > c) {
            if (t < 12) {
                t += 24;
            }
            c += 24;
        }
        return t < o || t >= c;
    }
}