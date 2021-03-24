/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.control;

import com.restaurante.modelo.Producto;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author abarrios
 */
public class AdminProducto {

    private Producto[] listadoProductos = new Producto[1000];
    private int indice = 0;
    private Calendar fecha = new GregorianCalendar();

    public AdminProducto() {
        Producto producto = new Producto();
        producto.setCodigo("1234");
        producto.setNombre("Hamburgesa de Queso");
        producto.setDescripcion("Deliciosa");
        producto.setTipo("Doble");
        producto.setFechaRegistro(this.fecha.getTime().toLocaleString());
        producto.setPrecio(20000);
        producto.setCantidadExistente(10);
        producto.setPeso(2.5);
        this.registrar(producto);
    }

    public boolean estaVacia() {
        return this.indice == -1;
    }

    public void registrar(Producto producto) {
        this.listadoProductos[this.indice] = producto;
        this.indice++;
    }

    public boolean existe(String codigo) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProductos[i].getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Producto consultar(String codigo) {
        Producto producto = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProductos[i].getCodigo().equals(codigo)) {
                producto = this.listadoProductos[i];
            }
        }
        return producto;
    }

    public Producto[] listar() {
        Producto[] productosConsultados = new Producto[this.indice];
        for (int i = 0; i < this.indice; i++) {
            productosConsultados[i] = this.listadoProductos[i];
        }
        return productosConsultados;
    }

    public void modificar(Producto producto) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProductos[i].getCodigo().equals(producto.getCodigo())) {
                this.listadoProductos[i] = producto;
            }
        }
    }

    private void reemplazar(int p) {
        for (int i = p; i < this.indice - 1; i++) {
            this.listadoProductos[i] = this.listadoProductos[i + 1];
        }
        this.listadoProductos[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String codigo) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProductos[i].getCodigo().equals(codigo)) {
                this.reemplazar(i);
            }
        }
    }

}
