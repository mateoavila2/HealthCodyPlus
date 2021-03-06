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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateo Ávila
 */
public class Customer extends User{

    private static String codeAppoinment;
    public Customer(String name, String id, String dateOfBirth, String gender, String userName, String accesKey) {
        super(name, id, dateOfBirth, gender, userName, accesKey);
    }

    public Customer() {
    }
    

    

    public String getCodeAppoinment() {
        return codeAppoinment;
    }

    public void setCodeAppoinment(String codeAppoinment) {
        this.codeAppoinment = codeAppoinment;
    }

    @Override
    public void calculateAge() {
       DateFormat dateFormat;
        Date date;
        System.out.println("");
            dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date myDate = dateFormat.parse(dateOfBirth);
            int day = myDate.getDay();
            int month = myDate.getMonth();
            int year = myDate.getYear()+1900;
            Date dateActual = new Date();
            int dayAct = dateActual.getDate();
            int monthAct = dateActual.getMonth()+1;
            int yearAct = dateActual.getYear()+1900;
            System.out.println(day+"/"+month+"/"+year);
            System.out.println(dayAct+"/"+dayAct+"/"+yearAct);
            int diferencia = yearAct - year;
            if(monthAct<= month)
            {
                if(monthAct==month)
                {
                    if(day>dayAct)
                    {
                        diferencia--;
                    }
                    else
                    {
                        diferencia--;
                    }
                }
            }
            if(diferencia<18)
            {
                System.out.println("Ni ouede crear cuenta");
            }
        } catch (ParseException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
