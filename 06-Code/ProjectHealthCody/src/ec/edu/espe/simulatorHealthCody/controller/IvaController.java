/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

import ec.edu.espe.simulatorHealthCody.model.Iva;



/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class IvaController {

    public float calculate(float priceConvert) {
        Iva tax = Iva.getInstance();
        float price = tax.salesTotal(priceConvert);
        return price; 
    }
}
