/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Rafa
 */
public class Employee extends User {

    private double salary;
    private String numberPhone;

    public Employee(String name, String id, int age, String gender, String numberPhone, String userName, String accesKey) {
        super(name, id, age, gender, userName, accesKey);
        this.numberPhone = numberPhone;
        salary = 800.50;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
