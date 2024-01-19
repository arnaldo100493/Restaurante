/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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

    private Cliente[] listadoClientes = new Cliente[1000];
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
    
    public boolean registrar(Cliente cliente) {
        boolean existe = this.existe(cliente.getIdentificacion());
        if (!existe) {
            this.listadoClientes[this.indice] = cliente;
            this.indice++;
        }
        return existe;
    }

    public boolean existe(String identificacion) {
        boolean existe = false;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoClientes[i].getIdentificacion().equals(identificacion)) {
                existe = true;
            }
        }
        return existe;
    }

    public Cliente consultar(String identificacion) {
        Cliente cliente = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoClientes[i].getIdentificacion().equals(identificacion)) {
                cliente = this.listadoClientes[i];
            }
        }
        return cliente;
    }

    public Cliente[] listar() {
        Cliente[] clientesConsultados = new Cliente[this.indice];
        for (int i = 0; i < this.indice; i++) {
            clientesConsultados[i] = this.listadoClientes[i];
        }
        return clientesConsultados;
    }

    public void modificar(Cliente objeto) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoClientes[i].getIdentificacion().equals(objeto.getIdentificacion())) {
                this.listadoClientes[i] = objeto;
            }
        }
    }

    private void reemplazar(int c) {
        for (int i = c; i < this.indice - 1; i++) {
            listadoClientes[i] = listadoClientes[i + 1];
        }
        this.listadoClientes[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (listadoClientes[i].getIdentificacion().equals(identificacion)) {
                this.reemplazar(i);
            }
        }
    }
}
