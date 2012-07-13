/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model.Area;
import otlobmobile.model.Category;
import otlobmobile.model.City;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobDataDisplayClient;

/**
 *
 * @author Mahmoud.Ismail
 */
public class AreaCategoriesForm extends OtlobForm {

    private Vector categories;
    private final Area area;

    public AreaCategoriesForm(CityAreasForm parent, Area area) {
        super(parent, true, "Categories");
        this.area = area;
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (categories == null) {
            Runnable r = new Runnable() {

                public void run() {
                    /*use areaID -1 to get all the categories*/
                    SoapObject o = OtlobDataDisplayClient.GetCategoriesByAreaID(OtlobMidlet.CULTURE, area.getId());
                    System.out.println("Categoris: \n"+o.toString());
                    categories = Category.parseAreaCategories(o, area);
                }
            };
            try {
                GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        for (int i = 0; i < categories.size(); i++) {
            Category cat = (Category) categories.elementAt(i);
            ObjectButton b = new ObjectButton(cat, cat.getCategoryName());
            b.addActionListener(enter);
            b.setAlignment(CENTER);
            b.getSelectedStyle().setBgColor(0xEEA336, true);
            b.getSelectedStyle().setFgColor(0x000000, true);
            addComponent(b);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);
//                if (getFocused() instanceof ObjectButton) {
//                    City c = (City) ((ObjectButton)getFocused()).getObject();
//                    System.out.println(c);
//                }
                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
