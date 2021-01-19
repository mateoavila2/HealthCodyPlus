/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.model.DateAppoiment;
import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Appoiment {

    Gson gson = new Gson();
    ArrayList<ArrayList<java.util.Date>> weekend;
    ArrayList<DateAppoiment> appoiments;

    public Appoiment() {
        weekend = new ArrayList();
        appoiments = new ArrayList();
    }

    public void generateAppointments() {
        for (int j = 0; j < 3; j++) {
            ArrayList<java.util.Date> dates = new ArrayList();

            for (int i = 0; i < 3; i++) {
                java.util.Date d1 = new java.util.Date();
                d1.setDate(d1.getDate() + j);
                d1.setHours(9 + i);
                d1.setMinutes(0);
                d1.setSeconds(0);
                dates.add(d1);

            }
            weekend.add(dates);
        }

    }

    public void registerAppoiment() {
        for (int i = 0; i < weekend.size(); i++) {
            for (int j = 0; j < weekend.size(); j++) {
                int day = weekend.get(i).get(j).getDate();
                int month = weekend.get(i).get(j).getMonth();
                int year = weekend.get(i).get(j).getYear();
                int hour = weekend.get(i).get(j).getHours();
                int minutes = weekend.get(i).get(j).getMinutes();
                int seconds = weekend.get(i).get(j).getMinutes();
                DateAppoiment p1 = new DateAppoiment(day, month, year, hour, minutes, seconds);
                p1.setCode((p1.getDay()+"")+(p1.getMonth()+"")+(p1.getHour()+""));
                String jsonAppoiment = gson.toJson(p1);
                FileManager.save("AppoimentGenerated.json", jsonAppoiment);
            }
        }
    }

    public void showAppoiment(String nameFile) {
        String appoimentFromFile = FileManager.findAll(nameFile);
        String[] dataAppoiment = appoimentFromFile.split("\r\n");
        
        for (int i = 0; i < dataAppoiment.length; i++) {
            this.appoiments.add(gson.fromJson(dataAppoiment[i], DateAppoiment.class));
        }

        for (int i = 0; i < this.appoiments.size(); i++) {
            Date f3 = new Date();
            f3.setDate(this.appoiments.get(i).day);
            f3.setMonth(this.appoiments.get(i).month);
            f3.setYear(this.appoiments.get(i).year);
            f3.setHours(this.appoiments.get(i).hour);
            f3.setMinutes(this.appoiments.get(i).minutes);
            f3.setSeconds(this.appoiments.get(i).seconds);
            System.out.println((i+1)+")  "+f3 + "\n");
        }
    }
    
    public void saveCustomerAppointment(int date,String user)
    {
        Scanner enter = new Scanner(System.in);
        DateAppoiment dataAppoinment = new DateAppoiment(0,0,0,0,0,0);
        String allData = FileManager.findAll("AppoimentGenerated.json");
        String[] savedAllData = allData.split("\r\n");
        for(int i=0;i<savedAllData.length;i++){
            if(date==(i+1))
            {
                dataAppoinment=gson.fromJson(savedAllData[i],DateAppoiment.class);
            }
        }
        String jsonReserve = gson.toJson(dataAppoinment);
        FileManager.delete("AppoimentGenerated.json",dataAppoinment.getCode());
        FileManager.save("ScheduleAppoinment.json",jsonReserve);
        Customer customer = new Customer("","","",0,"","");
        String dataCustomer=FileManager.find("CustomerList.json",user);
        customer = gson.fromJson(dataCustomer,Customer.class);
        customer.setCustomerCode(dataAppoinment.getCode());
        FileManager.delete("CustomerList.json",user);
        String jsonCustomer = gson.toJson(customer);
        FileManager.save("CustomerList.json",jsonCustomer);
    }
    
    /*public void deleteCustomerAppointment()
    {
        String dataCustomerAppointment=FileManager.find("", "code");
        ArrayList<Customer> dates = new ArrayList();
        String[] dataSave = dataCustomerAppointment.split("\r\n");
        
        System.out.println("Sus citas agendadas son: ");
        for(int i=0;i<dataSave.length;i++)
        {
            dates.add(gson.fromJson(dataSave[i],Customer.class));
            System.out.println((i+1)+")"+dates.get(i));
        }
    }
    */

}
