/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import com.restaurante.control.AdminEmpleado;
import com.restaurante.modelo.Empleado;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author abarrios
 */
public class VistaEmpleado {

    private final AdminEmpleado adminEmpleado;
    private final Calendar fecha;

    public VistaEmpleado() {
        this.adminEmpleado = new AdminEmpleado();
        this.fecha = new GregorianCalendar();
    }

    public void mostrarMenuGestionarEmpleados() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "*********RESTAURANTE DE COMIDAS RAPIDAS**********\n\n\n\n\n\n1. Registrar\n\n2. Consultar\n\n3. Listar\n\n4. Modificar\n\n5. Eliminar\n\n6. Atrás\n\nSeleccione la opción deseada: "));
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
                    case 6:
                        this.atras();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción Inválida", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);

    }

    private void atras() {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.mostrarMenuVistaPrincipal();
    }

    private void registrar() {
        try {
            String identificacion = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
            if (this.adminEmpleado.existe(identificacion)) {
                JOptionPane.showMessageDialog(null, "Identificación duplicada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                String numeroEmpleado = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el número del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String nombre = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nombre del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String apellido = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el apellido del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String direccion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la dirección del empleado:", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String telefono = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el teléfono del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String correoElectronico = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el correo electrónico del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String fechaNacimiento = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la fecha de nacimiento del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                String fechaRegistro = this.fecha.getTime().toLocaleString();
                String sexo = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el sexo del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE);
                int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la edad del empleado: ", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE));
                double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el salario del empleado:", "Registro de Empleados", JOptionPane.INFORMATION_MESSAGE));
                Empleado empleado = new Empleado(identificacion, numeroEmpleado, nombre, apellido, direccion, telefono, correoElectronico, fechaNacimiento, fechaRegistro, sexo, edad, salario);
                this.adminEmpleado.registrar(empleado);
                JOptionPane.showMessageDialog(null, "Empleado registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultar() {
        String identificacion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del empleado: ", "Consulta de Empleados", JOptionPane.INFORMATION_MESSAGE);
        Empleado empleado = this.adminEmpleado.consultar(identificacion);
        if (empleado != null) {
            JOptionPane.showMessageDialog(null, "Datos del Empleado:\n\n\n\nIdentificación: " + empleado.getIdentificacion() + "\n\nNúmero del Empleado: " + empleado.getNumeroEmpleado() + "\n\nNombre: " + empleado.getNombre() + "\n\nApellido: " + empleado.getApellido() + "\n\nDirección: " + empleado.getDireccion() + "\n\nTeléfono: " + empleado.getTelefono() + "\n\nCorreo Electrónico: " + empleado.getCorreoElectronico() + "\n\nFecha de Nacimiento: " + empleado.getFechaNacimiento() + "\n\nFecha de Registro: " + empleado.getFechaRegistro() + "\n\nSexo: " + empleado.getSexo() + "\n\nEdad: " + empleado.getEdad() + "\n\nSalario: " + empleado.getSalario(), "Consulta del Empleado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Este empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listar() {
        String salida = "";
        for (Empleado empleado : this.adminEmpleado.listar()) {
            salida += "\n\nIdentificación: " + empleado.getIdentificacion() + "\n\nNúmero del Empleado: " + empleado.getNumeroEmpleado() + "\n\nNombre: " + empleado.getNombre() + "\n\nApellido: " + empleado.getApellido() + "\n\nDirección: " + empleado.getDireccion() + "\n\nTeléfono: " + empleado.getTelefono() + "\n\nCorreo Electrónico: " + empleado.getCorreoElectronico() + "\n\nFecha de Nacimiento: " + empleado.getFechaNacimiento() + "\n\nFecha de Registro: " + empleado.getFechaRegistro() + "\n\nSexo: " + empleado.getSexo() + "\n\nEdad: " + empleado.getEdad() + "\n\nSalario: " + empleado.getSalario();
        }
        JOptionPane.showMessageDialog(null, "LISTADO DE EMPLEADOS" + "\n\n" + salida + "\n\n", "Listado de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificar() {
        try {
            String identificacion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del empleado: ", "Consulta de Empleados", JOptionPane.INFORMATION_MESSAGE);
            Empleado empleado = this.adminEmpleado.consultar(identificacion);
            if (empleado != null) {
                empleado.setIdentificacion(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva identificación del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setNumeroEmpleado(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo número del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setNombre(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo nombre del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setApellido(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo apellido del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setDireccion(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva dirección del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setTelefono(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo teléfono del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setCorreoElectronico(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo correo electrónico del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setFechaNacimiento(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva fecha de nacimiento del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setFechaRegistro(this.fecha.getTime().toLocaleString());
                empleado.setSexo(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo sexo del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE));
                empleado.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva edad del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE)));
                empleado.setSalario(Double.parseDouble(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo salario del empleado: ", "Modificación de Empleados", JOptionPane.INFORMATION_MESSAGE)));
                this.adminEmpleado.modificar(empleado);
                JOptionPane.showMessageDialog(null, "Empleado modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Este empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        String identificacion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del empleado: ", "Consulta de Empleados", JOptionPane.INFORMATION_MESSAGE);
        Empleado empleado = this.adminEmpleado.consultar(identificacion);
        if (empleado != null) {
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar este empleado llamado: " + empleado.getNombre() + " " + empleado.getApellido() + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcion != -1) {
                if ((opcion + 1) == 1) {
                    this.adminEmpleado.eliminar(identificacion);
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
