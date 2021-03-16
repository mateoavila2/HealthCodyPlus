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
public class Product {
    
    Gson gson = new Gson();

    private String name;
    private String code;
    private double price;
    private int quantity;
    
    private List<Product> products;
    private String collectionName;
    DBmanager operation;


    public Product(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }
        public Product(String collectionName) {

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

    public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String nameProduct) {
        this.name = nameProduct;
    }

    public String getCodeProduct() {
        return code;
    }

    public void setCodeProduct(String codeProduct) {
        this.code = codeProduct;
    }

    public double getPriceProduct() {
        return price;
    }

    public void setPriceProduct(double priceProduct) {
        this.price = priceProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
    
    
    @Override
    public String toString() {
        return "Nombre del producto: " + name + "\n"
                + "Código del producto: " + code + "\n"
                + "Precio del producto: " + price + "\n"
                + "Cantidad de producto: " + quantity;
    }

}
