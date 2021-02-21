/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.google.gson.Gson;
import ec.edu.espe.simulatorHealthCody.model.Customer;
import ec.edu.espe.simulatorHealthCody.model.Employee;
import ec.edu.espe.simulatorHealthCody.model.Registry;
import ec.edu.espe.validate.utils.Validate;
import java.util.Scanner;

/**
 *
 * @author George
 */
public class RegistrySubMenu {

    public void UserAndAministrator() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();
        Gson gson = new Gson();
        Menu menu = new Menu();
        String optionR1;

        int opcRegistry;

        do {
            do {
                System.out.println("\n\n\t\tREGISTRATE");
                System.out.println("\t\t¿Cómo deseas registrarte?");
                menu.LoginAndRegistryMenu();
                System.out.print("Seleccione una opción: ");
                optionR1 = scanner.nextLine();
                opcRegistry = validate.Number(optionR1);
            } while (opcRegistry < 1 || opcRegistry > 3);

            String name, id, gender, userName, accesKey;
            int age;
            Registry registry;
            switch (opcRegistry) {
                case 1:// Registry admin
                    Employee employee;
                    String numberPhone;
                    System.out.println("Complete los siguientes datos");
                    System.out.print("Ingrese su nombre completo : ");
                    name = validate.Words(scanner.nextLine());
                    System.out.print("Ingrese su número de identificación: ");
                    id = validate.id(scanner.nextLine());
                    System.out.print("Ingrese su edad: ");
                    age = validate.Number(scanner.nextLine());
                    System.out.print("Ingrese su género: ");
                    gender = validate.Words(scanner.nextLine());
                    System.out.print("Ingrese su número de telefono: ");
                    numberPhone = scanner.nextLine();
                    System.out.print("Cree una contraseña: ");
                    accesKey = scanner.nextLine();
                    userName = "AdminControl";

                    employee = new Employee(name, id, age, gender, numberPhone, userName, accesKey);
                    registry = new Registry("Employees");
                    registry.register(employee);
                    break;

                case 2:
                    Customer customer;
                    System.out.println("Complete los siguientes datos");
                    System.out.print("Ingrese su nombre completo : ");
                    name = validate.Words(scanner.nextLine());
                    System.out.print("Ingrese su número de identificación: ");
                    id = validate.id(scanner.nextLine());
                    System.out.print("Ingrese su edad: ");
                    age = validate.Number(scanner.nextLine());
                    System.out.print("Ingrese su género: ");
                    gender = validate.Words(scanner.nextLine());
                    System.out.println("Guardando...........");
                    Thread.sleep(2000);
                    System.out.print("Cree una nombre de usuario: ");
                    scanner.nextLine();
                    userName = scanner.nextLine();
                    System.out.print("Cree una contraseña: ");
                    accesKey = scanner.nextLine();
                    //customer = new Customer("Pedro Lopez", "123", 20, "M", "p1234", "121212");
                    customer = new Customer(name, id, age, gender, userName, accesKey);
                    registry = new Registry("Customers");
                    registry.register(customer);

                    break;
            }
        } while (opcRegistry != 3);

    }

}
