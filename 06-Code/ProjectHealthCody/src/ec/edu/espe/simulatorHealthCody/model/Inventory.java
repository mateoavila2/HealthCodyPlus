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
 * @author Rafa
 */
public class Inventory {

    Gson gson = new Gson();

    private List<Product> products;
    private String collectionName;
    DBmanager operation;

    public Inventory(String collectionName) {

        this.collectionName = collectionName;
        products = new ArrayList();
        operation = new DBmanager("Inventory", this.collectionName);
    }

    public void saveProduct(Product product) {

        String jsonProduct;
        jsonProduct = gson.toJson(product);
        operation.create(jsonProduct);
    }

    public String showProducts() {
        String jsonProducts;
        jsonProducts = operation.read();
        return jsonProducts;
    }

    public String findProduct(String dataToFind) {
        String recovered;
        recovered = operation.readByFilter(dataToFind);
        
        return recovered;
    }

    public void updateProduct(String dataToFind, String dataToUpdate, String keyName) {
        operation.update(dataToFind, dataToUpdate, keyName);

    }

    public void deleteProduct(String dataToDelete, String keyName) {
        operation.delete(keyName, dataToDelete);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
    
    

}
