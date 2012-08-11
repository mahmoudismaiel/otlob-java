/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model2;

import otlobmobile.model.*;

/**
 *
 * @author Mahmoud.Ismail
 */
public class Provider2 {

    int id;
    String name;

    public Provider2() {
    }
    
    public Provider2(int id) {
        this.id = id;
    }

    public Provider2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
