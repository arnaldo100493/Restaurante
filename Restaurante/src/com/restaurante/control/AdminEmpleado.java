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
        Empleado e1 = new Empleado();
        e1.setIdentificacion("1047459854");
        e1.setNumeroEmpleado("159318");
        e1.setNombre("Arnaldo Andrés");
        e1.setApellido("Barrios Mena");
        e1.setEdad(27);
        e1.setSalario(4.6);
        this.agregar(e1);
    }

    public boolean estaVacia() {
        return this.indice == -1;
    }

    public void agregar(Empleado empleado) {
        this.listadoEmpleados[this.indice] = empleado;
        this.indice++;
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

    private void reemplazar(int in) {
        for (int i = in; i < this.indice - 1; i++) {
            this.listadoEmpleados[i] = this.listadoEmpleados[i + 1];
        }
        this.listadoEmpleados[this.indice - 1] = null;
        this.indice--;
    }
    
    public void eliminar(String identificacion){
        for (int i = 0; i < this.indice; i++) {
            if(this.listadoEmpleados[i].getIdentificacion().equals(identificacion)){
              this.reemplazar(i);
            }
        }
    }
}
