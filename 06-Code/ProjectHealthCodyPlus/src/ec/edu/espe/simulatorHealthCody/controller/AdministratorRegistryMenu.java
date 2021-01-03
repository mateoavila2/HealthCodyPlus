/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Administrator;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class AdministratorRegistryMenu {
    String namePerson;
    String idPerson;
    String genderPerson;
    int agePerson;
    String administratorUSer;
    String administratorPassword;
    Administrator administrator;
    Registry adminRegistration;
    Scanner read = new Scanner(System.in);
    
    public void completeAdminData(){
        System.out.println("Complete los datos");
        read.nextLine();
        System.out.print("Nombre: ");
        namePerson = read.nextLine();
        System.out.print("id: ");
        idPerson = read.nextLine();
        System.out.print("Genero: ");
        genderPerson = read.nextLine();
        System.out.print("Edad: ");
        agePerson = read.nextInt();
        read.nextLine();
        System.out.print("Ingrese un usuario: ");
        administratorUSer = read.nextLine();
        System.out.print("Ingrese una contraseña: ");
        administratorPassword = read.nextLine();
        
    }
    
    public void saveRegistryAdminData(){
        administrator = new Administrator(namePerson,idPerson,genderPerson,agePerson,administratorUSer,administratorPassword,"");
        adminRegistration = new Registry(administrator);
        adminRegistration.generateAdminCode();
        adminRegistration.registerAdministrator();
        System.out.print("Su codigo de acceso es: ");
        System.out.println(administrator.getAdministratorCode());
    }
    
    
    
    
    
}
