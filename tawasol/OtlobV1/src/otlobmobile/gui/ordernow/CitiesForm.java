/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.MainScreenForm;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model.City;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobDataDisplayClient;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CitiesForm extends OtlobForm {

    private Vector cities;
    private Hashtable areaForms;

    public CitiesForm(MainScreenForm parent) {
        super(parent, true, "Choose City");
        areaForms = new Hashtable();
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (cities == null) {
            Runnable r = new Runnable() {

                public void run() {
                    SoapObject o = OtlobDataDisplayClient.getCountryCities(OtlobMidlet.CULTURE, 2);
                    cities = City.parseCities(o);
                }
            };
            try {
                GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        for (int i = 0; i < cities.size(); i++) {
            City c = (City) cities.elementAt(i);
            ObjectButton b = new ObjectButton(c, c.getCityName());
            b.addActionListener(enter);
            b.setAlignment(CENTER);
            b.getSelectedStyle().setBgColor(0xff6600, true);
            b.getSelectedStyle().setFgColor(0x000000, true);
            addComponent(b);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        final ObjectButton focused = (ObjectButton) getFocused();
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);
                City c = (City) (focused).getObject();
                System.out.println(c);
                if (!areaForms.containsKey(focused)) {
                    areaForms.put(focused, new CityAreasForm(this, c));
                }
                ((CityAreasForm) areaForms.get(focused)).show();

                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
