/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.simulatorHealthCody.model.DateAppointment;
import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Appointment {

    Gson gson = new Gson();
    ArrayList<ArrayList<java.util.Date>> weekend;
    ArrayList<DateAppointment> appointments;

    public Appointment() {
        weekend = new ArrayList();
        appointments = new ArrayList();
    }

    //METODOS DE ADMINISTRADOR 
    public void generateAppointments() {
        for (int j = 0; j < 3; j++) {
            ArrayList<java.util.Date> dates = new ArrayList();

            for (int i = 0; i < 3; i++) {
                java.util.Date datesGenerated = new java.util.Date();
                datesGenerated.setDate(datesGenerated.getDate() + j);
                datesGenerated.setHours(9 + i);
                datesGenerated.setMinutes(0);
                datesGenerated.setSeconds(0);
                dates.add(datesGenerated);

            }
            weekend.add(dates);
        }
    }

    public void registerAppointment() {
        for (int i = 0; i < weekend.size(); i++) {
            for (int j = 0; j < weekend.size(); j++) {
                int day = weekend.get(i).get(j).getDate();
                int month = weekend.get(i).get(j).getMonth();
                int year = weekend.get(i).get(j).getYear();
                int hour = weekend.get(i).get(j).getHours();
                int minutes = weekend.get(i).get(j).getMinutes();
                int seconds = weekend.get(i).get(j).getMinutes();
                DateAppointment p1 = new DateAppointment(day, month, year, hour, minutes, seconds);
                p1.setCode((p1.getDay() + "") + (p1.getMonth() + "") + (p1.getHour() + ""));
                String jsonAppoiment = gson.toJson(p1);
                FileManager.save("AppointmentGenerated.json", jsonAppoiment);
            }
        }
    }

    public void showAppointment(String nameFile) {
        String appointmentFromFile = FileManager.findAll(nameFile);
        String[] dataAppointment = appointmentFromFile.split("\r\n");

        for (int i = 0; i < dataAppointment.length; i++) {
            this.appointments.add(gson.fromJson(dataAppointment[i], DateAppointment.class));
        }

        for (int i = 0; i < this.appointments.size(); i++) {
            Date datesAppointment = new Date();
            datesAppointment.setDate(this.appointments.get(i).day);
            datesAppointment.setMonth(this.appointments.get(i).month);
            datesAppointment.setYear(this.appointments.get(i).year);
            datesAppointment.setHours(this.appointments.get(i).hour);
            datesAppointment.setMinutes(this.appointments.get(i).minutes);
            datesAppointment.setSeconds(this.appointments.get(i).seconds);
            System.out.println((i + 1) + ")  " + datesAppointment + "\n");
        }
    }

    //MÉTODOS DE CUSTOMER
    public void saveCustomerAppointment(int date, String user) {
        Scanner enter = new Scanner(System.in);
        DateAppointment dataAppointment = new DateAppointment(0, 0, 0, 0, 0, 0);
        String allData = FileManager.findAll("AppointmentGenerated.json");
        String[] savedAllData = allData.split("\r\n");
        for (int i = 0; i < savedAllData.length; i++) {
            if (date == (i + 1)) {
                dataAppointment = gson.fromJson(savedAllData[i], DateAppointment.class);
            }
        }
        String jsonReserve = gson.toJson(dataAppointment);
        FileManager.delete("AppointmentGenerated.json", dataAppointment.getCode());
        FileManager.save("ScheduleAppointment.json", jsonReserve);
        Customer customer = new Customer("", "", "", 0, "", "");
        String dataCustomer = FileManager.find("CustomerList.json", user);
        customer = gson.fromJson(dataCustomer, Customer.class);
        if (customer.getCustomerCode().equals("0")) {
            customer.setCustomerCode(dataAppointment.getCode());
            FileManager.delete("CustomerList.json", user);
            String jsonCustomer = gson.toJson(customer);
            FileManager.save("CustomerList.json", jsonCustomer);
        } else {
            System.out.println("Ya ha agendado una cita, revise su agenda de citas");
            FileManager.delete("ScheduleAppointment.json", dataAppointment.getCode());
            FileManager.save("AppointmentGenerated.json", jsonReserve);
        }
    }

    public String showAppointmentCustomer(String user) {
        String appointmentCustomer;
        try {
            Customer customer = new Customer("", "", "", 0, "", "");
            String dataCustomer = FileManager.find("CustomerList.json", user);
            customer = gson.fromJson(dataCustomer, Customer.class);
            String dateAppoinment = FileManager.find("ScheduleAppointment.json", customer.getCustomerCode());
            DateAppointment appointment = new DateAppointment(0, 0, 0, 0, 0, 0);
            appointment = gson.fromJson(dateAppoinment, DateAppointment.class);

            Date convertedDate = new Date();
            convertedDate.setDate(appointment.getDay());
            convertedDate.setMonth(appointment.getMonth());
            convertedDate.setYear(appointment.getYear());
            convertedDate.setHours(appointment.getHour());
            convertedDate.setMinutes(appointment.getMinutes());
            convertedDate.setSeconds(appointment.getSeconds());

            appointmentCustomer = "\n\n\nNombre: " + customer.getNamePerson() + "\n"
                    + "Identificación: " + customer.getIdPerson() + "\n"
                    + "Fecha de cita: " + convertedDate;
        } catch (Exception e) {
            appointmentCustomer = "No tiene citas agendadas";
        }

        return appointmentCustomer;
    }

    public boolean deleteAppointment(String fileName, String user) {
        boolean status;
        String jsonaCustom = FileManager.find(fileName, user);
        Customer customer = new Customer("", "", "", 0, "", "");
        customer = gson.fromJson(jsonaCustom, Customer.class);
        String jsonDate = FileManager.find("ScheduleAppointment.json", customer.getCustomerCode());
        DateAppointment dateRelocate = new DateAppointment(0, 0, 0, 0, 0, 0);
        dateRelocate = gson.fromJson(jsonDate, DateAppointment.class);
        FileManager.save("AppointmentGenerated.json", gson.toJson(dateRelocate));
        status = FileManager.delete("ScheduleAppointment.json", customer.getCustomerCode());
        FileManager.delete(fileName, user);
        customer.setCustomerCode("0");
        FileManager.save(fileName, gson.toJson(customer));

        return status;

    }

}
