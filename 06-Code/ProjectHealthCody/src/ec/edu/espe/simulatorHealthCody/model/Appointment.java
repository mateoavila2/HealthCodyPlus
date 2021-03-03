/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.utils.DBmanagerDates;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Mateo Ávila
 */
public class Appointment {
    
    private List<Date> datesOfWeek;
    private DBmanagerDates dateOperation;
    private String collection;
    private String code;

    public Appointment(String collection) {
        code = "inspecific";
        this.collection = collection;
        datesOfWeek = new ArrayList();
        dateOperation = new DBmanagerDates("Appointment", this.collection);
    }

    //Administrator Methods
    public void schedule() {
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                Date date = new Date();
                date.setDate(date.getDate() + i);
                date.setHours(9 + j);
                date.setMinutes(0);
                date.setSeconds(0);
                datesOfWeek.add(date);
            }

        }
        DateFormat dateFormat;
        for (int i = 0; i < datesOfWeek.size(); i++) {
            dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String date = dateFormat.format(datesOfWeek.get(i));
            dateOperation.createDate(date, code + (i + 1));
        }
    }

    public void add(String date, String code) {
        dateOperation.createDate(date, code);
    }

    public List<Date> show() throws ParseException {

        DateFormat dateFormat;
        Date date;
        System.out.println("");
        String[] dates = dateOperation.readDate().split("\r\n");
        for (String date1 : dates) {
            dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            date = dateFormat.parse(date1);
            datesOfWeek.add(date);
        }
        return datesOfWeek;
    }
    
    public void find(String dataTofind){
        /*String date;
        dateOperations.*/
    
    }

    public String delete(int opc) throws ParseException {
        String reserveDate = "";
        System.out.println("");
        String[] dates = dateOperation.readDate().split("\r\n");
        for (int i = 0; i < dates.length; i++) {
            if (opc == (i + 1)) {
                reserveDate = dates[i];
                dateOperation.delete("date", dates[i]);
            }
        }
        return reserveDate;

    }

    public List<Date> getDatesOfWeek() {
        return datesOfWeek;
    }

    public void setDatesOfWeek(List<Date> datesOfWeek) {
        this.datesOfWeek = datesOfWeek;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
