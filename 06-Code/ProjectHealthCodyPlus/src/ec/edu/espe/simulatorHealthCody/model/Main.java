/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Main {
    public static void main(String[] args) {
        int option;
        Scanner read = new Scanner(System.in);
        do{
        
        System.out.println("MENU");
        System.out.println("1. Iniciar secion");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
        option = read.nextInt();
        switch(option){
            case 1:
                System.out.println("1. Administrador");
                System.out.println("2. Usuario");
                System.out.print("Seleccione una opcion: ");
                int loginOption = read.nextInt();
                switch(loginOption){
                    case 1:
                        boolean loginCompareAdmin;
                        do{
                        read.nextLine();
                        System.out.print("Usuario: ");
                        String userAdmin = read.nextLine();
                        System.out.print("Contraseña: ");
                        String passwordAdmin = read.nextLine();
                        System.out.print("Codigo de acceso: ");
                        String codeAdmin = read.nextLine();
                        TheLogin LoginAdministrator = new TheLogin(userAdmin,passwordAdmin,codeAdmin);
                        loginCompareAdmin = LoginAdministrator.loginAdministrator();
                        }while(loginCompareAdmin == false);
                        
                        break;
                    
                    case 2:
                        boolean loginCompareCustomer;
                        do{
                            read.nextLine();
                            System.out.print("Usuario: ");
                            String userCustomer = read.nextLine();
                            System.out.print("Contraseña: ");
                            String passwordCustomer  = read.nextLine();
                            TheLogin LoginCustomer = new TheLogin(userCustomer ,passwordCustomer);
                            loginCompareCustomer = LoginCustomer.loginCustomer();
                        }while(loginCompareCustomer == false);
                        break;
                }
                break;
            case 2:
                System.out.println("1. Administrador");
                System.out.println("2. Usuario");
                System.out.print("Seleccione una opcion: ");
                int registerOption = read.nextInt();
                switch(registerOption){
                    case 1:
                        System.out.println("Complete los datos");
                        read.nextLine();
                        System.out.print("Nombre: ");
                        String namePerson = read.nextLine();
                        System.out.print("id: ");
                        String idPerson = read.nextLine();
                        System.out.print("Genero: ");
                        String genderPerson = read.nextLine();
                        System.out.print("Edad: ");
                        int agePerson = read.nextInt();
                        read.nextLine();
                        System.out.print("Ingrese un usuario: ");
                        String administratorUSer = read.nextLine();
                        System.out.print("Ingrese una contraseña: ");
                        String administratorPassword = read.nextLine();
                        Administrator administrator = new Administrator(namePerson,idPerson,genderPerson,agePerson,administratorUSer,administratorPassword,"");
                        Registry adminRegistration = new Registry(administrator);
                        adminRegistration.generateAdminCode();
                        adminRegistration.registeradministrator();
                        System.out.print("Su codigo de acceso es: ");
                        System.out.println(administrator.getAdministratorCode());
                        
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
                        customerRegistration.registerCustomer();
                        break;
                }
                break;
                
            case 3:
                option = 3;
                break;
        }
        }while(option==1 || option==2);        
    }
}

