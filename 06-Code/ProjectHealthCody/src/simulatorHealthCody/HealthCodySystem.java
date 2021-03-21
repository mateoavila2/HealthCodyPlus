/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatorHealthCody;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.controller.LoginCustomerController;
import ec.edu.espe.simulatorHealthCody.model.Appointment;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.simulatorHealthCody.utils.MongoDBManager;
import ec.edu.espe.simulatorHealthCody.view.LoginCustomer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rafa
 */
public class HealthCodySystem {

    public static void main(String[] args) throws ParseException {

        //SISTEMA HEALTH CODY PLUSS Oficial MVC
        LoginCustomer loginCustomer;
        LoginCustomerController loginCustomerController;
        loginCustomer = new LoginCustomer();
        loginCustomerController = new LoginCustomerController(loginCustomer);
        loginCustomerController.show();

    }
}
