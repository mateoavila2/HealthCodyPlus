/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.controller;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Menu {
     
    
    public void showMenuPrincipal(){
        System.out.println("MENU");
        System.out.println("1. Iniciar secion");
        System.out.println("2. Registrarse");
        System.out.println("3. Salir");
    }
   
    public void showLoginAndRegistryMenu(){
        System.out.println("1. Administrador");
        System.out.println("2. Usuario");
    }
    
    public void showAdminTaskMenu(){
        System.out.println("1. Inventario");
        System.out.println("2. Citas");
        System.out.println("3. otros....");
    }
    public void showMenuInventory(){
        System.out.println("1. Agregar Producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Modificar Producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Ver Inventario");
    }
    
    
}
