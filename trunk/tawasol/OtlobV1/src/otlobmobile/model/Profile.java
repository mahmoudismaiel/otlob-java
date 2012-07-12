/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otlobmobile.model;

/**
 * Reprensents the Profile object model
 *
 * @author Mitch RM
 * @version 1.0
 */
public class Profile {

    private int id;
    private String name;
    private String tel;
    private String email;
    private String age;
    private String gender;

    public Profile() {
    }

    public Profile(int id, String name, String tel, String email, String age, String gender) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the Gender type of this Profile
     * 
     * @return {@code true} if Male , {@code false} if Female
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the Gender Type
     * @param gender {@code true} for Male , {@code false} for Female
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
