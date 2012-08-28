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
public class MobileItem {

    MobileItemCategory category;
    String comment;
    int is_id;
    int id;
    int categoryId;
    String description;
    String details;
    String image;
    double price;
    String itemSizeName;
    int quantity;
    
    private Label quantityLabel;

    public MobileItem(MobileItemCategory category) {
        this.category = category;
    }

    public MobileItemCategory getCategory() {
        return category;
    }

    public void setCategory(MobileItemCategory category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIs_id() {
        return is_id;
    }

    public void setIs_id(int is_id) {
        this.is_id = is_id;
    }

    public String getItemSizeName() {
        return itemSizeName;
    }

    public void setItemSizeName(String itemSizeName) {
        this.itemSizeName = itemSizeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Label getQuantityLabel() {
        return quantityLabel;
    }

    public void setQuantityLabel(Label quantityLabel) {
        this.quantityLabel = quantityLabel;
    }

    
    public static Vector praseMobileItems(SoapObject soap, MobileItemCategory cat) {
        Vector items = new Vector();
        SoapObject content;
        MobileItem item = null;
        for (int i = 0; i < soap.getPropertyCount(); i++) {
            content = (SoapObject) soap.getProperty(i);
            item = new MobileItem(cat);
            for (int j = 0; j < content.getPropertyCount(); j++) {
                String s = String.valueOf(content.getProperty(j));
                switch (j) {
                    case 0:
                        //ExtensionData
                        break;
                    case 1:
                        //BranchID
                        break;
                    case 2:
                        item.setIs_id(Integer.parseInt(s));
                        break;
                    case 3:
                        item.setId(Integer.parseInt(s));
                        break;
                    case 4:
                        item.setCategoryId(Integer.parseInt(s));
                        break;
                    case 5:
                        item.setDescription(s);
                        break;
                    case 6:
                        item.setDetails(s);
                        break;
                    case 7:
                        item.setImage(s);
                        break;
                    case 8:
                        item.setPrice(Double.parseDouble(s));
                        break;
                    case 9:
                        item.setItemSizeName(s);
                        break;
                    case 10:
                        item.setQuantity(Integer.parseInt(s));
                        break;
                }
            }
            items.addElement(item);
        }

        return items;
    }
}
