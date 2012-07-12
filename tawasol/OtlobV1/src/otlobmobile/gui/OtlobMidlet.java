package otlobmobile.gui;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import javax.microedition.io.Connector;
import javax.microedition.midlet.*;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

import otlobmobile.profile.ProfileManager;
import otlobmobile.utils.DownloadDialog;
import otlobmobile.utils.GUIManager;

/**
 * The main Application Entry point
 * 
 * @author Mitch RM
 * @version 1.0
 */
public class OtlobMidlet extends MIDlet {

    public static final String CULTURE = "ar-EG";
    public static final String CULTURE_AR = "ar-EG";
    public static final String CULTURE_EN = "en-US";
    
    private static OtlobMidlet me = null;
    private static Dialog loading;
    private MainScreenForm firstForm;

    /**
     * {@inheritDoc }
     */
    public void startApp() {
        me = this;
        Display.init(this);
        Runnable startUp = new Runnable() {

            public void run() {
                try {
                    Resources r = Resources.open("/dalili.res");
                    UIManager.getInstance().setThemeProps(r.getTheme(r.getThemeResourceNames()[0]));
                    UIManager.getInstance().getLookAndFeel().setRTL(true);
                    UIManager.getInstance().setResourceBundle(r.getL10N("arabic", "ar"));
                    //Starts the application managers
                    start();
                } catch (Exception ex) {
                }
                firstForm = new MainScreenForm();
                loading = new DownloadDialog().getDialog();
            }
        };
        try {
            GUIManager.implementAsynchronousOperations(GUIManager.createSplashScreen(), startUp, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Show the first Form
        firstForm.show();
    }

    /**
     * Starts the Application managers
     */
    private void start() {
        
        //Initialize the Profile manager
        ProfileManager.init();

        //Initialize the Billing manager
//        BillingManager.init();
//        if (!BillingManager.isSubscribtionValid()) {
//            if (!BillingManager.renewSubscribe()) {
//                notifyDestroyed();
//            }
//        }

    }

    /**
     * {@inheritDoc }
     */
    public void pauseApp() {
    }

    /**
     * {@inheritDoc}
     */
    public void destroyApp(boolean unconditional) {
    }

    /**
     * Returns an loading-bar modal Dialog
     *
     * @return the loading Dialog
     */
    public static Dialog getLoadingDialog() {
        return loading;
    }

    /**
     * Sends a text SMS to a specified number
     * @param message the message content
     * @param number the reciever number
     */
    public static void sendSMS(String message, String number) {
        MessageConnection conn = null;
        try {
            conn = (MessageConnection) Connector.open("sms://" + number + ":1234");

            //generate a new text message
            TextMessage tmsg = (TextMessage) conn.newMessage(MessageConnection.TEXT_MESSAGE);
            //set the message text and the address
            tmsg.setPayloadText(message);
            //finally send our message
            if (conn != null) {
                conn.send(tmsg);
            }
        } catch (Exception ex) {
        }
    }

    /**
     * Returns the current running MIDlet
     * 
     * @return the running MIDlet
     */
    public static MIDlet getInstance() {
        return me;
    }
}
