package otlobmobile.gui;

import com.sun.lwuit.Button;
import com.sun.lwuit.Component;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.GridLayout;
import com.sun.lwuit.plaf.Style;

import java.util.Hashtable;
import otlobmobile.gui.ordernow.CitiesForm;

import otlobmobile.utils.GUIManager;

/**
 * The MainScreen form of the Application
 *
 * @author Mitch RM
 * @version 1.0
 */
public class MainScreenForm extends OtlobForm {

    private final String BUTTONS_PATH = "/resources/images/buttons";
    private String[] otlobSectionsNames = new String[]{"ordernow", "lastorder", "favourite", "oldorders"};
    private Button[] otlobSections = new Button[otlobSectionsNames.length];    
    private Hashtable otlobForms;

    /**
     * creates a new instance of the application MainScreenForm
     */
    public MainScreenForm() {
        super(null, true, "main_Banner");
        otlobForms = new Hashtable();
        fillFormComponents();
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);
                navigateToForm((Button) getFocused());
                break;
            case EXIT_COMMAND:
//                Runnable r = new Runnable() {
//
//                    public void run() {
//                        try {
//                          //  LoggingManager.save();
//                        } catch (Exception ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                };
//                try {
//                    GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
                OtlobMidlet.getInstance().notifyDestroyed();
                break;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void fillFormComponents() {
       
        setLayout(new GridLayout(2, 2));
       
       
        for (int i = 0; i < otlobSections.length; i++) {
            otlobSections[i] = addSection(i);
            addComponent(otlobSections[i]);
        }
        
    }

    /**
     * The Main Form Navigator to all sections
     * 
     * @param focused the current Focused Button
     */
    private void navigateToForm(Button focused) {
        if (!otlobForms.containsKey(focused)) {
            if (focused.equals(otlobSections[0])) {
                  otlobForms.put(focused, new CitiesForm(this));
            }
            if (focused.equals(otlobSections[1])) {
                //  daliliForms.put(focused, new NewsForm(this));
            }
            if (focused.equals(otlobSections[2])) {
                //  daliliForms.put(focused, new BorsaForm(this));
            }
            if (focused.equals(otlobSections[3])) {
                //  daliliForms.put(focused, new EmergencyForm(this));
            }

        }
        ((OtlobForm) otlobForms.get(focused)).show();
    }

    /**
     * Add a new Section's Button to the {@code daliliSections} array
     * @param i the array index
     * @return the created Button
     */
    private Button addSection(final int i) {
       try{
        Button b = new Button(GUIManager.getImage(BUTTONS_PATH, otlobSectionsNames[i] + "_unsel"));
        b.setRolloverIcon(GUIManager.getImage(BUTTONS_PATH, otlobSectionsNames[i] + "_Sel"));
        b.setAlignment(Component.CENTER);
        b.getSelectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_ALIGNED);
        b.getSelectedStyle().setBgTransparency(0, true);
        b.getSelectedStyle().setMargin(0, 0, 0, 0);
        b.getSelectedStyle().setPadding(0, 0, 0, 0);
        b.setPressedStyle(b.getSelectedStyle());
        // b.setUnSelectedStyle(b.getSelectedStyle());
        b.setUnselectedStyle(b.getSelectedStyle());
        b.addActionListener(enter);       
        return b;
       }
       catch (Exception ex){
           //System.out.println("names "+otlobSectionsNames[i]);
           return null;
       }
    }
}
