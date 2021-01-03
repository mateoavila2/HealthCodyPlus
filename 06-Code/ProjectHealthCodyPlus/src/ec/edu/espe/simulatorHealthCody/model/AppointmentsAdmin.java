/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.controller.MenuAppointmentsAdmin;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class AppointmentsAdmin {

    /**
     * @return the menuAppointmentsAdmin
     */
    public MenuAppointmentsAdmin getMenuAppointmentsAdmin() {
        return menuAppointmentsAdmin;
    }

    /**
     * @param menuAppointmentsAdmin the menuAppointmentsAdmin to set
     */
    public void setMenuAppointmentsAdmin(MenuAppointmentsAdmin menuAppointmentsAdmin) {
        this.menuAppointmentsAdmin = menuAppointmentsAdmin;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
    
    private MenuAppointmentsAdmin menuAppointmentsAdmin = new MenuAppointmentsAdmin();;
    private String date;
    private String time;
    
    public AppointmentsAdmin(String date, String time)
    {
         menuAppointmentsAdmin.SceduleAppointments();
         date =  menuAppointmentsAdmin.dateAppointment();
         time =  menuAppointmentsAdmin.timeAppointment();
         this.date = date;
         this.time = time;
    }
    @Override
    public String toString() {
        return getDate() + "," + getTime() + "\n";
    }
}
