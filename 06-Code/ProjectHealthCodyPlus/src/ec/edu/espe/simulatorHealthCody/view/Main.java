/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.google.gson.Gson;
import ec.edu.espe.Filemanager.utils.FileManager;
import ec.edu.espe.simulatorHealthCody.controller.Menu;
import ec.edu.espe.simulatorHealthCody.model.Administrator;
import ec.edu.espe.simulatorHealthCody.model.LogIn;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Inventory;
import ec.edu.espe.simulatorHealthCody.model.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
/// codido acceso : Admin1725M
/// contraseña: ka123
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Gson gson = new Gson();
        Scanner enter = new Scanner(System.in);
        int option;
        Menu menu = new Menu();
        do {
            menu.showMenuPrincipal();
            System.out.print("Seleccione una opcion: ");
            option = enter.nextInt();
            switch (option) {
                case 1:
                    menu.showLoginAndRegistryMenu();
                    System.out.print("Seleccione una opcion: ");
                    option = enter.nextInt();
                    String user = "",
                     accesCode = "",
                     password = "";
                    if (option == 1) {
                        boolean comparateAdmin;
                        do {
                            System.out.print("Ingrese su codigo de acceso: ");
                            enter.nextLine();
                            accesCode = enter.nextLine();
                            System.out.print("Ingrese su contraseña: ");
                            password = enter.nextLine();
                            LogIn loginAdmin = new LogIn(user, accesCode, password);
                            comparateAdmin = loginAdmin.LoginAdministrator();
                        } while (comparateAdmin == false);
                        menu.showAdminTaskMenu();
                        System.out.print("Seleccione una opcion: ");
                        option = enter.nextInt();
                        Product product = new Product("", "", 0.0, 0);
                        Inventory inventory = new Inventory();
                        switch (option) {
                            case 1:
                                menu.showMenuInventory();
                                System.out.print("Seleccione una opcion: ");
                                option = enter.nextInt();
                                switch (option) {
                                    case 1:
                                        enter.nextLine();
                                        System.out.print("Ingrese el nombre del producto: ");
                                        product.setNameProduct(enter.nextLine());
                                        System.out.print("Ingrese el codigo del producto: ");
                                        product.setCodeProduct(enter.nextLine());
                                        System.out.print("Ingrese el precio del prodcuto: ");
                                        product.setPriceProduct(enter.nextDouble());
                                        System.out.print("Ingrese la cantidad del producto: ");
                                        product.setQuantity(enter.nextInt());
                                        inventory.saveProduct(product);
                                        break;
                                    case 2:
                                        System.out.print("Ingrese algun dato del producto que desea buscar: ");
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
                                        System.out.print("Ingress el codigo del producto a eliminar: ");
                                        String dataTodeleted = enter.nextLine();
                                        boolean deleted = inventory.deleteProduct(dataTodeleted);
                                        if (deleted == true) {
                                            System.out.println("Producto eliminado ......");
                                        } else {
                                            System.out.println("El codigo del producto es incorrecto");
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
                                System.out.print("Seleccione una opcion: ");
                                option = enter.nextInt();
                                switch (option) {
                                    case 1:
                                        System.out.println("Ingrese el Dia de la cita");
                                        break;

                                }
                                break;
                        }
                    } else {
                        System.out.print("Ingrese su usuario: ");
                        enter.nextLine();
                        user = enter.nextLine();
                        System.out.print("Ingrese su contraseña: ");
                        password = enter.nextLine();
                        LogIn loginCustomer = new LogIn(user, password);
                        boolean compareCustom = loginCustomer.LoginCustomer();
                        System.out.println(compareCustom);
                        menu.MenuAppointmentCustomer();
                        System.out.print("Seleccione una opcion: ");
                        option = enter.nextInt();
                        switch (option) {
                            case 1:
                                System.out.println("Ingrese Un dia preferible para la cita: ");
                                int day = enter.nextInt();
                                Date[] date = new Date[4];
                                for (int i = 0; i < date.length; i++) {
                                    date[i] = new Date(121, 0, 3, (9+i), 0, 0);
                                }
                                for (int i = 0; i < date.length; i++) {
                                    System.out.println(date[i]);
                                }
                                break;

                        }
                    }
                    break;
                case 2:
                    menu.showLoginAndRegistryMenu();
                    System.out.print("Seleccione una opcion: ");
                    option = enter.nextInt();
                    String namePerson,
                     idPerson,
                     genderPerson;
                    String dataPassword;
                    String dataUser;
                    int agePerson;
                    if (option == 1) {
                        System.out.println("Complete los siguientes datos");
                        enter.nextLine();
                        System.out.print("Ingrese su nombre: ");
                        namePerson = enter.nextLine();
                        System.out.print("Ingrese su numero de identificacion: ");
                        idPerson = enter.nextLine();
                        System.out.print("Ingrese su genero: ");
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
                        System.out.println("Generando codigo de Acceso");
                        Thread.sleep(1000);
                        System.out.println("Su condigo de acceso es: " + administrator.getAdministratorCode());
                        Thread.sleep(1000);
                    } else {
                        System.out.println("Complete los siguientes datos");
                        enter.nextLine();
                        System.out.print("Ingrese su nombre: ");
                        namePerson = enter.nextLine();
                        System.out.print("Ingrese su numero de identificacion: ");
                        idPerson = enter.nextLine();
                        System.out.print("Ingrese su genero: ");
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
    }

}
