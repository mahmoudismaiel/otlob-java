/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.utils;

import com.sun.lwuit.Component;
import com.sun.lwuit.Font;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.plaf.Style;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Vector;

/**
 * Represents the News Maestro of the application
 * <p>
 * TextManager is a utility class that can be used in parsing text, news and other stuff
 *
 * @author Mitch RM
 * @since MIDP 2.0,CLDC 1.1
 * @version 1.0
 */
public class TextManager {

    /**
     * Fills a Form or Container with news' list (title + thumbnail) after update process
     * @param newsItems a vector contains {@link ObjectButton} represents {@link News} Buttons
     * @param btnCommand specfies the news' action listener
     * @param parent the Form (or Container) that news' titles will be added to.
     * @param fromStart if true, the created Container will be added on top of Container parent
     */
//    public static void fillNewsSection(Vector newsItems, Command btnCommand, Container parent, boolean fromStart) {
//        if (newsItems.size() > 0) {
//            for (int i = newsItems.size() - 1; i >= 0; i--) {
//                ObjectButton newsButton = (ObjectButton) newsItems.elementAt(i);
//                GUIManager.addStaticContainer(newsButton, btnCommand, parent, fromStart);
//            }
//        }
//    }

    /**
     * Returns a vector of lines as array of String
     * @param sections sections lines as vector
     * @return the created String array
     */
    public static String[] getSectionsNames(Vector sections) {
        String[] names = new String[sections.size()];
        for (int i = 0; i < sections.size(); i++) {
            names[i] = (String) sections.elementAt(i);
        }
        return names;
    }

    /**
     * Reads a .xml file as vector of lines
     * @param path the file's path
     * @param fileName the file's name
     * @param clazz the calling class
     * @return the created vector
     */
    public static Vector readFile(String path, String fileName) {
        try {
//            System.out.println("Full File path: " + path + "/" + fileName);
            InputStream inputStreamTxt = null;
            inputStreamTxt = TextManager.class.getResourceAsStream(path + "/" + fileName);
            Reader reader = new InputStreamReader(inputStreamTxt, "UTF-8");
            StringBuffer buf = new StringBuffer();
            Vector lines = new Vector();
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (ch == '\n') {
                    lines.addElement(buf.toString());
                    buf.delete(0, buf.length());
                } else {
                    buf.append(ch);
                }
            }
            lines.addElement(buf.toString());
            inputStreamTxt.close();
            return lines;
        } catch (IOException ex) {
            System.out.println("File not found \n path: " + path);
        }
        return null;
    }

    /**
     * This method is used to add a wrraped text to a DataContainer
     * whether it will be Scrollable or not
     * @param dc an DataContainer object {@link DataContainer}
     * @param wrapper a textarea used as wrapper
     * @param width
     */
    public static void addText(DataContainer dc, TextArea wrapper, int width) {
        setupWrapper(width, wrapper);
        setText(dc, wrapper);
    }

    static void setupWrapper(int width, TextArea ta) {
        ta.setGrowByContent(true);
        ta.setRows(2);
        ta.setPreferredSize(new Dimension(width, ta.getPreferredH()));
        ta.setWidth(width - GUIManager.VERTICAL_BAR_WIDTH);

    }

    static void setText(DataContainer dc, TextArea ta) {
        Vector labels = textAreaToLabels(ta);
        for (int i = 0; i < labels.size(); i++) {
            dc.addComponent((Component) labels.elementAt(i));
        }
        dc.resetScroll();
    }

    static Vector textAreaToLabels(TextArea ta) {
        Vector result = new Vector();
        int lines = ta.getLines();
        for (int i = 0; i < lines; i++) {
            result.addElement(createLabel(ta.getTextAt(i)));
        }
        return result;

    }

    static Label createLabel(final String text) {
        Label result = new Label(text);
        result.setAlignment(Component.CENTER);
        result.getSelectedStyle().setFgColor(result.getStyle().getFgColor());
        Style s = result.getStyle();
        s.setBgTransparency(00);
        s.setBorder(null);
        Font f = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        s.setFont(f);

        return result;
    }
}

