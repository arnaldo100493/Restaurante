/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.control;

import com.restaurante.modelo.Cliente;

/**
 *
 * @author abarrios
 */
public class AdminCliente {

    private Cliente[] listaClientes = new Cliente[1000];
    private int indice = 0;

    public AdminCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdentificacion("1047459854");
        cliente.setNombre("Arnaldo Andres");
        cliente.setApellido("Barrios Mena");
        cliente.setDireccion("Urb. Buena Vista MzA L20");
        cliente.setTelefono("6627568");
        cliente.setCorreoElectronico("cyberarnaldo04@hotmail.com");
        cliente.setFechaNacimiento("10/04/1993");
        cliente.setFechaRegistro("07/03/2014");
        cliente.setSexo("Masculino");
        cliente.setEdad(21);
        this.registrar(cliente);
    }

    public boolean estaVacia() {
        return this.indice == -1;
    }

    public void registrar(Cliente cliente) {
        this.listaClientes[this.indice] = cliente;
        this.indice++;
    }

    public boolean existe(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listaClientes[i].getIdentificacion().equals(identificacion)) {
                return true;
            }
        }
        return false;
    }

    public Cliente consultar(String identificacion) {
        Cliente cliente = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.listaClientes[i].getIdentificacion().equals(identificacion)) {
                cliente = this.listaClientes[i];
            }
        }
        return cliente;
    }

    public Cliente[] listar() {
        Cliente[] clientesConsultados = new Cliente[indice];
        for (int i = 0; i < this.indice; i++) {
            clientesConsultados[i] = this.listaClientes[i];
        }
        return clientesConsultados;
    }

    public void modificar(Cliente objeto) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listaClientes[i].getIdentificacion().equals(objeto.getIdentificacion())) {
                this.listaClientes[i] = objeto;
            }
        }
    }

    private void reemplazar(int c) {
        for (int i = c; i < this.indice - 1; i++) {
            listaClientes[i] = listaClientes[i + 1];
        }
        this.listaClientes[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (listaClientes[i].getIdentificacion().equals(identificacion)) {
                reemplazar(i);
            }
        }
    }
}
