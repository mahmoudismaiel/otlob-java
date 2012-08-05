/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model.Branch;
import otlobmobile.model.BranchForMobile;
import otlobmobile.model.Category;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobDataDisplayClient;

/**
 *
 * @author Mahmoud.Ismail
 */
public class BranchMenuForm extends OtlobForm {

    private Vector categories;
    private Hashtable catItemsForms;
    private final Branch branch;

    public BranchMenuForm(CategoryBranchesForm parent, Branch branch) {
        super(parent, true, "Menu");
        this.branch = branch;
        catItemsForms = new Hashtable();
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (categories == null) {
            Runnable r = new Runnable() {

                public void run() {                 
                    boolean closed = (branch.isClosed().equals("0"))?false:true;
//                    SoapObject o = OtlobDataDisplayClient.getMenuForMobile(OtlobMidlet.CULTURE,
//                                branch.getId(),
//                                branch.getProvider().getId(),
//                                closed);
                    SoapObject o = OtlobDataDisplayClient.getMenu(OtlobMidlet.CULTURE,
                                branch);
                        // category.getArea().getCity().getCountryId());
                        System.out.println("Menu " + o.toString());
                  
                    
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
        final ObjectButton focused = (ObjectButton) getFocused();
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
//                setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);
//
//                Category cat = (Category) (focused).getObject();
//               // System.out.println(cat);
//                if (!branchForms.containsKey(focused)) {
//                    branchForms.put(focused, new CategoryBranchesForm(this, cat));
//                }
//                ((CategoryBranchesForm) branchForms.get(focused)).show();
                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
