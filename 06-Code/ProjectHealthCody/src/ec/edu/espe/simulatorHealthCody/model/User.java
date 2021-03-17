/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.utils.DBmanager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateo Ávila
 */
public abstract class User {
    
    Gson gson = new Gson();

    protected String name;
    protected String id;
    protected String dateOfBirth;
    protected String gender;
    protected String userName;
    protected String accesKey;
    DBmanager operation;
    List<User> users;
    String collenctionName;

    public User(String name, String id, String dateOfBirth, String gender, String userName, String accesKey) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userName = userName;
        this.accesKey = accesKey;
    }

    public User() {
    }

    public User(String collenctionName) {
        this.collenctionName = collenctionName;
        users = new ArrayList();
        operation = new DBmanager("Registry", this.collenctionName);
    }
    public abstract void calculateAge();
    
    public void register(User user) {
        String json;
        json = gson.toJson(user);
        operation.create(json);

    }

    public String showUsers() {
        String jsonUsers;
        jsonUsers = operation.read();
        return jsonUsers;
    }

    public String findUser(String dataToFind) {
        String recovered;
        recovered = operation.readByFilter(dataToFind);

        return recovered;
    }

    public void updateUser(String dataToFind, String dataToUpdate,String keyName) {
        operation.update(dataToFind, dataToUpdate, keyName);

    }

    public void deleteUser(String dataToDelete,String keyName) {
        operation.delete(keyName, dataToDelete);
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getCollenctionName() {
        return collenctionName;
    }

    public void setCollenctionName(String collenctionName) {
        this.collenctionName = collenctionName;
    }
    
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", age=" + dateOfBirth + ", gender=" + gender + ", userName=" + userName + ", accesKey=" + accesKey + '}';
    }

}
