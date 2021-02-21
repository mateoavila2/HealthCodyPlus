/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Appointment;
import ec.edu.espe.simulatorHealthCody.model.Authentication;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.PredictionOfCovid;
import ec.edu.espe.simulatorHealthCody.model.Product;
import ec.edu.espe.validate.utils.Validate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author George
 */
public class LoginSubMenu {
    
    public void UserAndAministrator() throws InterruptedException {
        
        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();
        Gson gson = new Gson();
        Menu menu = new Menu();
        String optionL1;
  
        int optionLogin;
                    do {
                        do {
                            System.out.println("\n\t\tINICIO DE SESIÓN");
                            System.out.println("\t\t¿Cómo deseas ingresar?\n");
                            menu.LoginAndRegistryMenu();
                            System.out.print("Seleccione una opción: ");
                            optionL1 = scanner.nextLine();
                            optionLogin = validate.Number(optionL1);
                        } while (optionLogin < 1 || optionLogin > 3);
                        String userName, accesKey;
                        Authentication authentication;
                        switch (optionLogin) {
                            case 1: //login administrator
                                boolean comparateAdmin;

                                do {
                                    System.out.println("\n\n");
                                    System.out.print("Ingrese su código de acceso: ");
                                    userName = validate.Words(scanner.nextLine());
                                    System.out.print("Ingrese su contraseña: ");
                                    accesKey = validate.Words(scanner.nextLine());
                                    authentication = new Authentication(userName, accesKey);
                                    comparateAdmin = authentication.login("Administrators.json");
                                    if (comparateAdmin == false) {
                                        System.out.println("Codigo o Contraseña INCORRECTO");
                                    }
                                } while (comparateAdmin == false);

                                int opcAdmin;
                                do {
                                    do {
                                        System.out.println("\n\n\t\tMENÚ ADMINISTRADOR");
                                        menu.AdminTaskMenu();
                                        System.out.print("Seleccione una opción: ");
                                        optionL1 = scanner.nextLine();
                                        opcAdmin = validate.Number(optionL1);
                                    } while (opcAdmin < 1 || opcAdmin > 3);

                                    switch (opcAdmin) {
                                        case 1:// Inventario
                                            int opcInventory;
                                            do {

                                                Product product = new Product("", "", 0.0, 0);
                                                Inventory inventory = new Inventory();
                                                do {
                                                    System.out.println("\n\n\t\tINVENTARIO");
                                                    menu.MenuInventory();
                                                    System.out.print("Seleccione una opción: ");
                                                    optionL1 = scanner.nextLine();
                                                    opcInventory = validate.Number(optionL1);
                                                } while (opcInventory < 1 || opcInventory > 6);
                                                switch (opcInventory) {
                                                    case 1:// Inventory Agregar producto
                                                        String word;
                                                        System.out.println("\n\n");
                                                        System.out.print("Ingrese el nombre del producto: ");
                                                        product.setName(scanner.nextLine());
                                                        System.out.print("Ingrese el código del producto: ");
                                                        product.setCode(scanner.nextLine());
                                                        System.out.print("Ingrese el precio del producto: ");

                                                        product.setPrice(scanner.nextDouble());
                                                        System.out.print("Ingrese la cantidad del producto: ");
                                                        opcAdmin = validate.Number(scanner.nextLine());
                                                        product.setQuantity(opcAdmin);
                                                        inventory.saveProduct(product);
                                                        break;

                                                    case 2:// Inventory buscar producto
                                                        System.out.println("\n\n");
                                                        System.out.print("Ingrese algún dato del producto que desea buscar: ");
                                                        //enter.nextLine();
                                                        String dataTofind = scanner.nextLine();
                                                        String recovered = inventory.findProduct(dataTofind);
                                                        ArrayList<Product> products = new ArrayList();
                                                        String[] dataSave = recovered.split("\r\n");
                                                        for (int i = 0; i < dataSave.length; i++) {
                                                            products.add(gson.fromJson(dataSave[i], Product.class));
                                                            System.out.println("\n\nProducto " + (i + 1) + "\n");
                                                            System.out.println(products.get(i));
                                                        }
                                                        break;

                                                    case 3:// Inventory Modificar producto
                                                        System.out.println("\n\n");
                                                        System.out.print("Ingrese el atributo del producto a modificar: ");
                                                        String dataToModify = scanner.nextLine();
                                                        System.out.print("Ingrese el NUEVO atributo: ");
                                                        String dataToUpdate = scanner.nextLine();
                                                        boolean update = inventory.modifyProduct(dataToModify, dataToUpdate);
                                                        if (update == true) {
                                                            System.out.println("Dato modificado con éxito");
                                                        } else {
                                                            System.out.println("El dato " + dataToModify + " no fue encontrado");
                                                        }
                                                        break;
                                                    case 4:// Inventory eliminar producto
                                                        System.out.println("\n\n");
                                                        System.out.print("Ingrese el código del producto a eliminar: ");
                                                        String dataTodeleted = scanner.nextLine();
                                                        boolean deleted = inventory.deleteProduct(dataTodeleted);
                                                        if (deleted == true) {
                                                            System.out.println("Producto eliminado ......");
                                                        } else {
                                                            System.out.println("El código del producto es incorrecto");
                                                        }
                                                        break;

                                                    case 5:// Inventory ver inevntario
                                                        System.out.println("\n\n");
                                                        ArrayList<Product> listProducts = new ArrayList();
                                                        listProducts = inventory.showInventory();
                                                        System.out.println("\n\n\t\tPRODUCTOS DE INVENTARIO");
                                                        for (int i = 0; i < listProducts.size(); i++) {
                                                            System.out.println("\n\n\tProducto " + (i + 1));
                                                            System.out.print("\n" + listProducts.get(i));
                                                        }
                                                        System.out.print("\n\nPRESIONE una tecla para continuar ");
                                                        scanner.nextLine();
                                                        break;
                                                }
                                            } while (opcInventory != 6);

                                            break;

                                        case 2:// citas administrador
                                            int opcAppointment;

                                            do {
                                                Appointment appoiment = new Appointment();
                                                do {
                                                    System.out.println("\n\n\t\tMENÚ DE CITAS");
                                                    menu.MenuAppointmentAdmin();
                                                    System.out.print("Seleccione una opción: ");
                                                    optionL1 = scanner.nextLine();
                                                    opcAppointment = validate.Number(optionL1);
                                                } while (opcAppointment < 1 || opcAppointment > 3);

                                                switch (opcAppointment) {
                                                    case 1: // Citas Programar citas
                                                        System.out.println("\n\n");
                                                        appoiment.generateAppointments();
                                                        appoiment.registerAppointment();
                                                        System.out.println("Registro de citas completado con éxito");
                                                        break;

                                                    case 2:// Citas Ver citas agendadas
                                                        System.out.println("\n\n");
                                                        appoiment.showAppointment("AppointmentGenerated.json");
                                                        break;

                                                }
                                            } while (opcAppointment != 3);

                                            break;

                                    }

                                } while (opcAdmin != 3);

                                break;

                            case 2://login customer
                                boolean compareCustom;
                                boolean verified;
                                do {

                                    System.out.println("\n\n");
                                    System.out.print("Ingrese su Usuario: ");
                                    userName = scanner.nextLine();
                                    System.out.print("Ingrese su contraseña: ");
                                    accesKey = scanner.nextLine();
                                    authentication = new Authentication(userName, accesKey);
                                    compareCustom = authentication.login("Cutomers.json");
                                    if (compareCustom == false) {
                                        System.out.println("Codigo o Contraseña INCORRECTO");
                                    }
                                } while (compareCustom == false);
                                //verified = loginCustomer.checkFirtsTime();
                                verified = true;
                                if (verified == false) {
                                    System.out.println("\n\t\t BIENVENIDO  " + userName);
                                    System.out.println("\n\t\t COMPLETA LA SIGUIENTE ENCUESTA");
                                    PredictionOfCovid.prediction();
                                    System.out.println("\n\t Presione una tecla para continuar");
                                    scanner.nextLine();
                                }
                                int opcAppoinemet;
                                do {

                                    do {
                                        System.out.println("\n\n\t\tCITAS");
                                        menu.MenuAppointmentCustomer();
                                        System.out.print("Seleccione una opción: ");
                                        optionL1 = scanner.nextLine();
                                        opcAppoinemet = validate.Number(optionL1);
                                    } while (opcAppoinemet < 1 || opcAppoinemet > 4);

                                    Appointment appointment = new Appointment();
                                    switch (opcAppoinemet) {
                                        case 1:// citas customer Agendar cita
                                            appointment.showAppointment("AppointmentGenerated.json");
                                            System.out.print("\nSeleccione una cita para agendarla: ");
                                            int numberAppointment = validate.Number(scanner.nextLine());
                                            appointment.saveCustomerAppointment(numberAppointment, userName);
                                            System.out.println("AGENDANDO CITA...\n ");
                                            Thread.sleep(2000);
                                            System.out.println("CITA AGENDADA CON ÉXITO");
                                            break;

                                        case 2:// Citas customer ver cita agendada 
                                            String appoimentCustomer;
                                            appoimentCustomer = appointment.showAppointmentCustomer(userName);
                                            System.out.println(appoimentCustomer);
                                            System.out.println("PRESIONE una tecla para continuar");
                                            scanner.nextLine();
                                            break;

                                        case 3:// Citas customer Eliminar cita
                                            boolean status;
                                            status = appointment.deleteAppointment("CustomerList.json", userName);
                                            if (status == true) {
                                                System.out.println("Cita elimindada");
                                            } else {
                                                System.out.println("No encontrada");
                                            }
                                            break;
                                    }
                                } while (opcAppoinemet != 4);

                                break;

                        }

                    } while (optionLogin != 3);
    }
    
}
