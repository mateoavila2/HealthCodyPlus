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
public class HealtCodySystem {

    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        Gson gson = new Gson();
        Menu menu = new Menu();

        System.out.println("\t\t BIENVENIDO AL SISTEMA DE HEALTHCODY PLUS +");
        String optionTotal;
        int option1;
        do {
            menu.MenuPrincipal();
            System.out.print("Seleccione una opción: ");
            optionTotal = enter.nextLine();
            option1 = validate(optionTotal);

            switch (option1) {
                case 1: // Menu de inicio de sesion
                    int optionLogin;
                    do {
                        System.out.println("\n\t\tINICIO DE SESIÓN");
                        System.out.println("\t\t¿Como deseas Ingresar?\n");
                        menu.LoginAndRegistryMenu();
                        System.out.print("Seleccione una opción: ");
                        optionTotal = enter.nextLine();
                        optionLogin = validate(optionTotal);
                    } while (optionLogin < 1 || optionLogin > 2);

                    switch (optionLogin) {
                        case 1: //login administrator
                            boolean comparateAdmin;
                            String userAdmin = "";
                            String codeAdmin;
                            String passwordAdmin;
                            do {
                                System.out.print("Ingrese su código de acceso: ");
                                codeAdmin = enter.nextLine();
                                System.out.print("Ingrese su contraseña: ");
                                passwordAdmin = enter.nextLine();
                                User loginAdmin = new User(userAdmin, codeAdmin, passwordAdmin);
                                comparateAdmin = loginAdmin.LoginAdministrator();
                                if (comparateAdmin == false) {
                                    System.out.println("Codigo o Contraseña INCORRECOTOS");
                                }
                            } while (comparateAdmin == false);
                            int opcAdmin;
                            do {
                                menu.AdminTaskMenu();
                                System.out.print("Seleccione una opción: ");
                                optionTotal = enter.nextLine();
                                opcAdmin = validate(optionTotal);
                            } while (opcAdmin < 1 || opcAdmin > 3);
                            switch (opcAdmin) {
                                case 1:
                                    //menu.
                                    break;

                            }
                            break;

                    }
                    break;

            }
        } while (option1 < 1 || option1 > 3);

    }

    /*public static void main(String[] args) throws InterruptedException {
        Gson gson = new Gson();
        Scanner enter = new Scanner(System.in);
        int option;
        Menu menu = new Menu();
        do {
            menu.showMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            option = enter.nextInt();
            switch (option) {
                case 1:
                    menu.showLoginAndRegistryMenu();
                    System.out.print("Seleccione una opción: ");
                    int optionUser = enter.nextInt();
                    String user = "";
                    String accesCode = "";
                    String password = "";
                    switch (optionUser) {
                        case 1:
                            boolean comparateAdmin;
                            do {
                                System.out.print("Ingrese su código de acceso: ");
                                enter.nextLine();
                                accesCode = enter.nextLine();
                                System.out.print("Ingrese su contraseña: ");
                                password = enter.nextLine();
                                LogIn loginAdmin = new LogIn(user, accesCode, password);
                                comparateAdmin = loginAdmin.LoginAdministrator();
                            } while (comparateAdmin == false);
                            menu.showAdminTaskMenu();
                            System.out.print("Seleccione una opción: ");
                            int optionAdmin = enter.nextInt();
                            Product product = new Product("", "", 0.0, 0);
                            Inventory inventory = new Inventory();
                            switch (option) {
                                case 1:
                                    menu.showMenuInventory();
                                    System.out.print("Seleccione una opción: ");
                                    option = enter.nextInt();
                                    switch (optionAdmin) {
                                        case 1:
                                            enter.nextLine();
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
                                        case 2:
                                            System.out.print("Ingrese algún dato del producto que desea buscar: ");
                                            enter.nextLine();
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

                                        case 3:
                                            enter.nextLine();
                                            System.out.print("Ingrese el atributo del producto a modificar: ");
                                            String dataToModify = enter.nextLine();
                                            System.out.print("Ingrese el NUEVO atributo: ");
                                            String dataToUpdate = enter.nextLine();
                                            boolean update = inventory.modifyProduct(dataToModify, dataToUpdate);
                                            if (update == true) {
                                                System.out.println("Dato modificado con exito");
                                            } else {
                                                System.out.println("El dato " + dataToModify + " no fue encontrado");
                                            }
                                            break;
                                        case 4:
                                            enter.nextLine();
                                            System.out.print("Ingress el código del producto a eliminar: ");
                                            String dataTodeleted = enter.nextLine();
                                            boolean deleted = inventory.deleteProduct(dataTodeleted);
                                            if (deleted == true) {
                                                System.out.println("Producto eliminado ......");
                                            } else {
                                                System.out.println("El código del producto es incorrecto");
                                            }
                                            break;
                                        case 5:
                                            ArrayList<Product> listProducts = new ArrayList();
                                            listProducts = inventory.showInventory();
                                            for (int i = 0; i < listProducts.size(); i++) {
                                                System.out.println(listProducts.get(i));
                                            }
                                            break;
                                        case 6:
                                            break;

                                    }

                                    break;

                                case 2:
                                    menu.MenuAppointmentAdmin();
                                    System.out.print("Seleccione una opción: ");
                                    int optionAppointment = enter.nextInt();
                                    Appointment appoiment = new Appointment();
                                    switch (optionAppointment) {
                                        case 1:
                                            appoiment.generateAppointments();
                                            appoiment.registerAppoiment();
                                            System.out.println("Registro de citas completado con éxito");
                                            break;

                                        case 2:
                                            appoiment.showAppoiment("AppoimentGenerated.json");
                                            break;

                                        case 3:

                                            break;

                                    }
                                    break;
                            }
                            break;

                        case 2:

                            String userCustomer = "";
                            LogIn loginCustomer = new LogIn("", "");
                            boolean compareCustom = false;
                            boolean verified;
                            do {
                                try {
                                    enter.nextLine();
                                    System.out.print("Ingrese su usuario: ");
                                    userCustomer = enter.nextLine();
                                    loginCustomer.setUser(userCustomer);
                                    System.out.print("Ingrese su contraseña: ");
                                    loginCustomer.setPassword(enter.nextLine());
                                    compareCustom = loginCustomer.LoginCustomer();
                                    System.out.println("Presione una tecla para continuar");
                                } catch (Exception e) {
                                    System.out.println("Usuario o contraseña incorrectos");
                                }
                            } while (compareCustom == false);
                            verified = loginCustomer.checkFirtsTime();
                            if (verified == false) {
                                prediction();
                            }
                            menu.MenuAppointmentCustomer();
                            System.out.print("Seleccione una opción: ");
                            int optionCustomer = enter.nextInt();
                            Appointment appointment = new Appointment();
                            switch (optionCustomer) {
                                case 1:
                                    appointment.showAppoiment("AppoimentGenerated.json");
                                    System.out.println("\n Seleccione una cita para agendarla: ");
                                    int numberAppointment = enter.nextInt();
                                    appointment.saveCustomerAppointment(numberAppointment, userCustomer);
                                    System.out.println("AGENDANDO CITA...\n ");
                                    Thread.sleep(2000);
                                    System.out.println("CITA AGENDADA CON ÉXITO");
                                    break;
                                case 2:
                                    String appoimentCustomer = appointment.showAppointmentCustomer(userCustomer);
                                    System.out.println(appoimentCustomer);
                                    break;
                            }

                            break;

                    }
                case 2:
                    menu.showLoginAndRegistryMenu();
                    System.out.print("Seleccione una opción: ");
                    int optionRegistry = enter.nextInt();
                    String namePerson,
                     idPerson,
                     genderPerson;
                    String dataPassword;
                    String dataUser;
                    int agePerson;
                    if (optionRegistry == 1) {
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
                        System.out.println("Su condigo de acceso es: " + administrator.getAdministratorCode());
                        Thread.sleep(1000);
                    } else {
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
                    }

                    break;

                case 3:
                    break;
            }

        } while (option != 3);
    }*/
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
