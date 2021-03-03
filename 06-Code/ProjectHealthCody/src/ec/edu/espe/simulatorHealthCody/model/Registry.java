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
public class Registry {

    Gson gson = new Gson();

    DBmanager operation;
    List<User> users;
    String collenctionName;

    public Registry(String collenctionName) {
        this.collenctionName = collenctionName;
        users = new ArrayList();
        operation = new DBmanager("Registry", this.collenctionName);
    }

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

    /*public void generateAdminCode() {
        administrator.setAdministratorCode("Admin" + administrator.getIdPerson() + administrator.getGenderPerson());
    }*/

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
    
    
}
