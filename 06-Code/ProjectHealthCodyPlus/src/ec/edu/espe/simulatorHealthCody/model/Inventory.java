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
    Scanner enter = new Scanner(System.in);

    public Inventory() {
        products = new ArrayList();
    }
    
    
    public void saveProduct(Product product){
        
        String jsonProduct = gson.toJson(product);
        FileManager.save("Inventory.json", jsonProduct);
    }
    
    public String findProduct(String dataToFind){
        String recovered = FileManager.find("Inventory.json", dataToFind);
        return recovered;
    
    }
    
    public boolean modifyProduct(String dataTofind,String dataToUpdate){
        boolean update;
        System.out.println(dataToUpdate + dataTofind);
        update = FileManager.update("Inventory.json", dataTofind, dataToUpdate);
        return update;
    }
    
    public boolean deleteProduct(String dataToDelete){
        boolean deleted;
        deleted = FileManager.delete("Inventory.json", dataToDelete);
        return deleted;
    }
    
    public ArrayList<Product> showInventory(){
        
        String allData;
        allData = FileManager.findAll("Inventory.json");
        String[] savedAllData = allData.split("\r\n");
        for(int i=0;i<savedAllData.length;i++){
           products.add(gson.fromJson(savedAllData[i], Product.class));
        }
        
        return products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    

    
    
    
}
