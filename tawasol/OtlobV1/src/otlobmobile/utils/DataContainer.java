/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Container;
import com.sun.lwuit.Display;
import com.sun.lwuit.layouts.BoxLayout;

/**
 * The class is responsible of Handling static data represented in
 * Labels and scrolling them as you want
 * @author Mitch RM
 */
public class DataContainer extends Container {

    static final int SCROLL_STEP = 10;

    
    /**
     * 
     */
    public DataContainer() {
        super(new BoxLayout(BoxLayout.Y_AXIS));
        setScrollableY(true);
    }

    /**
     *
     */
    public void resetScroll() {
        setScrollY(0);
    }

    /**
     *
     * @param keyCode
     */
    public void keyPressed(int keyCode) {
        //int gameAction = Display.getInstance().getGameAction(keyCode);
        if (keyCode == Display.GAME_DOWN) {
            int lastScrollPosition = getPreferredH() - getHeight();
            setScrollY(Math.min(lastScrollPosition, getScrollY() + SCROLL_STEP));
        } else if (keyCode == Display.GAME_UP) {
            setScrollY(Math.max(0, getScrollY() - SCROLL_STEP));
        }
    }
}
