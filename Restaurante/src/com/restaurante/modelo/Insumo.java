package Modelo;

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
    
    public void setCodigo(String Codigo){
      this.codigo = Codigo;  
    }
    
    public String getCodigo(){
      return this.codigo;  
    }
   
    public void setNombre(String Nombre){
      this.nombre = Nombre;  
    }

    public String getNombre(){
      return this.nombre;  
    }
    
    public void setDescripcion(String Descripcion){
      this.descripcion = Descripcion;  
    }
    
    public String getDescripcion(){
      return this.descripcion;  
    }
    
    public void setTipo(String Tipo){
      this.tipo = Tipo;  
    }

    public String getTipo(){
      return this.tipo;  
    }
    
    public void setFechaRegistro(String fechaRegistro){
      this.fechaRegistro = fechaRegistro;  
    }
    
    public String getFechaRegistro(){
      return this.fechaRegistro;  
    }

    public void setPrecio(double Precio){
      this.precio = Precio; 
    }

    public double getPrecio(){
      return this.precio;  
    }

    public void setCantidadExistente(double cantidadExistente){
      this.cantidadExistente = cantidadExistente;  
    }
    
    public double getCantidadExistente(){
      return this.cantidadExistente;  
    }
    
    public void setPeso(double Peso){
      this.peso = Peso;  
    }
    
    public double getPeso(){
      return peso;  
    }
    
  public void setCantidadMinima(double cantidadMinima){
    this.cantidadMinima = cantidadMinima;  
  }
  
  public double getCantidadMinima(){
    return this.cantidadMinima;  
  }
  
  public void setCantidadMaxima(double cantidadMaxima){
    this.cantidadMaxima = cantidadMaxima;  
  }
  
  public double getCantidadMaxima(){
    return this.cantidadMaxima; 
  }
    
}
