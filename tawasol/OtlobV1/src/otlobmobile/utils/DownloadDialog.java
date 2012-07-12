/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Label;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.util.Resources;
import java.io.IOException;

/**
 * This Class is used as a download progress bar for any background operation
 *
 * @author Mitch RM
 */
public class DownloadDialog {

    private Dialog dialog;

    /**
     * Returns the Dialog Component itself
     * @return theDialog instance
     */
    public Dialog getDialog() {
        return dialog;
    }
    private Label animatedLabel;
    private int top;

    /**
     * Creates a new Instance of DownloadDialog
     */
    public DownloadDialog() {
        dialog = new Dialog();
        dialog.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        dialog.setTransitionOutAnimator(CommonTransitions.createFade(400));
        dialog.setTransitionInAnimator(CommonTransitions.createFade(400));
        dialog.setScrollable(false);

        Label l = new Label("Now Loading...");
      //  l.setAlignment(Label.RIGHT);
        dialog.addComponent(l);

        try {
            Resources r = Resources.open("/dalili.res");
            animatedLabel = new Label(r.getImage("loading"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        animatedLabel.setAlignment(Label.CENTER);
       // dialog.registerAnimated(animatedLabel);
        dialog.addComponent(animatedLabel);

        dialog.setTransitionInAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, true, 500));
        dialog.setTransitionOutAnimator(CommonTransitions.createSlide(CommonTransitions.SLIDE_VERTICAL, false, 500));
         
        top = Display.getInstance().getDisplayHeight() - 100;
    }

    /**
     * Hides the dialog
     */
    public void hide() {
        dialog.dispose();
    }

    /**
     * Shows the dialog
     */
    public void show() {
        dialog.show(top, 0, 0, 0, false, false);
    }

   
}
