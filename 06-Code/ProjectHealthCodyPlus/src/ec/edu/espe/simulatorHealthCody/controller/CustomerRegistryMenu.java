/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class CustomerRegistryMenu {
    String namePerson1;
    String idPerson1;
    String genderPerson1;
    int agePerson1;
    String customerUSer;
    String customerPassword;
    Customer customer;
    Registry customerRegistration;
    Scanner read = new Scanner(System.in);
    
    public void completeCustomerData(){
        System.out.println("Complete los datos");
        read.nextLine();
        System.out.print("Nombre: ");
        namePerson1 = read.nextLine();
        System.out.print("id: ");
        idPerson1 = read.nextLine();
        System.out.print("Genero: ");
        genderPerson1 = read.nextLine();
        System.out.print("Edad: ");
        agePerson1 = read.nextInt();
        read.nextLine();
        System.out.print("Ingrese un usuario: ");
        customerUSer = read.nextLine();
        System.out.print("Ingrese una contraseña: ");
        customerPassword = read.nextLine();
    }
    
    public void saveRegistryCustomerData(){
        customer = new Customer(namePerson1,idPerson1,genderPerson1,agePerson1,customerUSer,customerPassword);
        customerRegistration = new Registry(customer);
        customerRegistration.registerCustomer();
    }
}
