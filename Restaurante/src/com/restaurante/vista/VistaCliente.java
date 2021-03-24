/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import com.restaurante.control.AdminCliente;
import com.restaurante.modelo.Cliente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author abarrios
 */
public class VistaCliente {

    private final AdminCliente adminCliente;
    private final Calendar fecha;

    public VistaCliente() {
        this.adminCliente = new AdminCliente();
        this.fecha = new GregorianCalendar();
    }

    public void mostrarMenuGestionarClientes() {
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
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.mostrarMenuVistaPrincipal();
    }

    private void registrar() {
        try {
            String identificacion = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
            if (this.adminCliente.existe(identificacion)) {
                JOptionPane.showMessageDialog(null, "\nIdentificación duplicada", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                String nombre = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nombre del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                String apellido = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el apellido del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                String direccion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la dirección del cliente:", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                String telefono = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el teléfono del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                String correoElectronico = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el correo electrónico del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                String fechaNacimiento = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la fecha de nacimiento del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                String fechaRegistro = this.fecha.getTime().toLocaleString();
                String sexo = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el sexo del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE);
                int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la edad del cliente: ", "Registro de Clientes", JOptionPane.INFORMATION_MESSAGE));
                Cliente cliente = new Cliente(identificacion, nombre, apellido, direccion, telefono, correoElectronico, fechaNacimiento, fechaRegistro, sexo, edad);
                this.adminCliente.registrar(cliente);
            }

            JOptionPane.showMessageDialog(null, "Cliente registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultar() {
        String identificacion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del empleado: ", "Consulta de Empleados", JOptionPane.INFORMATION_MESSAGE);
        Cliente empleado = this.adminCliente.consultar(identificacion);
        if (empleado != null) {
            JOptionPane.showMessageDialog(null, "Datos del Cliente:\n\n\n\nIdentificación: " + empleado.getIdentificacion() + "\n\nNombre: " + empleado.getNombre() + "\n\nApellido: " + empleado.getApellido() + "\n\nDirección: " + empleado.getDireccion() + "\n\nTeléfono: " + empleado.getTelefono() + "\n\nCorreo Electrónico: " + empleado.getCorreoElectronico() + "\n\nFecha de Nacimiento: " + empleado.getFechaNacimiento() + "\n\nFecha de Registro: " + empleado.getFechaRegistro() + "\n\nSexo: " + empleado.getSexo() + "\n\nEdad: " + empleado.getEdad(), "Consulta de Clientes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Este cliente no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listar() {
        String salida = "";
        for (Cliente cliente : this.adminCliente.listar()) {
            salida += "\n\n\nIdentificación: " + cliente.getIdentificacion() + "\n\nNombre: " + cliente.getNombre() + "\n\nApellido: " + cliente.getApellido() + "\n\nDirección: " + cliente.getDireccion() + "\n\nTeléfono: " + cliente.getTelefono() + "\n\nCorreo Electrónico: " + cliente.getCorreoElectronico() + "\n\nFecha de Nacimiento: " + cliente.getFechaNacimiento() + "\n\nFecha de Registro: " + cliente.getFechaRegistro() + "\n\nSexo: " + cliente.getSexo() + "\n\nEdad: " + cliente.getEdad();
        }
        JOptionPane.showMessageDialog(null, "LISTADO DE CLIENTES" + "\n\n" + salida + "\n\n", "Listado de Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    private void modificar() {
        try {
            String identificacion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del cliente: ", "Consulta de Clientes", JOptionPane.INFORMATION_MESSAGE);
            Cliente cliente = this.adminCliente.consultar(identificacion);
            if (cliente != null) {
                cliente.setIdentificacion(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva identificación del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setNombre(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo nombre del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setApellido(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo apellido del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setDireccion(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva dirección del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setTelefono(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo teléfono del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setCorreoElectronico(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo correo electrónico del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setFechaNacimiento(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva fecha de nacimiento del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setFechaRegistro(this.fecha.getTime().toLocaleString());
                cliente.setSexo(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo sexo del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE));
                cliente.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva edad del cliente: ", "Modificación de Clientes", JOptionPane.INFORMATION_MESSAGE)));
                this.adminCliente.modificar(cliente);
                JOptionPane.showMessageDialog(null, "Cliente modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Este cliente no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminar() {
        String identificacion = JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la identificación del cliente: ", "Consulta de Clientes", JOptionPane.INFORMATION_MESSAGE);
        Cliente cliente = this.adminCliente.consultar(identificacion);
        if (cliente != null) {
            int opcion = JOptionPane.showOptionDialog(null, "\n¿Está seguro que desea eliminar este cliente llamado: " + cliente.getNombre() + " " + cliente.getApellido() + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcion != -1) {
                if ((opcion + 1) == 1) {
                    this.adminCliente.eliminar(identificacion);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este cliente no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

}
