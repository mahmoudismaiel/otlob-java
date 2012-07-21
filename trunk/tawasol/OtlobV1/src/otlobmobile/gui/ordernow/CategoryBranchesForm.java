/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.events.ActionEvent;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model.Category;
import otlobmobile.utils.GUIManager;
import otlobmobile.webclient.OtlobDataDisplayClient;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CategoryBranchesForm extends OtlobForm {

    private int[] fixed_IDs = new int[]{121013,121867};
    private Vector branches;
    private final Category category;

    public CategoryBranchesForm(AreaCategoriesForm parent, Category category) {
        super(parent, true, "Restaurants");
        this.category = category;
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (branches == null) {
            Runnable r = new Runnable() {

                public void run() {
                    /*use areaID -1 to get all the categories*/
                    SoapObject o = OtlobDataDisplayClient.getBranchesByAreaIDCategoryID(OtlobMidlet.CULTURE,
                                                    category.getArea().getId(),
                                                    category.getId(),
                                                    2);
                                                   // category.getArea().getCity().getCountryId());
                    System.out.println("Branches: \n" + o.toString());
                    //branches = Category.parseAreaCategories(o, category);


                }
            };
            try {
                GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
//        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//        for (int i = 0; i < categories.size(); i++) {
//            Category cat = (Category) categories.elementAt(i);
//            ObjectButton b = new ObjectButton(cat, cat.getCategoryName());
//            b.addActionListener(enter);
//            b.setAlignment(CENTER);
//            b.getSelectedStyle().setBgColor(0xEEA336, true);
//            b.getSelectedStyle().setFgColor(0x000000, true);
//            addComponent(b);
//        }
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
