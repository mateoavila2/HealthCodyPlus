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
public class LogInMenu {
    Scanner read = new Scanner(System.in);
    
    
    public void showMenuLogin(){
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
    }
    
    public int selectOptionLoginMenu(){
        System.out.print("Seleccione una opcion: ");
        int loginOption = read.nextInt();
        return loginOption;
    }
}
