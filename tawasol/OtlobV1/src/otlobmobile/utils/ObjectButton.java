/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Image;

/**
 * This class is inhertied from com.sun.lwuit.Button <b>But,</b> the difference it the button
 * is associated with a specific Object (e.g. model object)
 *
 * @author Mitch RM
 * @version 1.0
 * @since MIDP2.0, CLDC1.1
 * @see Button
 */
public class ObjectButton extends Button {

    private Object object;

    /**
     * Constructs a button with an empty string for its text.
     */
    public ObjectButton() {
        super();
    }

    /**
     * Constructor a button with  object
     *
     * @param object object associated with the button
     */
    public ObjectButton(Object object) {
      super();
      setObject(object);
    }

    /**
     * Constructs a button with the specified text.
     *
     * @param text label appearing on the button
     */
    public ObjectButton(String text) {
        super(text);
    }

    /**
     * Allows binding a command to a button for ease of use
     *
     * @param cmd command whose text would be used for the button and would recive action events
     * from the button
     */
    public ObjectButton(Command cmd) {
        super(cmd);
    }

    /**
     * Constructs a button with the specified image.
     *
     * @param icon appearing on the button
     */
    public ObjectButton(Image icon) {
        super(icon);
    }

    /**
     * Constructor a button with text and object
     *
     * @param object object associated with the button
     * @param text label appearing on the button
     */
    public ObjectButton(Object object, String text) {
        super(text);
        setObject(object);
    }

    /**
     * Constructor a button with text and object and icon and also binding with command
     *
     * @param object object associated with the button
     * @param text label appearing on the button
     * @param icon image appearing on the button
     * @param cmd command whose text would be used for the button and would recive action events
     */
    public ObjectButton(Object object, String text, Image icon, Command cmd) {
        super(cmd);
        this.object = object;
        setText(text);
        setIcon(icon);
    }

    /**
     * Returns the button object
     * 
     * @return the associated object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets the button associated object
     * 
     * @param object object associated with the button
     */
    public void setObject(Object object) {
        this.object = object;
    }
}
