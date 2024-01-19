/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
public class DetalleVenta {

    private String codigo;
    private Producto producto;
    private Venta venta;
    private double cantidad;
    private double total;

    public DetalleVenta() {
        this.codigo = "";
        this.producto = null;
        this.venta = null;
        this.cantidad = 0;
        this.total = 0;
    }

    public DetalleVenta(String codigo, Producto producto, Venta venta, double cantidad, double total) {
        this.codigo = codigo;
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "codigo=" + getCodigo() + ", producto=" + getProducto() + ", venta=" + getVenta() + ", cantidad=" + getCantidad() + ", total=" + getTotal() + '}';
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

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
