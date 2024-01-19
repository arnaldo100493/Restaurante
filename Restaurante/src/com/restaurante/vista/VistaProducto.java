/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import com.restaurante.modelo.Producto;
import com.restaurante.control.AdminProducto;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author abarrios
 */
public class VistaProducto {

    private final AdminProducto adminProducto;
    private final Calendar fecha;

    public VistaProducto() {
        this.adminProducto = new AdminProducto();
        this.fecha = new GregorianCalendar();
    }

    public void mostraMenuGestionarProductos() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nGestión de Productos\n\n1. Registrar\n\n2. Consultar\n\n3. Listar\n\n4. Modificar\n\n5. Eliminar\n\n6. Atrás\n\nDigíte Opción:", "Restaurante", JOptionPane.INFORMATION_MESSAGE));
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
                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El caractér ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);
    }

    private void atras() {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        vistaPrincipal.mostrarMenuVistaPrincipal();
    }

    private void registrar() {
        try {
            String codigo = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el código del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE);
            if (this.adminProducto.existe(codigo)) {
                JOptionPane.showMessageDialog(null, "\nCódigo duplicado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                String nombre = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nómbre del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE);
                String descripcion = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la descripción del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE);
                String tipo = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el tipo de producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE);
                String fechaRegistro = this.fecha.getTime().toLocaleString();
                double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el precio del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE));
                double cantidadExistente = Double.parseDouble(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la cantidad existente del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE));
                double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el peso del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE));
                Producto producto = new Producto(codigo, nombre, descripcion, tipo, fechaRegistro, precio, cantidadExistente, peso);
                this.adminProducto.registrar(producto);
                JOptionPane.showMessageDialog(null, "Producto registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ha ingresado un caractér NO numérico " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void consultar() {
        Producto consultar = this.adminProducto.consultar(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el código del producto: ", "Consulta de Productos", JOptionPane.INFORMATION_MESSAGE));
        if (consultar != null) {
            JOptionPane.showMessageDialog(null, "\nConsulta del producto\n\nCódigo: " + consultar.getCodigo() + "\n\nNombre: " + consultar.getNombre() + "\n\nDescripción: " + consultar.getDescripcion() + "\n\nTipo: " + consultar.getTipo() + "\n\nFecha de Registro: " + consultar.getFechaRegistro() + "\n\nPrecio: " + consultar.getPrecio() + "\n\nCantidad Existente: " + consultar.getCantidadExistente() + "\n\nPeso: " + consultar.getPeso(), "Consulta del Producto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Este producto no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listar() {
        String salida = "";
        try {
            for (Producto listar : this.adminProducto.listar()) {
                salida = salida + "\n\n\nCódigo: " + listar.getCodigo() + "\n\nNombre: " + listar.getNombre() + "\n\nDescripción: " + listar.getDescripcion() + "\n\nTipo: " + listar.getTipo() + "\n\nFecha de Registro: " + listar.getFechaRegistro() + "\n\nPrecio: " + listar.getPrecio() + "\n\nCantidad Existente: " + listar.getCantidadExistente() + "\n\nPeso: " + listar.getPeso() + "\n\n";
                JOptionPane.showMessageDialog(null, "LISTADO DE PRODUCTOS" + "\n\n" + salida, "Listado de Productos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificar() {
        String codigo = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el código del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE);
        Producto producto = this.adminProducto.consultar(codigo);
        if (producto != null) {
            producto.setCodigo(codigo);
            producto.setNombre(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo nombre del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE));
            producto.setDescripcion(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva descripción del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE));
            producto.setTipo(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo tipo del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE));
            producto.setFechaRegistro(this.fecha.getTime().toLocaleString());
            producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo precio del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE)));
            producto.setCantidadExistente(Double.parseDouble(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la nueva cantidad existente del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE)));
            producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "\n\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nuevo peso del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE)));
            this.adminProducto.modificar(producto);
            JOptionPane.showMessageDialog(null, "Producto modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Este producto no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminar() {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese la identificación: ");
        Producto producto = this.adminProducto.consultar(codigo);
        if (producto != null) {
            int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar este prodcuto llamado: " + producto.getNombre() + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcion != -1) {
                if ((opcion + 1) == 1) {
                    this.adminProducto.eliminar(codigo);
                    JOptionPane.showMessageDialog(null, "Producto eliminado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este producto no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
