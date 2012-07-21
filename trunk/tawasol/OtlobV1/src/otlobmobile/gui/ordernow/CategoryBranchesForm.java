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
import otlobmobile.model.Branch;
import otlobmobile.model.Category;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobDataDisplayClient;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CategoryBranchesForm extends OtlobForm {

    private int[] fixed_IDs = new int[]{121013, 121867};
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
                    for (int i = 0; i < fixed_IDs.length; i++) {
                        SoapObject o = OtlobDataDisplayClient.getBranchProfile(OtlobMidlet.CULTURE,
                                fixed_IDs[i],
                                category.getArea().getId());
                        // category.getArea().getCity().getCountryId());
                        System.out.println("Branch" + o.toString());

                        //branches = Branch.parseBranchProfile(o, category,category.getArea());

                        //for (int j = 0; j < branches.size(); j++) {
                        //    Branch branch = (Branch)branches.elementAt(j);
                        Branch branch = Branch.parseBranchProfile(o, category, category.getArea());
                        ObjectButton btn = new ObjectButton(branch.getBranchName());
                        btn.setObject(branch);
                        btn.addActionListener(enter);
                        btn.setIcon(GUIManager.loadImage(branch.getBranchMenuLogo()));
                        btn.getSelectedStyle().setBgColor(0xEEA336, true);
                        btn.getSelectedStyle().setFgColor(0x000000, true);
                        addComponent(btn);

                        //}

                    }




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
