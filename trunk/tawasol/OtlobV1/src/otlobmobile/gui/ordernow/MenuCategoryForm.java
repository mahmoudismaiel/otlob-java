/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.Container;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model2.MobileItem;
import otlobmobile.model2.MobileItemCategory;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;

/**
 *
 * @author Mahmoud.Ismail
 */
public class MenuCategoryForm extends OtlobForm {

    private Vector items;    
    private final SoapObject itemsObject;
    private float ordersValue;
    private SoapObject categoryObject;
    private MobileItemCategory category;

    public MenuCategoryForm(BranchMenuForm parent, MobileItemCategory category, SoapObject itemsObject) {
        super(parent, true, "Category Items");
        this.parent = parent;
        parent = (BranchMenuForm) parent;

        this.category = category;
        this.itemsObject = itemsObject;
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (items == null) {
            Runnable r = new Runnable() {

                public void run() {

                    items = MobileItem.praseMobileItems(itemsObject, category);
                    setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                    
                    System.out.println("Found Category items :" + items.size());
                    for (int i = 0; i < items.size(); i++) {
                        MobileItem item = (MobileItem) items.elementAt(i);
                        Container catContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Label itemCount = new Label(" " + item.getQuantity() + " ");
                        item.setQuantityLabel(itemCount);
                        catContainer.addComponent(itemCount);

                        ObjectButton b = new ObjectButton(item, item.getDescription());
                        b.addActionListener(enter);
                        b.setAlignment(CENTER);
                        b.getSelectedStyle().setBgColor(0xEEA336, true);
                        b.getSelectedStyle().setFgColor(0x000000, true);

                        Label itemPrice = new Label(" " + item.getPrice() + " " + ((BranchMenuForm) parent).getCurrency());

                        itemPrice.getStyle().setBgColor(0xFF0000);
                        itemPrice.getStyle().setBgTransparency(00);
                        itemPrice.getStyle().setFgColor(0xFFFFFF);
                        catContainer.addComponent(itemPrice);
                        final double width = GUIManager.DISPLAY_WIDTH * 0.9 - (itemCount.getPreferredW() + itemPrice.getPreferredW());
                        //  System.out.println(width +", "+ itemCount.getPreferredW() + " , "+itemPrice.getPreferredW());
                        b.setPreferredW((int) (width));
                        b.setUIID("" + (i));
                        catContainer.addComponent(1, b);
                        addComponent(catContainer);
                    }
                }
            };
            try {
                GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        final Object o = getFocused();
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:


                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
