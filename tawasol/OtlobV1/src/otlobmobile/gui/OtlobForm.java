/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui;

import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;
import otlobmobile.utils.GUIManager;

/**
 * This is our project Form template and each new class
 * should extend it
 *
 * @author Mitch RM
 * @since MIDP 2.0,CLDC 1.1
 * @version 1.0
 */
public abstract class OtlobForm extends Form implements ActionListener {

    public static String IMAGES_PATH = "/resources/images/sections/";
    protected String BANNERS_PATH = "/resources/images/banners";
    protected final int RUN_COMMAND = 1;
    protected final int BACK_COMMAND = 2;
    protected final int EXIT_COMMAND = 3;
    protected final int DIAL_COMMAND = 4;
    protected final Command back = new Command("Back", BACK_COMMAND);
    protected final Command enter = new Command("Enter", RUN_COMMAND);
    protected final Command exit = new Command("Exit", EXIT_COMMAND);
    protected final Command dial = new Command("Dial", DIAL_COMMAND);
    protected OtlobForm parent;

    /**
     * The project Form template which extends LWUIT.Form
     * @param parent the form's parent (if needed)
     * @param isParent specifies if this form is parent or not
     * @param titleBg the title component's BgImage
     */
    public OtlobForm(OtlobForm parent, boolean isParent, String titleBg) {
        super(" ");
        this.parent = parent;

        //Default Layout
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        //getTitleStyle().setBgImage(GUIManager.getImage(BANNERS_PATH, titleBg));
        getTitleStyle().setFgColor(0);
        getTitleStyle().setMargin(0, 0, 0, 0);
        getTitleStyle().setPadding(0, 0, 0, 0);
        setTitle(titleBg);
        getContentPane().getStyle().setBgImage(GUIManager.getImage("", "bodyBg"));
        if (parent != null) {
            addCommand(back);
            setBackCommand(back);
        } else {
            addCommand(exit);
            setBackCommand(exit);
        }
        if (isParent) {
            addCommand(enter);
            setDefaultCommand(enter);
        }
        addCommandListener(this);
        setMenuTransitions(GUIManager.SLIDE_LEFT, GUIManager.SLIDE_RIGHT);
    }

    /**
     * This method is resposible of Filling the OtlobForm content
     */
    public abstract void fillFormComponents();

    /**
     * The form Action Listener
     * @param evt the action event handler
     */
    public abstract void actionPerformed(ActionEvent evt);
}
