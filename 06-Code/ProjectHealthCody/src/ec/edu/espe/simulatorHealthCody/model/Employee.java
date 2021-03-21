/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo Ávila
 */
public class Employee extends User {

    private double salary;
    private String numberPhone;

    public Employee(String name, String id, String dateOfBirth, String gender, String numberPhone, String userName, String accesKey) {
        super(name, id, dateOfBirth, gender, userName, accesKey);
        this.numberPhone = numberPhone;
        salary = 800.50;
    }

    public Employee() {
    }
    
    
    public String generateCode(){
        
        String code = "";
        int number;
        char character;
        for(int i=0;i<7;i++){
            number = (int) (Math.random() * (91 - 65)) + 65;
            character = (char) number;
            code += character;
        }
        return code;
    
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
