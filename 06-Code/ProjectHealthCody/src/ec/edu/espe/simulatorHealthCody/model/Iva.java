/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class Iva {

    private static Iva instance;
    private float price;
    
    private Iva() {
    }

    public static synchronized Iva getInstance() {
        if (instance == null) {
            instance = new Iva();
        }
        return instance;
    }

    public float salesTotal(float priceConvert) {
        price = (priceConvert*(0.12F))+priceConvert;
        return price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
