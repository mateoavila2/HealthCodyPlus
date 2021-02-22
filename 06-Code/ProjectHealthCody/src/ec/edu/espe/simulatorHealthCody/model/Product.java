/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Mateo Ávila
 */
public class Product {

    private String name;
    private String code;
    private double price;
    private int quantity;

    public Product(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public String getNameProduct() {
        return name;
    }

    public void setNameProduct(String nameProduct) {
        this.name = nameProduct;
    }

    public String getCodeProduct() {
        return code;
    }

    public void setCodeProduct(String codeProduct) {
        this.code = codeProduct;
    }

    public double getPriceProduct() {
        return price;
    }

    public void setPriceProduct(double priceProduct) {
        this.price = priceProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Nombre del producto: " + name + "\n"
                + "Código del producto: " + code + "\n"
                + "Precio del producto: " + price + "\n"
                + "Cantidad de producto: " + quantity;
    }

}
