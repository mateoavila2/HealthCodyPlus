/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Employee extends User {

    private double salary;
    private String numberPhone;

    public Employee(String name, String id, int age, String gender, String userName, String accesKey) {
        super(name, id, age, gender, userName, accesKey);
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

    @Override
    public String toString() {
        return "Employee{" + "salary=" + salary + ", numberPhone=" + numberPhone + '}' + super.toString();
    }

}
