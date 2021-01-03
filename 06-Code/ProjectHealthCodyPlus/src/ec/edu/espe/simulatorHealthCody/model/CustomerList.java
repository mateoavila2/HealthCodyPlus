/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class CustomerList {
    private ArrayList<Customer> customerList;

    public CustomerList() {
        customerList = new ArrayList();
    }
    
    public void saveCustomer(Customer customer){
        FileWriter file;
        BufferedWriter write;
        try
        {
            File f = new File("customerList.txt");

            file = new FileWriter("customerList.txt",true);
            if(f.exists())
            {
                write =new BufferedWriter(file);
                write.write(customer.toString());
                //write.write(""+"\n");
                write.close();
                }   
            else
            {
                file = new FileWriter("customerList.txt",true);
            }    
        }catch(IOException ex)
        {
           Logger.getLogger(Customer.class.getName()).log(Level.SEVERE,null,ex);     
        }
    }
    
    public void readFile(){
        try {
            FileReader  readFile;
            BufferedReader read;
            readFile=new FileReader("customerList.txt");
            read=new BufferedReader(readFile);
            String recovered="";
            while(read.ready()){
                Customer customer = new Customer("","","",0,"","");
                recovered=read.readLine();
                String[]data=recovered.split(",");
                customer.setNamePerson(data[0]);
                customer.setIdPerson(data[1]);
                customer.setGenderPerson(data[2]);
                customer.setAgePerson(Integer.parseInt(data[3]));
                customer.setCustomerUSer(data[4]);
                customer.setCustomerPassword(data[5]);
                customerList.add(customer);
            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }
    
    
}
