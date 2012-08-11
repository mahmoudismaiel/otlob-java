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
import otlobmobile.model2.City2;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobGatewayV3Client;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CitiesForm extends OtlobForm {

    private Vector cities;
    private Hashtable areaForms;

    public CitiesForm(MainScreenForm parent) {
        super(parent, true, "Choose City2");
        areaForms = new Hashtable();
        cities = new Vector(0);
        fillFormComponents();
    }

    public final void fillFormComponents() {
        // if (cities == null) {
        Runnable r = new Runnable() {

            public void run() {
                /**
                 * Use these lines if you want to use the first version of Web Service
                 */
                 // SoapObject o = OtlobDataDisplayClient.getCountryCities(OtlobMidlet.CULTURE, 2);
               //   cities = City2.parseCities(o);
                
                
                /**
                 * Use these lines if you want to use the other version of Web Service
                 */
                SoapObject o = OtlobGatewayV3Client.getCountryCities(2,OtlobMidlet.CULTURE);
                cities = City2.parseCities(o,2);
            }
        };
        try {
            GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // }
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        for (int i = 0; i < cities.size(); i++) {
            City2 c = (City2) cities.elementAt(i);
           // String name = ((OtlobMidlet.CULTURE.equals(OtlobMidlet.CULTURE_AR))) ? c.getCityNameAR() : c.getCityName();
            ObjectButton b = new ObjectButton(c, c.getCityName());
            b.addActionListener(enter);
            b.setAlignment(CENTER);
            b.getSelectedStyle().setBgColor(0xEEA336, true);
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
                City2 c = (City2) (focused).getObject();
                // System.out.println(c);
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
