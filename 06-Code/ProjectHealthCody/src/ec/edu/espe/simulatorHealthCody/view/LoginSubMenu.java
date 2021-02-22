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
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.validate.utils.Validate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mateo Ávila
 */
public class LoginSubMenu {

    public void UserAndAministrator() throws InterruptedException, ParseException {

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
                menu.loginAndRegistryMenu();
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
                        authentication = new Authentication(userName, accesKey, "Employees");
                        comparateAdmin = authentication.login();
                        if (comparateAdmin == false) {
                            System.out.println("Código o Contraseña INCORRECTO");
                        }
                    } while (comparateAdmin == false);

                    int opcAdmin;
                    do {
                        do {
                            System.out.println("\n\n\t\tMENÚ ADMINISTRADOR");
                            menu.adminTaskMenu();
                            System.out.print("Seleccione una opción: ");
                            optionL1 = scanner.nextLine();
                            opcAdmin = validate.Number(optionL1);
                        } while (opcAdmin < 1 || opcAdmin > 3);

                        switch (opcAdmin) {
                            case 1:// Inventario
                                int opcInventory;
                                do {

                                    Product product;
                                    Inventory inventory;
                                    do {
                                        System.out.println("\n\n\t\tINVENTARIO");
                                        menu.menuInventory();
                                        System.out.print("Seleccione una opción: ");
                                        optionL1 = scanner.nextLine();
                                        opcInventory = validate.Number(optionL1);
                                    } while (opcInventory < 1 || opcInventory > 6);
                                    switch (opcInventory) {
                                        case 1:// Inventory Agregar producto

                                            String name,
                                             code;
                                            double price;
                                            int quantity;
                                            System.out.println("\n\n");
                                            System.out.print("Ingrese el nombre del producto: ");
                                            name = scanner.nextLine();
                                            System.out.print("Ingrese el código del producto: ");
                                            code = scanner.nextLine();
                                            System.out.print("Ingrese el precio del producto: ");
                                            price = scanner.nextDouble();
                                            System.out.print("Ingrese la cantidad del producto: ");
                                            quantity = scanner.nextInt();
                                            product = new Product(name, code, price, quantity);
                                            inventory = new Inventory("Products");
                                            inventory.saveProduct(product);

                                            break;

                                        case 2:// Inventory buscar producto

                                            String recovered;
                                            System.out.println("\n\n");
                                            System.out.print("Ingrese algún dato del producto que desea buscar: ");
                                            //enter.nextLine();
                                            String dataTofind = scanner.nextLine();
                                            inventory = new Inventory("Products");
                                            recovered = inventory.findProduct(dataTofind);
                                            if (recovered.equals(null)) {
                                                System.out.println("Producto no existente");
                                            } else {
                                                product = gson.fromJson(recovered, Product.class);
                                                System.out.println(product);
                                            }

                                            break;

                                        case 3:// Inventory Modificar producto

                                            String dataToModify,
                                             dataToUpdate;
                                            System.out.println("\n\n");
                                            System.out.print("Ingrese el nombre del producto a modificar: ");
                                            dataToModify = scanner.nextLine();
                                            System.out.print("Ingrese el NOMBRE del NUEVO producto: ");
                                            dataToUpdate = scanner.nextLine();
                                            inventory = new Inventory("Products");
                                            inventory.updateProduct(dataToModify, dataToUpdate, "name");

                                            break;
                                        case 4:// Inventory eliminar producto

                                            String dataTodeleted;
                                            System.out.println("\n\n");
                                            System.out.print("Ingrese el código del producto a eliminar: ");
                                            dataTodeleted = scanner.nextLine();
                                            inventory = new Inventory("Products");
                                            inventory.deleteProduct(dataTodeleted, "code");

                                            break;

                                        case 5:// Inventory ver inevntario

                                            String[] jsonProducts;
                                            List<Product> products;
                                            products = new ArrayList();
                                            inventory = new Inventory("Products");
                                            jsonProducts = inventory.showProducts().split("\r\n");

                                            for (int i = 0; i < jsonProducts.length; i++) {
                                                products.add(gson.fromJson(jsonProducts[i], Product.class));
                                            }

                                            System.out.println("\n\n");

                                            System.out.println("\n\n\t\tPRODUCTOS DE INVENTARIO");
                                            for (int i = 0; i < products.size(); i++) {
                                                System.out.println("\n\n\tProducto " + (i + 1));
                                                System.out.print("\n" + products.get(i));
                                            }
                                            System.out.print("\n\nPRESIONE una tecla para continuar ");
                                            scanner.nextLine();

                                            break;
                                    }
                                } while (opcInventory != 6);

                                break;

                            case 2:// citas administrador
                                int opcAppointment;
                                Appointment appoiment;
                                do {

                                    do {
                                        System.out.println("\n\n\t\tMENÚ DE CITAS");
                                        menu.menuAppointmentAdmin();
                                        System.out.print("Seleccione una opción: ");
                                        optionL1 = scanner.nextLine();
                                        opcAppointment = validate.Number(optionL1);
                                    } while (opcAppointment < 1 || opcAppointment > 3);

                                    switch (opcAppointment) {
                                        case 1: // Citas Programar citas

                                            appoiment = new Appointment("Scheduled appointments");
                                            appoiment.schedule();

                                            //System.out.println("Registro de citas completado con éxito");
                                            break;

                                        case 2:// Citas Ver citas agendadas

                                            appoiment = new Appointment("Scheduled appointments");
                                            List<Date> dates;
                                            dates = appoiment.show();
                                            for (int i = 0; i < dates.size(); i++) {
                                                System.out.println((i + 1) + ")" + dates.get(i));
                                            }

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
                        authentication = new Authentication(userName, accesKey, "Customers");
                        compareCustom = authentication.login();
                        if (compareCustom == false) {
                            System.out.println("Código o Contraseña INCORRECTO");
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
                            menu.menuAppointmentCustomer();
                            System.out.print("Seleccione una opción: ");
                            optionL1 = scanner.nextLine();
                            opcAppoinemet = validate.Number(optionL1);
                        } while (opcAppoinemet < 1 || opcAppoinemet > 4);

                        Appointment appointment;
                        List<Date> dates;
                        switch (opcAppoinemet) {
                            case 1:// citas customer Agendar cita

                                int opc;
                                String selectedDate;
                                appointment = new Appointment("Scheduled appointments");
                                dates = appointment.show();

                                for (int i = 0; i < dates.size(); i++) {
                                    System.out.println((i + 1) + ")" + dates.get(i));
                                }
                                System.out.print("Seleccione una opción: ");
                                opc = scanner.nextInt();
                                selectedDate = appointment.delete(opc);

                                Registry registry;
                                registry = new Registry("Customers");
                                registry.updateUser("null" + userName, selectedDate, "codeAppoinment");

                                appointment = new Appointment("booked appointments");
                                appointment.add(selectedDate, userName);

                                break;

                            case 2:// Citas customer ver cita agendada 

                                appointment = new Appointment("booked appointments");
                                dates = appointment.show();
                                for (int i = 0; i < dates.size(); i++) {
                                    System.out.println((i + 1) + ")" + dates.get(i));
                                }

                                break;

                            case 3:// Citas customer Eliminar cita

                                System.out.println("Esta función está en mantenimiento");
                                appointment = new Appointment("booked appointments");

                                /*boolean status;
                                            status = appointment.deleteAppointment("CustomerList.json", userName);
                                            if (status == true) {
                                                System.out.println("Cita elimindada");
                                            } else {
                                                System.out.println("No encontrada");
                                            }*/
                                break;
                        }
                    } while (opcAppoinemet != 4);

                    break;

            }

        } while (optionLogin != 3);
    }
}
