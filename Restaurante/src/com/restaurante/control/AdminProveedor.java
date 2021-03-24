package com.restaurante.control;

import com.restaurante.modelo.Proveedor;

public class AdminProveedor {

    private Proveedor[] listaProveedores = new Proveedor[1000];
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
        this.listaProveedores[this.indice] = proveedor;
        this.indice++;
    }

    public boolean existe(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listaProveedores[i].getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public Proveedor consultar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listaProveedores[i].getIdentificacion().equals(identificacion)) {
                return this.listaProveedores[i];
            }
        }
        return null;
    }

    public Proveedor[] listar() {
        Proveedor[] proveedoresConsultados = new Proveedor[this.indice];
        for (int i = 0; i < this.indice; i++) {
            proveedoresConsultados[i] = this.listaProveedores[i];
        }
        return proveedoresConsultados;
    }

    public void modificar(Proveedor proveedor) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listaProveedores[i].getIdentificacion().equals(proveedor.getIdentificacion())) {
                this.listaProveedores[i] = proveedor;
            }
        }
    }

    private void reemplazar(int p) {
        for (int i = p; i < this.indice - 1; i++) {
            this.listaProveedores[i] = this.listaProveedores[i + 1];
        }
        this.listaProveedores[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listaProveedores[i].getIdentificacion().equals(identificacion)) {
                this.reemplazar(i);
            }
        }
    }
}
