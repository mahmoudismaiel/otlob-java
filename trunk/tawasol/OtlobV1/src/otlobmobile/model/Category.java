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
public class Category {
    //Static Otlob Web Service parameters

    public static final String NAMESPACE = "http://tempuri.org/";
    public static final String METHOD_NAME = "GetCategoriesByAreaID";
    //public static final String METHOD_NAME = "GetAllCategories";
    public static final String SOAP_ACTION = "http://tempuri.org/IDataDisplayingWCF/GetCategoriesByAreaID";
    //Class fields
    private String categoryName;
    private String categoryNameL2;
    private int id;
    private Area parent;
    
    public Category() {
    }
    
    public Category(Area parent) {
        this.parent = parent;
    }
    
    
    public Category(String categoryName, String categoryNameL2, int id, Area parent) {
        this.categoryName = categoryName;
        this.categoryNameL2 = categoryNameL2;
        this.id = id;
        this.parent = parent;
    }
    
    public String getCategoryName() {
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public String getCategoryNameL2() {
        return categoryNameL2;
    }
    
    public void setCategoryNameL2(String categoryNameL2) {
        this.categoryNameL2 = categoryNameL2;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Area getArea() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }
    
    
    public static Vector parseAreaCategories(SoapObject soap, Area parent) {
        Vector categories = new Vector();
        SoapObject content;
        Category cat;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            cat = new Category(parent);
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        //category providers always set to null
                        break;
                    case 1:
                        cat.setCategoryName(s);
                        break;
                    case 2:
                        cat.setCategoryNameL2(s);
                        break;
                    case 3:
                        cat.setId(Integer.parseInt(s));
                        break;
                }
            }
            categories.addElement(cat);
        }
       // System.out.println("Found Categories:" + categories.size());
        
        if (categories.size() > 0) {
            categories.insertElementAt(new Category("All Categories", null, -1, parent), 0);
        }
        return categories;
    }
    
    public String toString() {
        return "Category " + id + " : " + categoryName;
    }
}
