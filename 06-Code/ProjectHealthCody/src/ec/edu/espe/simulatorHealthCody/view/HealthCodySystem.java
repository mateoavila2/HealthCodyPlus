/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

import com.google.gson.Gson;
import ec.edu.espe.validate.utils.Validate;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Rafa
 */
public class HealthCodySystem {

    public static void main(String[] args) throws InterruptedException, ParseException {

        Scanner scanner = new Scanner(System.in);
        Validate validate = new Validate();
        Gson gson = new Gson();
        Menu menu = new Menu();
        System.out.println("\t\t BIENVENIDO AL SISTEMA DE HEALTH CODY PLUS +");
        String optionL1;
        String optionR1;
        int option1;
        do {

            do {
                menu.menuPrincipal();
                System.out.print("Seleccione una opción: ");
                optionL1 = scanner.nextLine();
                option1 = validate.Number(optionL1);
            } while (option1 < 1 || option1 > 3);
            switch (option1) {
                case 1:
                    LoginSubMenu login = new LoginSubMenu();
                    login.UserAndAministrator();

                    break;

                case 2: // Registro
                    RegistrySubMenu registry = new RegistrySubMenu();
                    registry.UserAndAministrator();
                    break;

            }
        } while (option1 != 3);

    }
}
