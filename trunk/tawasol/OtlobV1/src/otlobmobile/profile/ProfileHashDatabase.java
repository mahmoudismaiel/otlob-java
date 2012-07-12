package otlobmobile.profile;

import otlobmobile.model.Profile;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Enumeration;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/**
 * Profile database is responsible for managing the user {@link Profile}
 *
 * @author Mitch RM
 * @version 1.0
 */
public class ProfileHashDatabase {

    private static final String ID = "_id";
    private static final String NAME = "_n";
    private static final String TEL = "_t";
    private static final String GENDER = "_g";
    private static final String AGE = "_a";
    private static final String EMAIL = "_e";
    /**
     * The Profile database name
     */
    private static final String DB_NAME = "D_L_PROFILE";
    /**
     * The profile date look-up hash
     */
    private Hashtable Hashtable;
    private boolean empty = false;
    private RecordStore profileDB;

    /**
     * Creates a new instance of {@link ProfileHashDatabase}
     */
    public ProfileHashDatabase() {
        Hashtable = new Hashtable();
        try {
            profileDB = RecordStore.openRecordStore(DB_NAME, false);
        } catch (RecordStoreException ex) {
            empty = true;
        }
    }

    /**
     * Returns weather the database is empty or not
     *
     * @return{@code true} if empty, {@code false} if not
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Saves a {@link Profile} instance into the database
     * 
     * @param profile the Profile instance
     * @return {@code true} if saved, {@code false} if not or error happened
     */
    public boolean saveProfile(Profile profile) {
        try {
            if (!isEmpty()) {
                RecordStore.deleteRecordStore(DB_NAME);
            }
            addProfileToDatabase(profile);
            save();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Stores a {@link Profile} into a {@link #DB_NAME} RecordStore
     * 
     * @param p the Profile instance
     * @throws Exception if error happends while saving
     */
    private void addProfileToDatabase(Profile p) throws Exception {
        //Adding the id
        put(ID, String.valueOf(p.getId()).getBytes("UTF-8"));
        //Adding the name
        put(NAME, p.getName().getBytes("UTF-8"));
        //Adding the tel
        put(TEL, p.getTel().getBytes("UTF-8"));
        //Adding the gender
        put(GENDER, String.valueOf(p.getGender()).getBytes("UTF-8"));
        //Adding the age
        put(AGE, p.getAge().getBytes("UTF-8"));
        //Adding the email
        put(EMAIL, p.getEmail().getBytes("UTF-8"));
    }

    /**
     * Loads a {@link Profile} instance from a {@link #DB_NAME} RecordStore
     * 
     * @return the Profile instance
     * @throws RecordStoreException if errors happends while loading
     */
    public Profile loadProfile() throws RecordStoreException {
        RecordEnumeration re = null;
        try {
            //load Profile Data
            profileDB = RecordStore.openRecordStore(DB_NAME, true);
            re = profileDB.enumerateRecords(null, null, false);
            while (re.hasNextElement()) {
                byte[] raw = re.nextRecord();
                String pref = new String(raw);
                // Parse out the name.
                int index = pref.indexOf('|');
                String name = pref.substring(0, index);
                String value = pref.substring(index + 1);
                put(name, value.getBytes());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            re.destroy();
            profileDB.closeRecordStore();
        }
        return createProfile();
    }

    /**
     * Saves the values of {@link #Hashtable} into the profile RecordStore
     *
     * @throws Exception if errors happends while saving
     */
    private void save() throws Exception {
        try {
            profileDB = RecordStore.openRecordStore(DB_NAME, true);
            Enumeration keys = Hashtable.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                String value = new String(get(key));
                String pref = key + "|" + value;
                byte[] raw = pref.getBytes();
                profileDB.addRecord(raw, 0, raw.length);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (profileDB != null) {
                profileDB.closeRecordStore();
            }
        }
    }

    private Profile createProfile() {
        Profile profile = new Profile();
        try {
            profile.setId(Integer.parseInt(new String(get(ID), "UTF-8")));
            profile.setTel(new String(get(TEL), "UTF-8"));
            profile.setEmail(new String(get(EMAIL), "UTF-8"));
            profile.setAge(new String(get(AGE), "UTF-8"));
            profile.setGender(new String(get(GENDER), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return profile;

    }

    private void put(String key, byte[] value) {
        Hashtable.put(key, value);
    }

    private byte[] get(String key) {
        return (byte[]) Hashtable.get(key);
    }
}
