package com.restaurante.control;

import Modelo.Insumo;

public class AdminInsumo {

    private Insumo[] listadoInsumos = new Insumo[1000];
    private int indice = 0;

    public AdminInsumo() {
        Insumo insumo = new Insumo();
        insumo.setCodigo("1234");
        insumo.setNombre("Hamburgesa de Queso");
        insumo.setDescripcion("Deliciosa");
        insumo.setTipo("Doble");
        insumo.setFechaRegistro("07/03/2014");
        insumo.setPrecio(20000);
        insumo.setCantidadExistente(10);
        insumo.setPeso(2.5);
        insumo.setCantidadMinima(6);
        insumo.setCantidadMaxima(12);
        this.registrar(insumo);
    }

    public boolean estaVacia() {
        return this.indice == -1;
    }

    public void registrar(Insumo insumo) {
        this.listadoInsumos[this.indice] = insumo;
        this.indice++;
    }

    public boolean existe(String codigo) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoInsumos[i].getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public Insumo consultar(String codigo) {
        Insumo insumo = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoInsumos[i].getCodigo().equals(codigo)) {
                insumo = this.listadoInsumos[i];
            }
        }
        return insumo;
    }

    public Insumo[] listar() {
        Insumo[] insumosConsultados = new Insumo[this.indice];
        for (int i = 0; i < this.indice; i++) {
            insumosConsultados[i] = this.listadoInsumos[i];
        }
        return insumosConsultados;
    }

    public void modificar(Insumo insumo) {
        for (int i = 0; i < this.indice; i++) {
            if (listadoInsumos[i].getCodigo().equals(insumo.getCodigo())) {
                this.listadoInsumos[i] = insumo;
            }
        }
    }

    private void reemplazar(int in) {
        for (int i = in; i < this.indice - 1; i++) {
            this.listadoInsumos[i] = this.listadoInsumos[i + 1];
        }
        this.listadoInsumos[this.indice - 1] = null;
        this.indice--;
    }

    public void eliminar(String codigo) {
        for (int i = 0; i < this.indice; i++) {
            if (this.listadoInsumos[i].getCodigo().equals(codigo)) {
                reemplazar(i);
            }
        }
    }

}
