/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.events.ActionEvent;
import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model2.Branch2;
import otlobmobile.model2.Category2;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobGatewayV3Client;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CategoryBranchesForm extends OtlobForm {

    //private int[] fixed_IDs = new int[]{121013, 121867};
    private Vector branches;
    private final Category2 category;
    private final Hashtable menuForms;

    public CategoryBranchesForm(AreaCategoriesForm parent, Category2 category) {
        super(parent, true, "Restaurants");
        this.category = category;
        menuForms = new Hashtable();
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (branches == null) {
            Runnable r = new Runnable() {

                public void run() {
                    SoapObject o = OtlobGatewayV3Client.getBranchesByAreaIDCategoryID(OtlobMidlet.CULTURE, category.getArea().getId(), category.getId(), 2);

                    branches = Branch2.parseBranchProfile(o, category, category.getArea());


                    for (int j = 0; j < branches.size(); j++) {


                        Branch2 branch = (Branch2) branches.elementAt(j);
//                        ObjectButton btn = new ObjectButton(branch.getBranchName());
//                        btn.setObject(branch);
//                        btn.addActionListener(enter);
//                        btn.setIcon(GUIManager.loadImage(branch.getBranchMenuLogo()));
//                        btn.getSelectedStyle().setBgColor(0xEEA336, true);
//                        btn.getSelectedStyle().setFgColor(0x000000, true);
                        addComponent(Branch2.addStaticContainer(branch, enter));

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
        final ObjectButton focused = (ObjectButton) getFocused();
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);
                Branch2 branch = (Branch2) (focused).getObject();
                System.out.println(branch);
                if (branch.isClosed()) {
                    GUIManager.showMessage("Error", "This restaurant is closed right now, please come back later.",Dialog.TYPE_ERROR );
                } else {
                    if (!menuForms.containsKey(focused)) {
                         menuForms.put(focused, new BranchMenuForm(this, branch));
                    }
                     ((BranchMenuForm) menuForms.get(focused)).show();
                }

                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
