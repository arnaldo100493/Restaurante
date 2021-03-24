/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.control;

import com.restaurante.modelo.Proveedor;

/**
 *
 * @author abarrios
 */
public class AdminProveedor {

    private Proveedor[] listadoProveedores = new Proveedor[1000];
    private int indice = 0;

    public AdminProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setIdentificacion("1047459854");
        proveedor.setNombre("Arnaldo Andres");
        proveedor.setApellido("Barrios Mena");
        proveedor.setDireccion("Urb. Buena Vista MzA L20");
        proveedor.setTelefono("6627568");
        proveedor.setCorreoElectronico("cyberarnaldo04@hotmail.com");
        proveedor.setFechaRegistro("07/03/2014");
        proveedor.setSexo("Masculino");
        this.registrar(proveedor);
    }

    public boolean estaVacia() {
        return this.indice == -1;
    }

    public void registrar(Proveedor proveedor) {
        this.listadoProveedores[this.indice] = proveedor;
        this.indice++;
    }

    public boolean existe(String identificacion) {
        boolean existe = false;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProveedores[i].getIdentificacion().equals(identificacion)) {
                existe = true;
            }
        }
        return existe;
    }

    public Proveedor consultar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProveedores[i].getIdentificacion().equals(identificacion)) {
                return this.listadoProveedores[i];
            }
        }
        return null;
    }

    public Proveedor[] listar() {
        Proveedor[] proveedoresConsultados = new Proveedor[this.indice];
        for (int i = 0; i < this.indice; i++) {
            proveedoresConsultados[i] = this.listadoProveedores[i];
        }
        return proveedoresConsultados;
    }

    public void modificar(Proveedor proveedor) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProveedores[i].getIdentificacion().equals(proveedor.getIdentificacion())) {
                this.listadoProveedores[i] = proveedor;
            }
        }
    }

    private void reemplazar(int p) {
        for (int i = p; i < this.indice - 1; i++) {
            this.listadoProveedores[i] = this.listadoProveedores[i + 1];
        }
        this.listadoProveedores[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoProveedores[i].getIdentificacion().equals(identificacion)) {
                this.reemplazar(i);
            }
        }
    }
}
