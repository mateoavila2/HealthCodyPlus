/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.view;

/**
 *
 * @author Mateo Ávila
 */
public class Menu {

    public void menuPrincipal() {
        System.out.println("\n\n\t\tMENÚ");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
    }

    public void loginAndRegistryMenu() {
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
        System.out.println("3. Regresar al menú anterior");
    }

    public void adminTaskMenu() {
        System.out.println("1. Inventario");
        System.out.println("2. Citas");
        System.out.println("3. Regresar al menú anterior");
    }

    public void menuInventory() {
        System.out.println("1. Agregar Producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Modificar Producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Ver Inventario");
        System.out.println("6. Regresar al menú anterior");
    }

    public void menuAppointmentAdmin() {
        System.out.println("1. Programar citas de la semana");
        System.out.println("2. Ver citas programadas");
        System.out.println("3. Regresar al menú anterior");

    }

    public void menuAppointmentCustomer() {
        System.out.println("1. Agendar cita");
        System.out.println("2. Ver cita agendada");
        System.out.println("3. Eliminar cita agendada");
        System.out.println("4. Regresar al menú anterior");

    }
}
