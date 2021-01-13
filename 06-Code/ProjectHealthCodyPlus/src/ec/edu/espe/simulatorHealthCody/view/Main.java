/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import ec.edu.espe.simulatorHealthCody.controller.Menu;
import ec.edu.espe.simulatorHealthCody.model.Administrator;
import ec.edu.espe.simulatorHealthCody.model.LogIn;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner read = new Scanner(System.in);
        int option;
        Menu menu = new Menu();
        do{
        menu.showMenuPrincipal();
        System.out.print("Seleccione una opcion: ");
        option = read.nextInt();
        switch(option){
            case 1:
                menu.showLoginAndRegistryMenu();
                System.out.print("Seleccione una opcion: ");
                option = read.nextInt();
                String user="",accesCode="",password="";
                if(option == 1){
                    System.out.print("Ingrese su codigo de acceso: ");
                    read.nextLine();
                    accesCode = read.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    password = read.nextLine();
                    LogIn loginAdmin = new LogIn(user, accesCode, password);
                    boolean comparateAdmin = loginAdmin.LoginAdministrator();
                    System.out.println(comparateAdmin);
                }else{
                    System.out.print("Ingrese su usuario: ");
                    read.nextLine();
                    user = read.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    password = read.nextLine();
                    LogIn loginCustomer = new LogIn(user, password);
                    boolean compareCustom = loginCustomer.LoginCustomer();
                    System.out.println(compareCustom);
                }
                break;
            case 2:
                menu.showLoginAndRegistryMenu();
                System.out.print("Seleccione una opcion: ");
                option = read.nextInt();
                String namePerson, idPerson, genderPerson;
                String dataPassword;
                String dataUser;
                int agePerson;
                if(option == 1){
                    System.out.println("Complete los siguientes datos");
                    read.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    namePerson = read.nextLine();
                    System.out.print("Ingrese su numero de identificacion: ");
                    idPerson = read.nextLine();
                    System.out.print("Ingrese su genero: ");
                    genderPerson = read.nextLine();
                    System.out.print("Ingrese su edad: ");
                    agePerson = read.nextInt();
                    System.out.println("Guardando...........");
                    Thread.sleep(2000);
                    System.out.print("Cree una contraseña: ");
                    read.nextLine();
                    dataPassword = read.nextLine();
                    Administrator administrator = new Administrator(namePerson, idPerson, genderPerson, agePerson, "", dataPassword);
                    Registry registryAdmin = new Registry(administrator);
                    registryAdmin.generateAdminCode();
                    registryAdmin.registerAdministrator();
                    System.out.println("Generando codigo de Acceso");
                    Thread.sleep(1000);
                    System.out.println("Su condigo de acceso es: " + administrator.getAdministratorCode());
                    Thread.sleep(1000);
                }else{
                    System.out.println("Complete los siguientes datos");
                    read.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    namePerson = read.nextLine();
                    System.out.print("Ingrese su numero de identificacion: ");
                    idPerson = read.nextLine();
                    System.out.print("Ingrese su genero: ");
                    genderPerson = read.nextLine();
                    System.out.print("Ingrese su edad: ");
                    agePerson = read.nextInt();
                    System.out.println("Guardando...........");
                    Thread.sleep(2000);
                    System.out.print("Cree un usuario: ");
                    read.nextLine();
                    dataUser = read.nextLine();
                    System.out.print("Cree una contraseña: ");
                    dataPassword = read.nextLine();
                    System.out.println("Guardando...........");
                    Thread.sleep(2000);
                    Customer customer = new Customer(namePerson, idPerson, genderPerson, agePerson, dataUser, dataPassword);
                    Registry registryCustomer = new Registry(customer);
                    registryCustomer.registerCustomer();
                }
                
                break;
                
            case 3:
                break;
        }
        }while(option != 3);
    }
}
