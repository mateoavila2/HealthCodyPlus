/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class CustomerList {
    ArrayList<Customer> customerList;
    
    public CustomerList()
    {
        customerList = new ArrayList();
    }
      
    public void saveCustomer()
    {
        
    }
     public void saveCustomer(Customer customer)
    {
       FileWriter file;
       BufferedWriter write;
        this.customerList.add(customer);
        try
        {
            File fileExist = new File("saveCustomer.txt");
            file = new FileWriter("saveCustomer.txt",true);
            if(fileExist.exists())
            {
                write =new BufferedWriter(file);
                for(int i=0;i<customerList.size();i++)
                {
                    write.write(customerList.get(i).toString());
                    write.write(""+"\n");
                    write.close();
                }   
            }
            else
            {
                file = new FileWriter("saveCustomer.txt",true);
            }   
        }catch(IOException ex)
        {
           Logger.getLogger(Customer.class.getName()).log(Level.SEVERE,null,ex);     
        }
}
}
