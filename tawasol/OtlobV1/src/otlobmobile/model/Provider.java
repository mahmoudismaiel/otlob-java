/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

/**
 *
 * @author Mahmoud.Ismail
 */
public class Provider {

    int id;
    String name;

    public Provider() {
    }
    
    public Provider(int id) {
        this.id = id;
    }

    public Provider(int id, String name) {
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
