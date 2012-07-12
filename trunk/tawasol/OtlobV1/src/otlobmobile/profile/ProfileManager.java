/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.profile;

import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model.Profile;
import javax.microedition.rms.RecordStoreException;

/**
 *
 * @author Mitch RM
 */
public class ProfileManager {

    private static final String REFUND_NUMBER = "95234";
    private static ProfileHashDatabase profileDB;
    private static boolean registered;
    private static Profile currentProfile;

    /**
     * Initialize the ProfileManager and load the user profile (if existed)
     */
    public static void init() {
        profileDB = new ProfileHashDatabase();
        registered = !profileDB.isEmpty();
        if (registered == true) {
            currentProfile = getProfile();
        }
    }

    /**
     * Returns weather the user is registered or not
     *
     * @return {@code true} if registered, {@code false} if not
     */
    public static boolean isRegistered() {
        return registered;
    }

    /**
     * Sets the user Registeration case
     *
     * @param registered {@code true} for registered, {@code false} for unregistered
     */
    public static void setRegistered(boolean registered) {
        ProfileManager.registered = registered;
    }

    /**
     * Retruns the current user {@link Profile}
     *
     * @return the current user profile
     */
    public static Profile getCurrentProfile() {
        return currentProfile;
    }

    /**
     * Refunds a Profile account to a specific no. of days
     * 
     * @param profileID the {@link Profile} id
     * @param noOfDays no of days to extend Profile subscription
     */
    public static void refundProfile(int profileID, int noOfDays) {
        OtlobMidlet.sendSMS(profileID + "|" + noOfDays, REFUND_NUMBER);
    }

    /**
     * Sets the current user {@link Profile}
     * 
     * @param currentProfile the current user profile
     */
    public static void setCurrentProfile(Profile currentProfile) {
        ProfileManager.currentProfile = currentProfile;
    }

    /**
     * Saves the user profile into {@link ProfileHashDatabase}
     *
     * @param profile the new user {@link Profile}
     * @return {@code true} if saved, {@code false} if not
     */
    public static boolean saveProfile(Profile profile) {
        return profileDB.saveProfile(profile);
    }

    /**
     * Gets the current user {@link Profile} from {@link ProfileHashDatabase}
     *
     * @return the user profile if existed or {@code null} if not
     */
    private static Profile getProfile() {
        try {
            return profileDB.loadProfile();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
