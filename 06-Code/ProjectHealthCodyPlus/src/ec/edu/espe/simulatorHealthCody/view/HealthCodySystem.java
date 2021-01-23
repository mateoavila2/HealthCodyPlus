/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;
import static ec.edu.espe.simulatorHealthCody.controller.Validate.validate;
import ec.edu.espe.simulatorHealthCody.model.Administrator;
import ec.edu.espe.simulatorHealthCody.model.Appointment;
import ec.edu.espe.simulatorHealthCody.model.User;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
/// codido acceso : Admin1725M
/// contraseña: ka123
public class HealthCodySystem {

    public static void main(String[] args) throws InterruptedException {

        Scanner enter = new Scanner(System.in);
        Gson gson = new Gson();
        Menu menu = new Menu();
        System.out.println("\t\t BIENVENIDO AL SISTEMA DE HEALTH CODY PLUS +");
        String optionL1;
        String optionR1;
        int option1;
        do {

            do {
                menu.MenuPrincipal();
                System.out.print("Seleccione una opción: ");
                optionL1 = enter.nextLine();
                option1 = validate(optionL1);
            } while (option1 < 1 || option1 > 3);
            switch (option1) {
                case 1:// Menu de inicio de sesion
                    int optionLogin;

                    do {
                        do {
                            System.out.println("\n\t\tINICIO DE SESIÓN");
                            System.out.println("\t\t¿Cómo deseas ingresar?\n");
                            menu.LoginAndRegistryMenu();
                            System.out.print("Seleccione una opción: ");
                            optionL1 = enter.nextLine();
                            optionLogin = validate(optionL1);
                        } while (optionLogin < 1 || optionLogin > 3);
                        switch (optionLogin) {
                            case 1: //login administrator
                                boolean comparateAdmin;
                                String userAdmin = "";
                                String codeAdmin;
                                String passwordAdmin;
                                do {
                                    System.out.println("\n\n");
                                    System.out.print("Ingrese su código de acceso: ");
                                    codeAdmin = enter.nextLine();
                                    System.out.print("Ingrese su contraseña: ");
                                    passwordAdmin = enter.nextLine();
                                    User loginAdmin = new User(userAdmin, codeAdmin, passwordAdmin);
                                    comparateAdmin = loginAdmin.LoginAdministrator();
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
                                        optionL1 = enter.nextLine();
                                        opcAdmin = validate(optionL1);
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
                                                    optionL1 = enter.nextLine();
                                                    opcInventory = validate(optionL1);
                                                } while (opcInventory < 1 || opcInventory > 6);
                                                switch (opcInventory) {
                                                    case 1:// Inventory Agregar producto
                                                        System.out.println("\n\n");
                                                        System.out.print("Ingrese el nombre del producto: ");
                                                        product.setNameProduct(enter.nextLine());
                                                        System.out.print("Ingrese el código del producto: ");
                                                        product.setCodeProduct(enter.nextLine());
                                                        System.out.print("Ingrese el precio del producto: ");
                                                        product.setPriceProduct(enter.nextDouble());
                                                        System.out.print("Ingrese la cantidad del producto: ");
                                                        product.setQuantity(enter.nextInt());
                                                        inventory.saveProduct(product);
                                                        break;

                                                    case 2:// Inventory buscar producto
                                                        System.out.println("\n\n");
                                                        System.out.print("Ingrese algún dato del producto que desea buscar: ");
                                                        //enter.nextLine();
                                                        String dataTofind = enter.nextLine();
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
                                                        String dataToModify = enter.nextLine();
                                                        System.out.print("Ingrese el NUEVO atributo: ");
                                                        String dataToUpdate = enter.nextLine();
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
                                                        String dataTodeleted = enter.nextLine();
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
                                                        enter.nextLine();
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
                                                    optionL1 = enter.nextLine();
                                                    opcAppointment = validate(optionL1);
                                                } while (opcAppointment < 1 || opcAppointment > 3);

                                                switch (opcAppointment) {
                                                    case 1: // Citas Programar citas
                                                        System.out.println("\n\n");
                                                        appoiment.generateAppointments();
                                                        appoiment.registerAppoiment();
                                                        System.out.println("Registro de citas completado con éxito");
                                                        break;

                                                    case 2:// Citas Ver citas agendadas
                                                        System.out.println("\n\n");
                                                        appoiment.showAppoiment("AppoimentGenerated.json");
                                                        break;

                                                }
                                            } while (opcAppointment != 3);

                                            break;

                                    }

                                } while (opcAdmin != 3);

                                break;

                            case 2://login customer
                                boolean compareCustom = false;
                                boolean verified;
                                String userCustomer = "";
                                String passwordCustomer;
                                User loginCustomer = new User("", "");
                                do {
                                    try {
                                        System.out.println("\n\n");
                                        System.out.print("Ingrese su usuario: ");
                                        userCustomer = enter.nextLine();
                                        loginCustomer.setUser(userCustomer);
                                        System.out.print("Ingrese su contraseña: ");
                                        passwordCustomer = enter.nextLine();
                                        loginCustomer.setPassword(passwordCustomer);
                                        compareCustom = loginCustomer.LoginCustomer();
                                    } catch (Exception e) {
                                        System.out.println("Usuario o contraseña incorrecto");
                                    }
                                } while (compareCustom == false);
                                verified = loginCustomer.checkFirtsTime();
                                if (verified == false) {
                                    System.out.println("\n\t\t BIENVENIDO  "+userCustomer);
                                    System.out.println("\n\t\t COMPLETA LA SIGUIENTE ENCUESTA");
                                    prediction();
                                    System.out.println("\n\t Presione una tecla para continuar");
                                    enter.nextLine();
                                }
                                int opcAppoinemet;
                                do {

                                    do {
                                        System.out.println("\n\n\t\tCITAS");
                                        menu.MenuAppointmentCustomer();
                                        System.out.print("Seleccione una opción: ");
                                        optionL1 = enter.nextLine();
                                        opcAppoinemet = validate(optionL1);
                                    } while (opcAppoinemet < 1 || opcAppoinemet > 4);

                                    Appointment appointment = new Appointment();
                                    switch (opcAppoinemet) {
                                        case 1:// citas customer Agendar cita
                                            appointment.showAppoiment("AppoimentGenerated.json");
                                            System.out.print("\nSeleccione una cita para agendarla: ");
                                            int numberAppointment = enter.nextInt();
                                            appointment.saveCustomerAppointment(numberAppointment, userCustomer);
                                            System.out.println("AGENDANDO CITA...\n ");
                                            Thread.sleep(2000);
                                            System.out.println("CITA AGENDADA CON ÉXITO");
                                            break;

                                        case 2:// Citas customer ver cita agendada 
                                            String appoimentCustomer;
                                            appoimentCustomer = appointment.showAppointmentCustomer(userCustomer);
                                            System.out.println(appoimentCustomer);
                                            System.out.println("PRESIONE una tecla para continuar");
                                            enter.nextLine();
                                            break;

                                        case 3:// Citas customer Eliminar cita
                                            boolean status;
                                            status = appointment.deleteAppointment("CustomerList.json", userCustomer);
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

                    break;

                case 2: // Registro

                    int opcRegistry;

                    do {
                        do {
                            System.out.println("\n\n\t\tREGISTRATE");
                            System.out.println("\t\t¿Cómo deseas registrarte?");
                            menu.LoginAndRegistryMenu();
                            System.out.print("Seleccione una opción: ");
                            optionR1 = enter.nextLine();
                            opcRegistry = validate(optionR1);
                        } while (opcRegistry < 1 || opcRegistry > 3);
                        String namePerson,
                                idPerson,
                                genderPerson;
                        String dataPassword;
                        String dataUser;
                        switch (opcRegistry) {
                            case 1:// Registry admin

                                int agePerson;
                                System.out.println("Complete los siguientes datos");
                                enter.nextLine();
                                System.out.print("Ingrese su nombre: ");
                                namePerson = enter.nextLine();
                                System.out.print("Ingrese su número de identificación: ");
                                idPerson = enter.nextLine();
                                System.out.print("Ingrese su género: ");
                                genderPerson = enter.nextLine();
                                System.out.print("Ingrese su edad: ");
                                agePerson = enter.nextInt();
                                System.out.println("Guardando...........");
                                Thread.sleep(2000);
                                System.out.print("Cree una contraseña: ");
                                enter.nextLine();
                                dataPassword = enter.nextLine();
                                Administrator administrator = new Administrator(namePerson, idPerson, genderPerson, agePerson, "", dataPassword);
                                Registry registryAdmin = new Registry(administrator);
                                registryAdmin.generateAdminCode();
                                registryAdmin.registerAdministrator();
                                System.out.println("Generando código de acceso");
                                Thread.sleep(1000);
                                System.out.println("Su código de acceso es: " + administrator.getAdministratorCode());
                                Thread.sleep(1000);

                                break;

                            case 2:
                                System.out.println("Complete los siguientes datos");
                                enter.nextLine();
                                System.out.print("Ingrese su nombre: ");
                                namePerson = enter.nextLine();
                                System.out.print("Ingrese su número de identificación: ");
                                idPerson = enter.nextLine();
                                System.out.print("Ingrese su género: ");
                                genderPerson = enter.nextLine();
                                System.out.print("Ingrese su edad: ");
                                agePerson = enter.nextInt();
                                System.out.println("Guardando...........");
                                Thread.sleep(2000);
                                System.out.print("Cree un usuario: ");
                                enter.nextLine();
                                dataUser = enter.nextLine();
                                System.out.print("Cree una contraseña: ");
                                dataPassword = enter.nextLine();
                                System.out.println("Guardando...........");
                                Thread.sleep(2000);
                                Customer customer = new Customer(namePerson, idPerson, genderPerson, agePerson, dataUser, dataPassword);
                                Registry registryCustomer = new Registry(customer);
                                registryCustomer.registerCustomer();

                                break;
                        }
                    } while (opcRegistry != 3);
                    break;

            }
        } while (option1 != 3);

    }

    public static void prediction() {
        int suma = 0;
        int answer;
        float temp;
        Scanner read = new Scanner(System.in);
        System.out.println("\n\n¡Test de predicción de COVID-19!\n");

        System.out.println("\n¿Presenta tos nueva o que va empeorando? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = read.nextInt();
        if (answer == 1) {
            suma = suma + 2;
        }
        System.out.println("\n¿Presenta pérdida sostenida del olfato, el gusto o el apetito? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = read.nextInt();
        if (answer == 1) {
            suma = suma + 3;
        }
        System.out.println("\n¿Presenta dolor de garganta? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = read.nextInt();
        if (answer == 1) {
            suma = suma + 2;
        }

        System.out.println("\n¿Presenta dificultad para respirar leve o moderada? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = read.nextInt();
        if (answer == 1) {
            suma = suma + 3;
        }
        System.out.println("\nEn los últimos 14 días, ¿Viajó al exterior?");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = read.nextInt();
        if (answer == 1) {
            suma = suma + 3;
        }
        System.out.println("\nEn los últimos 14 días, ¿ha tenido contacto con otras personas que han contraído COVID-19?");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = read.nextInt();
        if (answer == 1) {
            suma = suma + 3;
        }

        System.out.println("-----------------------------------\n¡Fin del test!\n-----------------------------------");
        if (suma >= 12) {
            System.out.println("\nNivel de sospecha: Alto.");
            System.out.println("Prueba PCR o rápida: NECESARIA\n");
            System.out.println("------------------------------------");
        } else if (suma >= 3) {
            System.out.println("\nNivel de sospecha: Medio.");
            System.out.println("Prueba PCR o rápida: RECOMENDABLE\n");
            System.out.println("------------------------------------");
        } else if (suma <= 2) {
            System.out.println("\nNivel de sospecha: Bajo.");
            System.out.println("\nPrueba PCR o rápida: NO NECESARIA\n");
            System.out.println("------------------------------------");
        }
    }
}
