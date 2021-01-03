/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import java.util.Scanner;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class AdministratorMenuOptions {
    
    Scanner read = new Scanner(System.in);
    int optionMenuAdmin;
    public void showAdminOptions()
    {
        System.out.println("---MENU DEL ADMINISTRADOR---");
        System.out.println("1) Buscar paciente");
        System.out.println("2) Programar citas");
        System.out.println("3) Manejar Inventario");
        System.out.println("4) Generar reporte");
        System.out.println("5) Salir");
    }
    public int selectOptionMenuAdmin()
    {
       System.out.println("Seleccione una opción: ");
       optionMenuAdmin = read.nextInt();
       return optionMenuAdmin;
    }
}
