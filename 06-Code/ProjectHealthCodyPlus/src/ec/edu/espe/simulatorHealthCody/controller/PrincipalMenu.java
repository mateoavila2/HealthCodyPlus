/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class PrincipalMenu {
    Scanner read = new Scanner(System.in);
    
    
    
    public void showMenuPrincipal(){
        System.out.println("MENU");
        System.out.println("1. Iniciar secion");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
    }
    
    public int selectOptionMenu(){
        System.out.print("Seleccione una opcion: ");
        int option = read.nextInt();
        return option;
    }
}
