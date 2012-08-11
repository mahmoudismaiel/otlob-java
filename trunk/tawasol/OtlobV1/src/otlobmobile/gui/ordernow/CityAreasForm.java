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
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model2.Area2;
import otlobmobile.model2.City2;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobGatewayV3Client;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CityAreasForm extends OtlobForm {

    private Vector areas;
    private Hashtable categoryForms;
    private final City2 city;

    public CityAreasForm(CitiesForm parent, City2 c) {
        super(parent, true, "Choose Area2");
        this.city = c;
        categoryForms = new Hashtable();
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (areas == null) {
            Runnable r = new Runnable() {

                public void run() {
                    SoapObject o = OtlobGatewayV3Client.getCityAreas(OtlobMidlet.CULTURE, city.getId());
                    areas = Area2.parseCityAreas(o, city);
                }
            };
            try {
                GUIManager.implementAsynchronousOperations(OtlobMidlet.getLoadingDialog(), r, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        for (int i = 0; i < areas.size(); i++) {
            Area2 a = (Area2) areas.elementAt(i);
            ObjectButton b = new ObjectButton(a, a.getAreaName());
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

                Area2 a = (Area2) (focused).getObject();
                System.out.println(a);
                if (!categoryForms.containsKey(focused)) {
                    categoryForms.put(focused, new AreaCategoriesForm(this, a));
                }
                ((AreaCategoriesForm) categoryForms.get(focused)).show();
                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
