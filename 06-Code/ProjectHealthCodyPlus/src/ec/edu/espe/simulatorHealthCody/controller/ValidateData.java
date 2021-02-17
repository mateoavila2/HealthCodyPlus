/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

/**
 *
 * @author Mateo Ávila ESPE-DCCO
 */
public class ValidateData {

    public static int validate(String data) {
        
        int option;
        try {
            option = Integer.parseInt(data);
            return option;
        } catch (Exception e) {
            System.out.println("Opción no valida");
            option = 0;
            return option;
        }
    }
}
