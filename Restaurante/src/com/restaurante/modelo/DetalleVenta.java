package Modelo;

public class DetalleVenta {
   
   private String codigo; 
   private Producto producto;
   private Venta venta;
   private double cantidad;
   private double total;    
    
   public DetalleVenta(){
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
   
    public void setCodigo(String Codigo){
     this.codigo = Codigo;  
   }
   
   public String getCodigo(){
     return this.codigo;  
   }
   
   public void setProducto(Producto Producto){
     this.producto = Producto;  
   }
   
   public Producto getProducto(){
     return this.producto;  
   }
   
   public void setVenta(Venta Venta){
     this.venta = Venta;  
   }
   
   public Venta getVenta(){
     return this.venta;  
   }
  
   public void setCantidad(double Cantidad){
     this.cantidad = Cantidad;  
   }
   
   public double getCantidad(){
     return this.cantidad;  
   }
   
   public void setTotal(double Total){
     this.total = Total;  
   }
   
   public double getTotal(){
     return this.total;  
   }
   
}
