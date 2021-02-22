/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Mateo Ávila
 */
public class User {

    protected String name;
    protected String id;
    protected int age;
    protected String gender;
    protected String userName;
    protected String accesKey;

    public User(String name, String id, int age, String gender, String userName, String accesKey) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.userName = userName;
        this.accesKey = accesKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccesKey() {
        return accesKey;
    }

    public void setAccesKey(String accesKey) {
        this.accesKey = accesKey;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", age=" + age + ", gender=" + gender + ", userName=" + userName + ", accesKey=" + accesKey + '}';
    }

}
