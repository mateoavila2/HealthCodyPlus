/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.CustomerList;
import java.util.Scanner;
/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class MedicalHistory {
    
    Scanner read = new Scanner(System.in);
    
    String customerId;
    Customer customer;
    CustomerList customerData;
    
    public MedicalHistory()
    {
        this.customerData = new CustomerList();
    }
    public void searchCustomer()
    {
        System.out.println("Ingrese el id del Paciente: ");
        customerId = read.nextLine();
        customerData.readFile();
        boolean compareCustomer=false;
        for(int i=0; i<customerData.getCustomerList().size();i++)
        {
            if(customerId.equals(customerData.getCustomerList().get(i).getIdPerson()))
            {
                compareCustomer = true;
                System.out.println("DATOS DEL PACIENTE");
                System.out.println(customerData.getCustomerList().get(i));
            }
        }
        if(compareCustomer==false)
        {
            System.out.println("NO SE ENCONTRO DATOS DEL PACIENTE");
        }
        
    }

}
