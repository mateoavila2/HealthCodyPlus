/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.LogIn;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import java.util.Scanner;

/**
 *
 * @author Mateo Ávila ESPE-DCCO
 */
public class UserMenu {
    
    public static void mainuser(String[] args) {
        
        Scanner read= new Scanner (System.in);
        boolean salir = false;
        int opcion;
        System.out.println("\nBienvenido Usuario");
        while(!salir){
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            
            System.out.println("\nElige una de las opciones: ");
            
            opcion= read.nextInt();
            switch(opcion){
                case 1:
                    boolean loginCompareCustomer;
                        do{
                            read.nextLine();
                            System.out.print("Usuario: ");
                            String userCustomer = read.nextLine();
                            System.out.print("Contraseña: ");
                            String passwordCustomer  = read.nextLine();
                            LogIn LoginCustomer = new LogIn(userCustomer ,passwordCustomer);
                            loginCompareCustomer = LoginCustomer.LoginCustomer();
                        }while(loginCompareCustomer == false);
                    break;
                case 2:
                    System.out.println("Complete los datos");
                        read.nextLine();
                        System.out.print("Nombre: ");
                        String namePerson1 = read.nextLine();
                        System.out.print("id: ");
                        String idPerson1 = read.nextLine();
                        System.out.print("Genero: ");
                        String genderPerson1 = read.nextLine();
                        System.out.print("Edad: ");
                        int agePerson1 = read.nextInt();
                        read.nextLine();
                        System.out.print("Ingrese un usuario: ");
                        String customerUSer = read.nextLine();
                        System.out.print("Ingrese una contraseña: ");
                        String customerPassword = read.nextLine();
                        Customer customer = new Customer(namePerson1,idPerson1,genderPerson1,agePerson1,customerUSer,customerPassword);
                        Registry customerRegistration = new Registry(customer);
                        customerRegistration.RegisterCustomer();
                    break;
                case 3:
                    salir=true;
                    break;
                default:
                    System.out.println("Oh no, solo números del 1 al 3");
            }
        } 
            
        
    }    
}
