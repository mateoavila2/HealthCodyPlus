/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import ec.edu.espe.validate.utils.Validate;
import java.util.Scanner;

/**
 *
 * @author Rafa
 */
public class PredictionOfCovid {

    public static void prediction() {
        int suma = 0;
        int answer;
        float temp;
        Scanner read = new Scanner(System.in);
        Validate validate = new Validate();

        System.out.println("\n\n¡Test de predicción de COVID-19!\n");

        System.out.println("\n¿Presenta tos nueva o que va empeorando? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = validate.Number(read.nextLine());
        if (answer == 1) {
            suma = suma + 2;
        }
        System.out.println("\n¿Presenta pérdida sostenida del olfato, el gusto o el apetito? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = validate.Number(read.nextLine());
        if (answer == 1) {
            suma = suma + 3;
        }
        System.out.println("\n¿Presenta dolor de garganta? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = validate.Number(read.nextLine());
        if (answer == 1) {
            suma = suma + 2;
        }

        System.out.println("\n¿Presenta dificultad para respirar leve o moderada? ");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = validate.Number(read.nextLine());
        if (answer == 1) {
            suma = suma + 3;
        }
        System.out.println("\nEn los últimos 14 días, ¿Viajó al exterior?");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = validate.Number(read.nextLine());
        if (answer == 1) {
            suma = suma + 3;
        }
        System.out.println("\nEn los últimos 14 días, ¿ha tenido contacto con otras personas que han contraído COVID-19?");
        System.out.println("1. Si\n2. No\nEscoja una opción: ");
        answer = validate.Number(read.nextLine());
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
