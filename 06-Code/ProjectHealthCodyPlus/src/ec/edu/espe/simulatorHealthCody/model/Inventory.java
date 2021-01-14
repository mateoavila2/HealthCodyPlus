/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;
import java.util.ArrayList;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Inventory {
    Product product;
    Gson gson = new Gson();
    
    public Inventory(Product product) {
        this.product = product;
    }
    
    public void showInventory(){
        
    
    }
    
    public void saveProduct(){
        
        String jsonProduct = gson.toJson(product);
        FileManager.save("Inventory.json", jsonProduct);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Inventory{" + "product=" + product + '}';
    }
    
    
}
