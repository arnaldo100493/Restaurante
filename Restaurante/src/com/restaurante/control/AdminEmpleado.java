/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.control;

import com.restaurante.modelo.Empleado;

/**
 *
 * @author abarrios
 */
public class AdminEmpleado {

    private Empleado[] listadoEmpleados;
    private int indice;

    public AdminEmpleado() {
        this.listadoEmpleados = new Empleado[1000];
        Empleado empleado = new Empleado();
        empleado.setIdentificacion("1047459854");
        empleado.setNombre("Arnaldo Andres");
        empleado.setApellido("Barrios Mena");
        empleado.setDireccion("Urb. Buena Vista MzA L20");
        empleado.setTelefono("6627568");
        empleado.setCorreoElectronico("cyberarnaldo04@hotmail.com");
        empleado.setFechaNacimiento("10/04/1993");
        empleado.setFechaRegistro("07/03/2014");
        empleado.setSexo("Masculino");
        empleado.setEdad(21);
        empleado.setSalario(4.6);
        this.registrar(empleado);
    }

    public boolean estaVacia() {
        return this.indice == -1;
    }

    public void registrar(Empleado empleado) {
        this.listadoEmpleados[this.indice] = empleado;
        this.indice++;
    }

    public boolean existe(String identificacion) {
        boolean existe = false;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoEmpleados[i].getIdentificacion().equals(identificacion)) {
                existe = true;
            }
        }
        return existe;
    }

    public Empleado consultar(String identificacion) {
        Empleado empleado = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoEmpleados[i].getIdentificacion().equals(identificacion)) {
                empleado = this.listadoEmpleados[i];
            }
        }
        return empleado;
    }

    public Empleado[] listar() {
        Empleado[] listadoEmpleadosConsultados = new Empleado[this.indice];
        for (int i = 0; i < this.indice; i++) {
            listadoEmpleadosConsultados[i] = this.listadoEmpleados[i];
        }
        return listadoEmpleadosConsultados;
    }

    public void modificar(Empleado empleado) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoEmpleados[i].getIdentificacion().equals(empleado.getIdentificacion())) {
                this.listadoEmpleados[i] = empleado;
            }
        }
    }

    private void reemplazar(int e) {
        for (int i = e; i < this.indice - 1; i++) {
            this.listadoEmpleados[i] = this.listadoEmpleados[i + 1];
        }
        this.listadoEmpleados[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String identificacion) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoEmpleados[i].getIdentificacion().equals(identificacion)) {
                this.reemplazar(i);
            }
        }
    }
}
