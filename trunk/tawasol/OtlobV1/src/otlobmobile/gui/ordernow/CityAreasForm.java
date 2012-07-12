/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.gui.ordernow;

import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import otlobmobile.gui.OtlobForm;
import otlobmobile.gui.OtlobMidlet;
import otlobmobile.model.Area;
import otlobmobile.model.City;
import otlobmobile.utils.GUIManager;
import otlobmobile.utils.ObjectButton;
import otlobmobile.webclient.OtlobDataDisplayClient;

/**
 *
 * @author Mahmoud.Ismail
 */
public class CityAreasForm extends OtlobForm {

    private Vector areas;
    private final City city;

    public CityAreasForm(CitiesForm parent,City c) {
        super(parent, true, "Choose Area");
        this.city = c;
        fillFormComponents();
    }

    public final void fillFormComponents() {
        if (areas == null) {
            SoapObject o = OtlobDataDisplayClient.getCityAreas(OtlobMidlet.CULTURE, city.getId());
            areas = Area.parseAreas(o,city);
        }
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        for (int i = 0; i < areas.size(); i++) {
            Area a = (Area) areas.elementAt(i);
            ObjectButton b = new  ObjectButton(a, a.getAreaName());
            b.addActionListener(enter);
            b.setAlignment(CENTER);
            b.getSelectedStyle().setBgColor(0xff6600,true);
            b.getSelectedStyle().setFgColor(0x000000,true);            
            addComponent(b);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent evt) {
        switch (evt.getCommand().getId()) {
            case RUN_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_RIGHT);
//                if (getFocused() instanceof ObjectButton) {
//                    City c = (City) ((ObjectButton)getFocused()).getObject();
//                    System.out.println(c);
//                }
                break;
            case BACK_COMMAND:
                setTransitionOutAnimator(GUIManager.SLIDE_LEFT);
                parent.show();
                break;
        }
    }
}
