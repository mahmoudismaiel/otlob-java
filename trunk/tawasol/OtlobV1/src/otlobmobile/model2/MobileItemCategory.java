/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model2;

import com.sun.lwuit.Label;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;

/**
 *
 * @author Mahmoud.Ismail
 */
public class MobileItemCategory {

    //Static Otlob Web Service parameters for getting ItemCategory data 
    public static final String NAMESPACE = "http://OtlobzService/";
    public static final String METHOD_NAME_FOR_MOBILE = "GetMenuForMobile";
    public static final String SOAP_ACTION_FOR_MOBILE = "http://OtlobzService/GetMenuForMobile";
    private int id;
    private String itemCatName;
    private String itemCatNameL2;
    private int orderCount;
    private Label orderCountLabel;
    private Branch2 branch;
    //index of Category in the Soap Object
    private int index;
   

    public MobileItemCategory() {
    }

    public MobileItemCategory(int id, String itemCatName, String itemCatNameL2, int orderCount, Branch2 branch) {
        this.id = id;
        this.itemCatName = itemCatName;
        this.itemCatNameL2 = itemCatNameL2;
        this.orderCount = orderCount;
        this.branch = branch;
    }

    public MobileItemCategory(Branch2 provider) {
        this.branch = provider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
    }

    public String getItemCatNameL2() {
        return itemCatNameL2;
    }

    public void setItemCatNameL2(String itemCatNameL2) {
        this.itemCatNameL2 = itemCatNameL2;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public Branch2 getProvider() {
        return branch;
    }

    public void setProvider(Branch2 provider) {
        this.branch = provider;
    }

    public Branch2 getBranch() {
        return branch;
    }

    public void setBranch(Branch2 branch) {
        this.branch = branch;
    }

    public Label getOrderCountLabel() {
        return orderCountLabel;
    }

    public void setOrderCountLabel(Label orderCountLabel) {
        this.orderCountLabel = orderCountLabel;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }    
    
    public static Vector praseMobileCategories(SoapObject soap, Branch2 b) {
        Vector categories = new Vector();
        SoapObject content;
        MobileItemCategory cat = null;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            //System.out.println("Count zz:"+content.getPropertyCount());
             cat = new MobileItemCategory(b); 
             cat.setIndex(i);
            for (int j = 0; j < content.getPropertyCount(); j++) {
               
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        //ExtensionData
                        break;
                    case 1:
                        //CategoryItems
                        break;
                    case 2:
                        cat.setId(Integer.parseInt(s));
                        break;
                    case 3:
                        cat.setItemCatName(s);
                        break;
                    case 4:
                        cat.setItemCatNameL2(s);
                        break;
                    case 5:
                        cat.setOrderCount(Integer.parseInt(s));
                        break;
                }
            }
            categories.addElement(cat);
        }        
        return categories;
    }

    public String toString() {
        return "MobileItemCategory "+id +" , name :" + itemCatName;
    }
    
    
}
