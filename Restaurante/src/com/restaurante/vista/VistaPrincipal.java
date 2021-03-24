/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.vista;

import javax.swing.JOptionPane;

/**
 *
 * @author abarrios
 */
public class VistaPrincipal {

    public VistaPrincipal() {
        this.vistaProducto = new VistaProducto();
        this.vistaCliente = new VistaCliente();
        this.vistaEmpleado = new VistaEmpleado();
        this.vistaProveedor = new VistaProveedor();
        this.vistaInsumo = new VistaInsumo();
        this.vistaDetalleVenta = new VistaDetalleVenta();
        this.vistaVenta = new VistaVenta();
    }

//////////////////////////// OBJETOS //////////////////////////////////
    private final VistaProducto vistaProducto;
    private final VistaCliente vistaCliente;
    private final VistaEmpleado vistaEmpleado;
    private final VistaProveedor vistaProveedor;
    private final VistaInsumo vistaInsumo;
    private final VistaDetalleVenta vistaDetalleVenta;
    private final VistaVenta vistaVenta;

    //////////////////////////// MENÚ PRINCIPAL /////////////////////////// 
    public void mostrarMenuVistaPrincipal() {
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "\n**********PROGRAMA PARA EL CONTROL DE VENTAS RESTAURANTE**********\n\nMenú Principal\n\n1. Gestión de Productos\n\n2. Gestión de Clientes\n\n3. Gestión de Empleados\n\n4. Gestión de Proveedores\n\n5. Gestión de Insumos\n\n6. Gestión de Ventas\n\n7. Gestión de Detalles Ventas\n\n8. Salir\n\nDigite opción:", "Restaurante", JOptionPane.INFORMATION_MESSAGE));
                switch (opcion) {
                    case 0:
                        this.salir();
                        break;
                    case 1:
                        this.vistaProducto.mostraMenuGestionarProductos();
                        break;
                    case 2:
                        this.vistaCliente.mostrarMenuGestionarClientes();
                        break;
                    case 3:
                        this.vistaEmpleado.mostrarMenuGestionarEmpleados();
                        break;
                    case 4:
                        this.vistaProveedor.mostrarMenuGestionarProveedores();
                        break;
                    case 5:
                        this.vistaInsumo.mostrarMenuGestionarInsumos();
                        break;
                    case 6:
                        this.vistaVenta.mostrarMenuGestionarVentas();
                        break;
                    case 7:
                        this.vistaDetalleVenta.mostrarMenuGestionarDetallesVentas();
                        break;
                    case 8:
                        this.salir();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "\nOpción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "\nEl caracter ingresado no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcion != 8);
    }

    private void salir() {
        try {
            int opcion = JOptionPane.showOptionDialog(null, "\n¿Está seguro que desea salir? ", "Confirmar Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcion != -1) {
                if ((opcion + 1) == 1) {
                    System.exit(0);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "\nError al salir", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
