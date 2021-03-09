/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import com.restaurante.Main;
import com.restaurante.control.AdminEmpleado;
import com.restaurante.modelo.Empleado;
import javax.swing.JOptionPane;

/**
 *
 * @author abarrios
 */
public class VistaEmpleado {

    private final AdminEmpleado adminEmpleado;

    public VistaEmpleado() {
        this.adminEmpleado = new AdminEmpleado();
    }

    public void mostrarMenuGestionarEmpleado() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "*********RESTAURANTE DE COMIDAS RAPIDAS**********\n\n\n\n\n\n1. Registrar\n\n2. Consultar\n\n3. Listar\n\n4. Modificar\n\n5. Eliminar\n\n0. Atrás\n\nSeleccione la opción deseada: "));
                switch (opcion) {
                    case 0:
                        this.atras();
                        break;
                    case 1:
                        this.registrar();
                        break;
                    case 2:
                        this.consultar();
                        break;
                    case 3:
                        this.listar();
                        break;
                    case 4:
                        this.modificar();
                        break;
                    case 5:
                        this.eliminar();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción Inválida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 0);

    }

    private void atras() {
        Main.mostrarMenuPrincipal();
    }

    private void registrar() {
        try {
            String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación: ");
            String numeroEmpleado = JOptionPane.showInputDialog(null, "Ingrese el número del empleado: ");
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
            String apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad:"));
            double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el salario:"));
            Empleado empleado = new Empleado(identificacion, numeroEmpleado, nombre, apellido, edad, salario);
            this.adminEmpleado.agregar(empleado);
            JOptionPane.showMessageDialog(null, "Empleado registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultar() {
        Empleado empleado = this.adminEmpleado.consultar(JOptionPane.showInputDialog(null, "Ingrese la identificación: "));
        if (empleado != null) {
            JOptionPane.showMessageDialog(null, "Datos del Empleado:\n\n\n\nIdentificación: " + empleado.getIdentificacion() + "\n\nNúmero del Empleado: " + empleado.getNumeroEmpleado() + "\n\nNombre: " + empleado.getNombre() + "\n\nApellido: " + empleado.getApellido() + "\n\nEdad: " + empleado.getEdad() + "\n\nSalario: " + empleado.getSalario(), "Consulta del Empleado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listar() {
        String salida = "";
        for (Empleado empleado : this.adminEmpleado.listar()) {
            salida += "\n\nIdentificación: " + empleado.getIdentificacion() + "\n\nNúmero del Empleado: " + empleado.getNumeroEmpleado() + "\n\nNombre: " + empleado.getNombre() + "\n\nApellido: " + empleado.getApellido() + "\n\nEdad: " + empleado.getEdad() + "\n\nSalario: " + empleado.getSalario();
        }
        JOptionPane.showMessageDialog(null, "LISTADO DE EMPLEADOS" + "\n\n" + salida + "\n\n", "Listado de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificar() {
        try {
            Empleado empleado = this.adminEmpleado.consultar(JOptionPane.showInputDialog(null, "Ingrese la identificación: "));
            if (empleado != null) {
                empleado.setIdentificacion(JOptionPane.showInputDialog(null, "Ingrese la nueva cédula: "));
                empleado.setNumeroEmpleado(JOptionPane.showInputDialog(null, "Ingrese el nuevo número del empleado: "));
                empleado.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre: "));
                empleado.setApellido(JOptionPane.showInputDialog(null, "Ingrese el nuevo apellido:"));
                empleado.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la nueva edad:")));
                empleado.setSalario(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el nuevo salario:")));
                this.adminEmpleado.modificar(empleado);
                JOptionPane.showMessageDialog(null, "Empleado modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        String identificacion = JOptionPane.showInputDialog(null, "Ingrese la identificación: ");
        Empleado empleado = this.adminEmpleado.consultar(identificacion);
        if (empleado != null) {
            this.adminEmpleado.eliminar(identificacion);
            JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
