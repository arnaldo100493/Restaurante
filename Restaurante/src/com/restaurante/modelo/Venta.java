/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurante.modelo;

/**
 *
 * @author abarrios
 */
public class Venta {

    private String codigo;
    private String fechaRegistro;
    private Producto producto;

    public Venta() {
        this.codigo = "";
        this.fechaRegistro = "";
        this.producto = null;
    }

    public Venta(String codigo, String fechaRegistro, Producto producto) {
        this.codigo = codigo;
        this.fechaRegistro = fechaRegistro;
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo=" + getCodigo() + ", fechaRegistro=" + getFechaRegistro() + ", producto=" + getProducto() + '}';
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the fechaRegistro
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
