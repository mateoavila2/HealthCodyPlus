/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.util.Date;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Appointment {
    private Date date;
    private String time;
    private String campus;

    public Appointment(Date date, String time, String campus) {
        this.date = date;
        this.time = time;
        this.campus = campus;
    }

    public void scheduleAppointments(){
    
    
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Appointment{" + "date=" + date + ", time=" + time + ", campus=" + campus + '}';
    }
    
    
    
    
}
