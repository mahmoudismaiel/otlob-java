/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Label;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.FlowLayout;

/**
 *
 * @author Mitch
 */
public class RequestDialog implements ActionListener {

    private Dialog dialog;
    private int top;
    private static final int YES_COMMAND = 3;
    private static final int NO_COMMAND = 4;
    private static final Command yes = new Command("نعم", YES_COMMAND);
    private static final Command no = new Command("لا", NO_COMMAND);
    private Label qMark, question, name;
    private boolean approve = false;

    /**
     * States weather the Requested is isApproved or not
     * @return {@code true} is isApproved , {@code false} if not
     */
    public boolean isApproved() {
        return approve;
    }

    /**
     * Creates a new instance of the RequestDialog
     * @param sectionName the section name you are requesting from.
     */
    public RequestDialog(String sectionName) {
        dialog = new Dialog();
        dialog.setLayout(new FlowLayout());
        dialog.setScrollable(false);

       

        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        question = new Label("Do you want to");
        question.setAlignment(Label.CENTER);
        question.getStyle().setBgTransparency(00);
        name = new Label(sectionName);
        name.setAlignment(Label.CENTER);
        name.getStyle().setBgTransparency(00);
        c.addComponent(question);
        c.addComponent(name);
        dialog.addComponent(c);

         qMark = new Label(GUIManager.getImage("/", "q_mark"));
        qMark.setAlignment(Label.CENTER);
        qMark.getStyle().setBgTransparency(00);
        qMark.getStyle().setMargin(0, 0, 0, 20);
        dialog.addComponent(qMark);
        
        dialog.addCommand(no);
        dialog.addCommand(yes);
        dialog.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 500));
        dialog.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, false, 500));
//        dialog.setCommandListener(this);
        dialog.addCommandListener(this);

        final Display d = Display.getInstance();
        top = d.getDisplayHeight() - 100;
    }

    /**
     *
     */
    public void hide() {
        dialog.dispose();
    }

    /**
     *
     */
    public void show() {
        dialog.show(top, 0, 0, 0, false);
        if (name.getText().length() > 30) {
            name.startTicker(50, false);
        }
    }

    /**
     *
     * @param evt
     */
    public void actionPerformed(ActionEvent evt) {
        int cmdID = ((Command) evt.getSource()).getId();
        approve = (cmdID == YES_COMMAND) ? true : false;
    }
}
