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
public class MenuMedicalHistory {
    
    Scanner read = new Scanner(System.in);

    int optionCustomerMedical;
    
    public int selectMedicalHistoryOption()
    {
        System.out.println("HISTORIAL MÉDICO");
        System.out.println("1) Ingrese id del paciente: ");
        System.out.println("2) Regresar");
        optionCustomerMedical = read.nextInt();
        return optionCustomerMedical;
    }
   
}
