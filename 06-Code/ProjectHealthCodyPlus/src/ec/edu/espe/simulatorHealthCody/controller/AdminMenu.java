/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Administrator;
import ec.edu.espe.simulatorHealthCody.model.LogIn;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import java.util.Scanner;

/**
 *
 * @author Mateo Ávila ESPE-DCCO
 */
public class AdminMenu {
    public static void mainadmin(String[] args) {
        
        Scanner read= new Scanner (System.in);
        boolean salir = false;
        int opcion;
        System.out.println("\nBienvenido Administrador");
        while(!salir){
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            
            System.out.println("\nElige una de las opciones: ");
            
            opcion= read.nextInt();
            switch(opcion){
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
                        LogIn LoginAdministrator = new LogIn(userAdmin,passwordAdmin,codeAdmin);
                        loginCompareAdmin = LoginAdministrator.LoginAdministrator();
                        }while(loginCompareAdmin == false);
                    break;
                case 2:
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
                        adminRegistration.Registeradministrator();
                        System.out.print("Su codigo de acceso es: ");
                        System.out.println(administrator.getAdministratorCode());
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


