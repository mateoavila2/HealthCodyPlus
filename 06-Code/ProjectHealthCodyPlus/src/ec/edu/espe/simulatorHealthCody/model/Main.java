/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.util.Scanner;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class Main {
      public static void main(String[] args) {
          Scanner read = new Scanner(System.in);
          System.out.println("MENU");
          System.out.println("1. Iniciar secion");
          System.out.println("2. Registrarse");
          System.out.print("Seleccione una opcion: ");
          int option = read.nextInt();
          switch(option){
              case 1:
                  System.out.println("1. Administrador");
                  System.out.println("2. Usuario");
                  System.out.print("Seleccione una opcion: ");
                  int loginOption = read.nextInt();
                  break;
              case 2:
                  System.out.println("1. Administrador");
                  System.out.println("2. Usuario");
                  System.out.print("Seleccione una opcion: ");
                  int registerOption = read.nextInt();
                  switch(registerOption){
                      case 1:
                          read.nextLine();
                          System.out.println("Complete los datos");
                          System.out.println("Nombre: ");
                          String namePerson1 = read.nextLine();
                          System.out.println("id: ");
                          String idPerson1 = read.nextLine();
                          System.out.println("Genero: ");
                          String genderPerson1 = read.nextLine();
                          System.out.println("Edad: ");
                          int agePerson1 = read.nextInt();
                          read.nextLine();
                          System.out.println("Ingrese un usuario: ");
                          String administratorUser = read.nextLine();
                          System.out.println("Ingrese una contraseña: ");
                          String administratorPassword = read.nextLine();
                          System.out.println("Ingrese un codigo de acceso: ");
                          String adminitratorCode = read.nextLine();
                          Person administrator = new Person(namePerson1,idPerson1,genderPerson1,agePerson1);
                          break;
                      case 2:
                          read.nextLine();
                          System.out.println("Complete los datos");
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
                          String customerUSer = read.nextLine();
                          System.out.print("Ingrese una contraseña: ");
                          String customerPassword = read.nextLine();
                          Person customer = new Person(namePerson,idPerson,genderPerson,agePerson);
                          Customer patient = new Customer(customerUSer, customerPassword, customer);
                          System.out.println("----------------\n\n");
                          CustomerList list = new CustomerList();
                          list.saveCustomer(patient);
                          break;
                  }
                  break;
          }
    }
}
