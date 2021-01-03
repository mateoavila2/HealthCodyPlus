/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import java.util.Scanner;

/**
 *
 * @author Mateo Ávila ESPE-DCCO
 */
public class MainMenu {
    public static void principal(String[] args) {
        
        Scanner mm= new Scanner (System.in);
        boolean salir = false;
        int opcion;
        System.out.println("Bienvenido a Health Cody +");
        System.out.println("¿Quién eres?");
        while(!salir){
            System.out.println("1. Administrador");
            System.out.println("2. Usuario");
            System.out.println("3. Salir");
            
            System.out.println("\nElige una de las opciones: ");
            
            opcion= mm.nextInt();
            switch(opcion){
                case 1:
                    AdminMenu.mainadmin(args);
                    break;
                case 2:
                    UserMenu.mainuser(args);
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
