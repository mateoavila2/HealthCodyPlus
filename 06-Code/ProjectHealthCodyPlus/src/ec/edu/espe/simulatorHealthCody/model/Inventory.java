/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Inventory {
    ArrayList<Product> products;
    Gson gson = new Gson();
    Scanner read = new Scanner(System.in);

    public Inventory() {
        products = new ArrayList();
    }
    
    
    public void saveProduct(Product product){
        
        String jsonProduct = gson.toJson(product);
        FileManager.save("Inventory.json", jsonProduct);
    }
    
    public ArrayList<Product> findProduct(String code){
        ArrayList<String> dataProduct = new ArrayList();
        dataProduct = FileManager.find("Inventory.json",code);
        for(int i=0;i<dataProduct.size();i++){
            products.add(gson.fromJson(dataProduct.get(i), Product.class));
        }
        return products;
    
    }
    
    public void modifyProduct(String modified){
        
    }
    
    public void deleteProduct(){
    
    }
    
    public void showInventory(){
        ArrayList<String> dataProducts = new ArrayList();
        dataProducts = FileManager.findAll("Inventory.json");
        for(int i=0;i<dataProducts.size();i++){
            products.add(gson.fromJson(dataProducts.get(i), Product.class));
        }
        for(int i=0;i<products.size();i++){
            System.out.println(products.get(i));
        }
    
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    

    
    
    
}
