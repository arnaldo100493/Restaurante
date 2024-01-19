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
public class Insumo {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String fechaRegistro;
    private double precio;
    private double cantidadExistente;
    private double peso;
    private double cantidadMinima;
    private double cantidadMaxima;

    public Insumo() {
        this.codigo = "";
        this.nombre = "";
        this.descripcion = "";
        this.tipo = "";
        this.fechaRegistro = "";
        this.precio = 0;
        this.cantidadExistente = 0;
        this.peso = 0;
        this.cantidadMinima = 0;
        this.cantidadMaxima = 0;

    }

    public Insumo(String codigo, String nombre, String descripcion, String tipo, String fechaRegistro, double precio, double cantidadExistente, double peso, double cantidadMinima, double cantidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaRegistro = fechaRegistro;
        this.precio = precio;
        this.cantidadExistente = cantidadExistente;
        this.peso = peso;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
    }

    @Override
    public String toString() {
        return "Insumo{" + "codigo=" + getCodigo() + ", nombre=" + getNombre() + ", descripcion=" + getDescripcion() + ", tipo=" + getTipo() + ", fechaRegistro=" + getFechaRegistro() + ", precio=" + getPrecio() + ", cantidadExistente=" + getCantidadExistente() + ", peso=" + getPeso() + ", cantidadMinima=" + getCantidadMinima() + ", cantidadMaxima=" + getCantidadMaxima() + '}';
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the cantidadExistente
     */
    public double getCantidadExistente() {
        return cantidadExistente;
    }

    /**
     * @param cantidadExistente the cantidadExistente to set
     */
    public void setCantidadExistente(double cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the cantidadMinima
     */
    public double getCantidadMinima() {
        return cantidadMinima;
    }

    /**
     * @param cantidadMinima the cantidadMinima to set
     */
    public void setCantidadMinima(double cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    /**
     * @return the cantidadMaxima
     */
    public double getCantidadMaxima() {
        return cantidadMaxima;
    }

    /**
     * @param cantidadMaxima the cantidadMaxima to set
     */
    public void setCantidadMaxima(double cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }
}
