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

    /**
     * @return the read
     */
    public Scanner getRead() {
        return read;
    }

    /**
     * @param read the read to set
     */
    public void setRead(Scanner read) {
        this.read = read;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the customerData
     */
    public CustomerList getCustomerData() {
        return customerData;
    }

    /**
     * @param customerData the customerData to set
     */
    public void setCustomerData(CustomerList customerData) {
        this.customerData = customerData;
    }
    
    private Scanner read = new Scanner(System.in);
    
    private String customerId;
    private Customer customer;
    private CustomerList customerData;
    
    public MedicalHistory()
    {
        this.customerData = new CustomerList();
    }
    public void searchCustomer()
    {
        System.out.println("Ingrese el id del Paciente: ");
        setCustomerId(getRead().nextLine());
        getCustomerData().readFile();
        boolean compareCustomer=false;
        for(int i=0; i<getCustomerData().getCustomerList().size();i++)
        {
            if(getCustomerId().equals(getCustomerData().getCustomerList().get(i).getIdPerson()))
            {
                compareCustomer = true;
                System.out.println("DATOS DEL PACIENTE");
                System.out.println(getCustomerData().getCustomerList().get(i));
            }
        }
        if(compareCustomer==false)
        {
            System.out.println("NO SE ENCONTRO DATOS DEL PACIENTE");
        }
        
    }

}
