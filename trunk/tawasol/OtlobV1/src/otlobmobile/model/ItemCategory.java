/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

/**
 *
 * @author Mahmoud.Ismail
 */
public class ItemCategory {
    
      //Static Otlob Web Service parameters for getting ItemCategory data 
    public static final String NAMESPACE = "http://tempuri.org/";
    public static final String METHOD_NAME_FOR_MOBILE = "GetMenuForMobile";
    public static final String SOAP_ACTION_FOR_MOBILE = "http://tempuri.org/IDataDisplayingWCF/GetMenuForMobile";
    public static final String METHOD_NAME= "GetMenu";
    public static final String SOAP_ACTION = "http://tempuri.org/IDataDisplayingWCF/GetMenu";
    
    private int id;
    private String itemCatName;
    private String itemCatNameL2;
    private String itemCatDesc;
    private String itemCatDescL2;
    private String itemCatImage;
    private int orderCount;
    private Provider provider;

    public ItemCategory() {
    }

    public ItemCategory(int id, String itemCatName, String itemCatNameL2, String itemCatDesc, String itemCatDescL2, String itemCatImage, int orderCount, Provider provider) {
        this.id = id;
        this.itemCatName = itemCatName;
        this.itemCatNameL2 = itemCatNameL2;
        this.itemCatDesc = itemCatDesc;
        this.itemCatDescL2 = itemCatDescL2;
        this.itemCatImage = itemCatImage;
        this.orderCount = orderCount;
        this.provider = provider;
    }

    
    public ItemCategory( Provider provider) {
        this.provider = provider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemCatDesc() {
        return itemCatDesc;
    }

    public void setItemCatDesc(String itemCatDesc) {
        this.itemCatDesc = itemCatDesc;
    }

    public String getItemCatDescL2() {
        return itemCatDescL2;
    }

    public void setItemCatDescL2(String itemCatDescL2) {
        this.itemCatDescL2 = itemCatDescL2;
    }

    public String getItemCatImage() {
        return itemCatImage;
    }

    public void setItemCatImage(String itemCatImage) {
        this.itemCatImage = itemCatImage;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    
    
    
            
    
}
