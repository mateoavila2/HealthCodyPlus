/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import com.google.gson.Gson;
import ec.edu.espe.DBmanager.utils.DBmanager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Registry {

    Gson gson = new Gson();

    DBmanager operations;
    private final List<User> users;
    String collenctionName;

    public Registry(String collenctionName) {
        this.collenctionName = collenctionName;
        users = new ArrayList();
        operations = new DBmanager("Registry", collenctionName);
    }

    public void register(User user) {
        String json;
        json = gson.toJson(user);
        operations.create(json);

    }

    public String showUsers() {
        String jsonUsers;
        jsonUsers = operations.read();
        return jsonUsers;
    }

    public String findUser(String dataToFind) {
        String recovered;
        recovered = operations.readByFilter(dataToFind);

        return recovered;
    }

    public void updateUser(String dataToFind, String dataToUpdate, String keyName) {
        operations.update(dataToFind, dataToUpdate, keyName);

    }

    public void deleteUser(String dataToDelete, String keyName) {
        operations.delete(keyName, dataToDelete);
    }
}
