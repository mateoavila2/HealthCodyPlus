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
public class RegistryMenu {
    Scanner read = new Scanner(System.in);
    
    
    public void showMenuRegistry(){
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
    }
    
    public int selectOptionRegistryMenu(){
        System.out.print("Seleccione una opcion: ");
        int registerOption = read.nextInt();
        return registerOption;
    }
}
