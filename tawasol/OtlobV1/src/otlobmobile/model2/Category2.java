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
public class Category2 {
    //Static Otlob Web Service parameters

   public static final String NAMESPACE = "http://OtlobzService/";
    public static final String METHOD_NAME = "GetCategoriesByAreaID";
    public static final String SOAP_ACTION = "http://OtlobzService/GetCategoriesByAreaID";
    //Class fields
    private String categoryName;
    private int id;
    private Area2 parent;

    public Category2() {
    }

    public Category2(Area2 parent) {
        this.parent = parent;
    }

    public Category2(String categoryName, int id, Area2 parent) {
        this.categoryName = categoryName;
        this.id = id;
        this.parent = parent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Area2 getArea() {
        return parent;
    }

    public void setParent(Area2 parent) {
        this.parent = parent;
    }

    public static Vector parseAreaCategories(SoapObject soap, Area2 parent) {
        Vector categories = new Vector();
        SoapObject content;
        Category2 cat;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            cat = new Category2(parent);
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        // Extension Data
                        break;
                    case 1:
                        cat.setCategoryName(s);
                        break;                   
                    case 2:
                        cat.setId(Integer.parseInt(s));
                        break;
                }
            }
            categories.addElement(cat);
        }
        // System.out.println("Found Categories:" + categories.size());

        if (categories.size() > 0) {
            categories.insertElementAt(new Category2("All Categories", -1, parent), 0);
        }
        return categories;
    }

    public String toString() {
        return "Category " + id + " : " + categoryName;
    }
}
