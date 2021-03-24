/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import Modelo.Producto;
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
                    case 1:
                        registrar();
                        break;

                    case 2:
                        consultar();
                        break;

                    case 3:
                        listar();
                        break;

                    case 4:
                        modificar();
                        break;

                    case 5:
                        eliminar();
                        break;

                    case 6:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "\nOpción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "\nEl caractér ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);
    }

    private void registrar() {
        //int opcion = 0;
        String codigo;
        //do{
        try {
            Producto producto = new Producto();
            codigo = JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el código del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE);
            if (this.adminProducto.existe(codigo)) {
                JOptionPane.showMessageDialog(null, "\nCódigo duplicado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                producto.setCodigo(codigo);
                producto.setNombre(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el nómbre del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE));
                producto.setDescripcion(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la descripción del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE));
                producto.setTipo(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el tipo de producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE));
                producto.setFechaRegistro(this.fecha.getTime().toLocaleString());
                producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el precio del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE)));
                producto.setCantidadExistente(Double.parseDouble(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte la cantidad existente del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE)));
                producto.setPeso(Double.parseDouble(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el peso del producto: ", "Registro de Productos", JOptionPane.INFORMATION_MESSAGE)));
                this.adminProducto.registrar(producto);
                JOptionPane.showMessageDialog(null, "\nProducto registrado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "\nError al registrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //}while(opcion!= 8);  
    }

    private void consultar() {
        Producto consultar = adminProducto.consultar(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el código del producto: ", "Consulta de Productos", JOptionPane.INFORMATION_MESSAGE));
        if (consultar != null) {
            JOptionPane.showMessageDialog(null, "\nConsulta del producto\n\nCódigo: " + consultar.getCodigo() + "\n\nNombre: " + consultar.getNombre() + "\n\nDescripción: " + consultar.getDescripcion() + "\n\nTipo: " + consultar.getTipo() + "\n\nFecha de Registro: " + consultar.getFechaRegistro() + "\n\nPrecio: " + consultar.getPrecio() + "\n\nCantidad Existente: " + consultar.getCantidadExistente() + "\n\nPeso: " + consultar.getPeso(), "Consulta del Producto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "\nEste producto no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void listar() {
        try {
            for (Producto listar : adminProducto.listar()) {
                String salida = "";
                salida = salida + "\n\nListado de Productos\n\nCódigo: " + listar.getCodigo() + "\n\nNombre: " + listar.getNombre() + "\n\nDescripción: " + listar.getDescripcion() + "\n\nTipo: " + listar.getTipo() + "\n\nFecha de Registro: " + listar.getFechaRegistro() + "\n\nPrecio: " + listar.getPrecio() + "\n\nCantidad Existente: " + listar.getCantidadExistente() + "\n\nPeso: " + listar.getPeso() + "\n\n";
                JOptionPane.showMessageDialog(null, salida, "Listado de Productos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "\nError al listar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificar() {
        Producto modificar = adminProducto.consultar(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nDigíte el código del producto: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE));
        int opcion = 0;
        if (modificar != null) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\n¿Qué desea modificar:\n\n1. Código\n\n2. Nombre\n\n3. Descripción\n\n4. Tipo\n\n5. Precio\n\n6. Cantidad Existente\n\n7. Peso\n\n8. Atrás\n\nDigite opción: ", "Modificación de Productos", JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "\nOpción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;

            }
        } else {
            JOptionPane.showMessageDialog(null, "\nEste producto no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminar() {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese la identificación: ");
        Producto producto = this.adminProducto.consultar(codigo);
        if (producto != null) {
            int opcion = JOptionPane.showOptionDialog(null, "\n¿Está seguro que desea eliminar este prodcuto llamado: " + producto.getNombre() + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
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
