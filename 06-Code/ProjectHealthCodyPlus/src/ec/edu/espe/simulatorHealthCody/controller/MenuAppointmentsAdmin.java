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
public class MenuAppointmentsAdmin {
    Scanner read = new Scanner(System.in);
    String date,time;
    public void SceduleAppointments()
    {
        System.out.println("-----PROGRAMAR CITAS------");
    }
    public String dateAppointment()
    {
        System.out.println("Ingrese una fecha: ");
        System.out.println("Ejemplo: 01/01/2020");
        date = read.nextLine();
        return date;
    }
    public String timeAppointment()
    {
        System.out.println("Ingrese una hora: ");
        System.out.println("Ejemplo: 00:00");
        time = read.nextLine();
        return time;
    }
}
