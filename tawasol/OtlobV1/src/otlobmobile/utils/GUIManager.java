/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.animations.Transition;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.Layout;
import com.sun.lwuit.plaf.Border;
import com.sun.lwuit.plaf.Style;
import com.sun.lwuit.plaf.UIManager;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 * This Class is resposible for managing creating of most of the GUI Forms in the application
 *
 * @author Mitch RM
 * @version 1.0
 */
public class GUIManager {

    static final int PROGRESS_BACK = 11;
    /**
     * States the progress cancellation Message
     */
    public static String ProgressCancellationError = "Progress has been canclled by the user";
    /**
     * Slides the current Form to the RIGHT
     */
    public static final Transition SLIDE_RIGHT = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, true, 500);
    /**
     * Slides the current Form to the LEFT
     */
    public static final Transition SLIDE_LEFT = CommonTransitions.createSlide(CommonTransitions.SLIDE_HORIZONTAL, false, 500);
    /**
     * The application Form's Banner path
     */
    public static final String BANNER_PATH = "/resources/images/banners";
    /**
     * The application Form's Tab images path
     */
    public static final String TABS_PATH = "/resources/images/tabs";
    /**
     * Retrieves the Display's Width
     */
    public static final int DISPLAY_WIDTH = Display.getInstance().getDisplayWidth();
    /**
     * Retrieves the Display's Height
     */
    public static final int DISPLAY_HEIGHT = Display.getInstance().getDisplayHeight();
    /**
     * Retrieves the Display's Vertical Scroll width
     */
    public static final int VERTICAL_BAR_WIDTH = UIManager.getInstance().getLookAndFeel().getVerticalScrollWidth();

    /**
     * This method is used to get a PNG image from
     * a specifid <code>path</code> in the <code>classpath</code>
     * @param path the required image's path
     * @param name the required image's name
     * @return the created Image
     */
    public static Image getImage(String path, String name) {
        Image image = null;
        try {
            image = Image.createImage(path + "/" + name + ".png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return image;
    }

    /**
     * Loads an Image from a specific url
     * 
     * @param url the required Image Http url
     * @return the created Image
     */
    public static Image loadImage(String url) {
        HttpConnection hpc = null;
        DataInputStream dis = null;
        try {
            //fix url spaces  
            if (url.indexOf(" ") > -1) {
                url = replace(url, " ", "");
                url = url.trim();
            }
            

            hpc = (HttpConnection) Connector.open(url);
            int length = (int) hpc.getLength();
            byte[] data = new byte[length];
            dis = new DataInputStream(hpc.openInputStream());
            dis.readFully(data);

            return Image.createImage(data, 0, data.length);
        } catch (Exception ex) {
            System.out.println("Error at Image URL:"+url);
            //ex.printStackTrace();
           
        } finally {
            try {
                if (hpc != null) {
                    hpc.close();
                }
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * This method shows a Message Dialog
     * @param title represents Message title
     * @param message represents Message content
     * @param type represents Dilog type
     */
    public static void showMessage(String title, String message, int type) {
        Dialog.show(title, message, type, null, "رجوع", null);
    }

    public static String replace(String _text, String _searchStr, String _replacementStr) {
// String buffer to store str
        StringBuffer sb = new StringBuffer();

// Search for search
        int searchStringPos = _text.indexOf(_searchStr);
        int startPos = 0;
        int searchStringLength = _searchStr.length();

// Iterate to add string
        while (searchStringPos != -1) {
            sb.append(_text.substring(startPos, searchStringPos)).append(_replacementStr);
            startPos = searchStringPos + searchStringLength;
            searchStringPos = _text.indexOf(_searchStr, startPos);
        }

        // Create string
        sb.append(_text.substring(startPos, _text.length()));

        return sb.toString();
    }

    /**
     * This method is used to create a LWUIT Form
     * @param title represents Form's title
     * @param enter represents Form's DefaultCommand (if needed)
     * @param back represents Form's BackCommand 
     * @param titleBg specifies Form's title background image
     * @param layout specifies Form's layout (FlowLayout, Boxlayout, ....)
     * @param listener specifies Form's Action Listener
     * @return the created Form
     */
    public static Form createForm(String title, Command enter, Command back, String titleBg, Layout layout, ActionListener listener) {
        Form form = new Form(title);
        form.addCommand(back);
        form.setBackCommand(back);
        if (enter != null) {
            form.addCommand(enter);
            form.setDefaultCommand(enter);
        }
        form.setTransitionOutAnimator(SLIDE_LEFT);
        //form.setCommandListener(listener);
        form.addCommandListener(listener);
        form.getTitleStyle().setBgImage(getImage(BANNER_PATH, titleBg));
        form.getContentPane().getStyle().setBgImage(getImage("", "bodyBg"));
        form.setLayout((layout != null) ? layout : new BoxLayout(BoxLayout.Y_AXIS));
        return form;

    }

    /**
     * This method allows to create a LWUIT Form sections as
     * a bunch of Buttons in GridLayout Form
     * @param f the Form you want to create
     * @param names an Array contains the names of Form Sections
     * @param length the length of buttons's array
     * @param btnCommand the button Command
     * @param imagePath a path points to where the Section images resides
     * @param listener the form Action Listener
     * @param rotate specifies whether the sections rotates or not
     * @return returns <code>buttons</code> which reperesents form sections
     */
    public static ObjectButton[] createFormSections(Form f, String[] names, int length, Command btnCommand, String imagePath, ActionListener listener, boolean rotate) {
        ObjectButton[] buttons = new ObjectButton[length];
        for (int i = 0; i < names.length; i++) {
            if (imagePath != null) {
                if (rotate) {
                    buttons[i] = addButton("", btnCommand, f, getImage(imagePath, names[i] + "_Sel"), getImage(imagePath, names[i] + "_unsel"), true);
                } else {
                    buttons[i] = addStaticButton("", btnCommand, f, getImage(imagePath, names[i] + "_Sel"), getImage(imagePath, names[i] + "_unsel"));
                }
            } else {
                if (rotate) {
                    buttons[i] = addButton(names[i], btnCommand, f, null, null, true);
                } else {
                    buttons[i] = addStaticButton(names[i], btnCommand, f, null, null);
                }
            }
            buttons[i].setUIID("" + i);
        }
        return buttons;
    }

    /**
     * This method is used to add an unanimated ObjectButton to a specidic conatainer
     * @param btnText the button's text
     * @param cmd the button's Action Listener
     * @param parent the container where the button will be added
     * @param Sel the button's  rollover icon
     * @param unSel the button's icon
     * @return the created ObjectButton
     */
    public static ObjectButton addStaticButton(String btnText, Command cmd, Container c, Image Sel, Image unSel) {
        final ObjectButton b = new ObjectButton(btnText);
        b.addActionListener(cmd);
        if (Sel != null && unSel != null) {
            b.getSelectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
            b.getSelectedStyle().setBgTransparency(00);
            b.getUnselectedStyle().setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
            b.getUnselectedStyle().setBgTransparency(00);
            b.setRolloverIcon(Sel);
            b.setIcon(unSel);
            b.setAlignment(Button.CENTER);
        }
        c.addComponent(b);
        return b;
    }

    /**
     * This method is used to add a Container component which contains 
     * (ObjectButton + Image) to a specific container
     * @param newsButton instance of {@link ObjectButton} associated with {@link News} object
     * @param cmd the button's Action Listener
     * @param parent the container where the button will be added
     * @param fromStart if true, the created Container will be added on top of Container parent
     * @return the created Container
     */
//    public static Container addStaticContainer(ObjectButton newsButton, Command cmd, final Container parent, boolean fromStart) {
//        final Container cc = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        cc.getStyle().setPadding(0, 0, 0, 0);
//        cc.getStyle().setMargin(0, 0, 0, 0);
//        newsButton.addActionListener(cmd);
//        //      b.setTextPosition(ObjectButton.RIGHT);
//        //      b.setAlignment(ObjectButton.RIGHT);
//
//        Label imageLabel = new Label(((News) newsButton.getObject()).getThumbnail());
//        imageLabel.getStyle().setMargin(0, 0, 0, 5);
//
//        newsButton.setPreferredSize(new Dimension((int) ((GUIManager.DISPLAY_WIDTH * 0.97) - imageLabel.getPreferredW()), imageLabel.getPreferredH()));
//
//        cc.addComponent(imageLabel);
//        cc.addComponent(newsButton);
//
//        if (fromStart) {
//            parent.addComponent(0, cc);
//        } else {
//            parent.addComponent(cc);
//        }
//        return cc;
//    }
    /**
     * This method is used to add LWUIT ObjectButton to a specific <code>Container</code> or <code>Form</code>
     * @param btnText specifies the ObjectButton's text
     * @param cmd specifies the button's action listener
     * @param parent specifies the container where the button will be added
     * @param Sel represents button's rollover icon
     * @param unSel represents button's icon
     * @param verticalCube specifies the button rotation axis
     * @return the created button
     */
    public static ObjectButton addButton(String btnText, Command cmd, final Container c, Image Sel, Image unSel, boolean verticalCube) {
        final ObjectButton b = new ObjectButton(btnText);
        b.addActionListener(cmd);
        if (Sel != null) {
            b.setRolloverIcon(Sel);
        }
        if (unSel != null) {
            b.setIcon(unSel);
        }
        final Transition rotate = ((verticalCube) ? Transition3D.createVerticalCube(400, false) : Transition3D.createCube(400, true));
        b.addFocusListener(new FocusListener() {

            public void focusGained(Component cmp) {
                c.replace(b, b, rotate);
                c.revalidate();
            }

            public void focusLost(Component cmp) {
            }
        });
        // b.setAlignment(ObjectButton.CENTER);
        //  b.setTextPosition(ObjectButton.LEFT);
        b.getStyle().setBgTransparency(00);
        b.getStyle().setBorder(Border.createEmpty());
        c.addComponent(b);
        return b;
    }

    /**
     * Implements an operations while showing a specified Dialog
     * @param progress the specified Dialog  like {@link DownloadDialog}
     * @param operation the main operation
     * @param wait should the dialog wait or not
     * @throws Exception if the operation is interrupted
     */
    public static void implementAsynchronousOperations(final Dialog progress, final Runnable operation, boolean wait) throws Exception {
        Runnable r = new Runnable() {

            public void run() {
                operation.run();
                Runnable r = new Runnable() {

                    public void run() {
                        progress.dispose();
//#mdebug info
//                        System.out.println("Dispose the dialog");
//                        System.out.println("Free memeory =" + Runtime.getRuntime().freeMemory() + " Byte");

                        Display d = Display.getInstance();
//                        d = d;
//#enddebug
                    }
                };
                Display.getInstance().callSerially(r);

            }
        };
        final Thread th = new Thread(r);
        th.start();
        try {
            Command result = progress.showPacked(BorderLayout.SOUTH, wait);

            if (result != null && result.getId() == PROGRESS_BACK && wait) {
                throw new Exception(ProgressCancellationError);
            }

        } catch (Exception e) {
            //#debug error
//            System.out.println("Progress bar cancellation error Class=" + e.getClass() + " Exception= " + e);
            progress.dispose();
            th.interrupt();
            throw e;
        }

    }

    /**
     * Creates a Splash Dialog containing the splash screen image
     *
     * @return a splash Dialog
     */
    public static Dialog createSplashScreen() {
        Dialog splash = new Dialog();
        Style s = splash.getDialogStyle();
        s.setPadding(0, 0, 0, 0);
        s.setMargin(0, 0, 0, 0);
        splash.getTitleStyle().setMargin(0, 0, 0, 0);
        splash.getTitleStyle().setPadding(0, 0, 0, 0);
        Label l = new Label(getImage("", "splash"));
        Style labelStyle = splash.getStyle();
        labelStyle.setPadding(0, 0, 0, 0);
        labelStyle.setMargin(0, 0, 0, 0);
        splash.addComponent(l);

        return splash;
    }
}
