/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Display;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.plaf.Style;
import otlobmobile.gui.OtlobForm;

/**
 * This class represents a Form Object contains an Imgae + Description
 *
 * @author Mitch RM
 * @version 1.0
 */
public class ImageDescriptionForm extends OtlobForm {

    /**
     * The Description TextArea
     */
    protected TextArea description;
    /**
     * The Image Label
     */
    protected Label image;
    /**
     * Specifies weather the Text should scrool with image or not
     */
    protected boolean isImageScrollable;
    /**
     * The Component Container if the Image is scrollable
     * @see DataContainer
     */
    protected DataContainer dc;

    /**
     * creates a new instance of ImageDescriptionForm
     * <p>
     * It could be used as a News Reader, Offer Reader or any item that represented by an Image and the item's decription
     * @param parent the Form's caller    
     * @param titleBg the Form's Title BgImage name
     * @param isImageScrollable specifies whether you want the item's image to be Scrollable with text or not
     */
    public ImageDescriptionForm(OtlobForm parent, String titleBg, boolean isImageScrollable) {
        super(parent, false, titleBg);
        this.isImageScrollable = isImageScrollable;
        dc = new DataContainer();
    }

    /**
     * sets the Form components
     * @param desc the Description Text
     * @param i the Form Image
     */
    public void setParameters(TextArea desc, Label i) {
        Style s;
        image = new Label();
        if (i != null) {
            image.setIcon(i.getIcon());
            image.setAlignment(Label.CENTER);
            s = this.image.getStyle();
            s.setBorder(null);
            s.setBgTransparency(00);
        } else {
            image = null;
        }


        description = new TextArea();
        description.setText(desc.getText());
        description.setRows(2);
        description.setEditable(false);
        description.setGrowByContent(true);
        description.getSelectedStyle().setBorder(null);
        description.getSelectedStyle().setBgTransparency(00);
        description.getSelectedStyle().setFgColor(description.getUnselectedStyle().getFgColor());
        fillFormComponents();
    }

    /**
     * {@inheritDoc}
     */
    public void fillFormComponents() {
        setScrollable(false);
        if (isImageScrollable) {
            setUpAsImageScrollable();
        } else {
            setUpAsImageNotScrollable();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getCommand().getId()) {
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
        }
    }

    /**
     * the device key listener
     * @param keyCode the key code
     */
    public void keyPressed(int keyCode) {
        if (isImageScrollable) {
            switch (keyCode) {
                //Up pressed
                case -1:
                    dc.keyPressed(Display.GAME_UP);
                    break;
                //Down pressed
                case -2:
                    dc.keyPressed(Display.GAME_DOWN);
                    break;
                default:
                    super.keyPressed(keyCode);
            }
        } else {
            super.keyPressed(keyCode);
        }
    }

    /**
     * Sets up the Form As the Image will be scrollable with the desciption lines
     */
    protected void setUpAsImageScrollable() {
        removeAll();
        dc.removeAll();
        if (image != null) {
            dc.addComponent(image);
        }
        TextManager.addText(dc, description, (int) (GUIManager.DISPLAY_WIDTH * 0.80));
        if (!contains(dc)) {
            addComponent(dc);
        }
    }

    /**
     * set up the Form As the Image location is fixed and the description will be a scrollable TextArea
     */
    protected void setUpAsImageNotScrollable() {
        removeAll();
        if (image != null) {
            addComponent(image);
        }
        addComponent(description);
    }
}
