/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante;

import com.restaurante.vista.VistaEmpleado;
import javax.swing.JOptionPane;

/**
 *
 * @author abarrios
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mostrarMenuPrincipal();
    }

    public static void mostrarMenuPrincipal() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "*********RESTAURANTE DE COMIDAS RAPIDAS**********\n\n\n\n\n\n1. Gestión Empleados\n\n0. Salir\n\n\n\nSeleccione la opción deseada: "));
                switch (opcion) {
                    case 0:
                        salir();
                        break;

                    case 1:
                        empleado();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción Inválida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        } while (opcion != 0);
    }

    public static void empleado() {
        VistaEmpleado vistaEmpleado = new VistaEmpleado();
        vistaEmpleado.mostrarMenuGestionarEmpleado();
    }

    public static void salir() {
        System.exit(0);
    }

}
