/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.Button;
import com.sun.lwuit.Container;
import com.sun.lwuit.Font;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.GridLayout;
import com.sun.lwuit.plaf.UIManager;
import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model2.Branch2;
import otlobmobile.model2.MobileItemCategory;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobGatewayV3Client;

/**
 *
 * @author Mahmoud.Ismail
 */
public class BranchMenuForm extends OtlobForm {

    private Vector categories;
    private Hashtable catItemsForms;
    private final Branch2 branch;
    private Label totalOrders, minCharge;
    private float ordersValue;
    private SoapObject categoriesObject;
    private final String currency;

    public BranchMenuForm(CategoryBranchesForm parent, Branch2 branch) {
        super(parent, true, "Menu");
        this.branch = branch;
        catItemsForms = new Hashtable();
        currency = UIManager.getInstance().localize("LE", "LE");
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (categories == null) {
            Runnable r = new Runnable() {

                public void run() {
                    categories = new Vector();
                    categoriesObject = OtlobGatewayV3Client.getMenuForMObile(OtlobMidlet.CULTURE, branch.getId(), branch.getProvider().getId());
                    categories = MobileItemCategory.praseMobileCategories(categoriesObject, branch);

                }
            };
            try {
                GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        System.out.println("Found Mobile Categories :" + categories.size());
        for (int i = 0; i < categories.size(); i++) {
            MobileItemCategory cat = (MobileItemCategory) categories.elementAt(i);
            Container catContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label catCount = new Label(" " + cat.getOrderCount() + " ");
            cat.setOrderCountLabel(catCount);
            catContainer.addComponent(catCount);
            ObjectButton b = new ObjectButton(cat, cat.getItemCatName());
            b.addActionListener(enter);
            b.setAlignment(CENTER);
            b.getSelectedStyle().setBgColor(0xEEA336, true);
            b.getSelectedStyle().setFgColor(0x000000, true);
            b.setPreferredW((int) (GUIManager.DISPLAY_WIDTH * 0.97 - catCount.getWidth()));
            catContainer.addComponent(b);
            addComponent(catContainer);
        }

        Container c = addFooterDetails();

        addComponent(c);

        //Add Dummy Button to make the bottom container scrollable
        Button dummy = new Button(" ");
        dummy.getUnselectedStyle().setBgTransparency(00);
        dummy.getSelectedStyle().setBgTransparency(00);
        dummy.setPreferredH(2);
        addComponent(dummy);
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        final Object o = getFocused();
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
                if (o instanceof ObjectButton) {
                    ObjectButton focused = (ObjectButton) o;
                    setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);

                    MobileItemCategory cat = (MobileItemCategory) (focused).getObject();
                    System.out.println(cat);
                    if (!catItemsForms.containsKey(focused)) {
                        final SoapObject itemsObject = (SoapObject) categoriesObject.getProperty(cat.getIndex());
                        catItemsForms.put(focused, new MenuCategoryForm(this, cat, (SoapObject) itemsObject.getProperty(1)));
                    }
                    ((MenuCategoryForm) catItemsForms.get(focused)).show();
                }

                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }

    private Container addFooterDetails() {        
        final Font smallFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        Container c = new Container(new GridLayout(1, 2));
        String s = UIManager.getInstance().localize("Total Orders:", "Total Orders:");
        s += ordersValue;
        s += " " + currency + " ";
        totalOrders = new Label(s);

        totalOrders.getStyle().setFont(smallFont);
        c.addComponent(totalOrders);

        s = UIManager.getInstance().localize("Min. Charge:", "Min. Charge:");
        s += branch.getBranchMinCharge();
        s += " " + currency + " ";
        minCharge = new Label(s);
        minCharge.getStyle().setFont(smallFont);
        c.addComponent(minCharge);
        //c.setScrollable(true);

        return c;
    }

    public void updateTotalOrders(float newOrdersValue) {
        ordersValue += newOrdersValue;

        String s = UIManager.getInstance().localize("Total Orders:", "Total Orders:");
        s += ordersValue;
        s += " " + currency + " ";
        totalOrders.setText(s);
        // invalidate();
        revalidate();
    }

    public String getCurrency() {
        return currency;
    }
}
