/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class AppointmentsAdminList {

    /**
     * @return the appointmentsAdminList
     */
    public ArrayList<AppointmentsAdmin> getAppointmentsAdminList() {
        return appointmentsAdminList;
    }

    /**
     * @param appointmentsAdminList the appointmentsAdminList to set
     */
    public void setAppointmentsAdminList(ArrayList<AppointmentsAdmin> appointmentsAdminList) {
        this.appointmentsAdminList = appointmentsAdminList;
    }
    
    private ArrayList<AppointmentsAdmin> appointmentsAdminList;
    
    public AppointmentsAdminList() {
        appointmentsAdminList = new ArrayList();
    }
    
    public void saveAppointments(AppointmentsAdmin appointmentsAdmin){
        FileWriter file;
        BufferedWriter write;
        try
        {
            File f = new File("scheduledAppointments.txt");

            file = new FileWriter("scheduledAppointments.txt",true);
            if(f.exists())
            {
                write =new BufferedWriter(file);
                write.write(appointmentsAdmin.toString());
                write.close();
                }   
            else
            {
                file = new FileWriter("scheduledAppointments.txt",true);
            }    
        }catch(IOException ex)
        {
           Logger.getLogger(AppointmentsAdmin.class.getName()).log(Level.SEVERE,null,ex);     
        }
    }
    
    public void readFile(){
        try {
            FileReader  readFile;
            BufferedReader read;
            readFile=new FileReader("scheduledAppointments.txt");
            read=new BufferedReader(readFile);
            String recovered="";
            while(read.ready()){
                AppointmentsAdmin appointmentsAdmin = new AppointmentsAdmin("","");
                recovered=read.readLine();
                String[]data=recovered.split(",");
                appointmentsAdmin.setDate(data[0]);
                appointmentsAdmin.setTime(data[1]);
                getAppointmentsAdminList().add(appointmentsAdmin);
            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppointmentsAdminList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppointmentsAdminList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
