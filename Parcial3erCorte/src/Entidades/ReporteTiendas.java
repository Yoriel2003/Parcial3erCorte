package Entidades;

import java.io.Serializable;


public class ReporteTiendas implements Serializable {
    private String CTienda, Nombre, Ciudad, Dpto, NProducto;
    private int  Descuento, Total;
    private int Subtotal;

    public ReporteTiendas() {
    }

    public ReporteTiendas(String CTienda, String Nombre, String Ciudad, String Dpto, String NProducto, int Subtotal, int Descuento, int Total) {
        this.CTienda = CTienda;
        this.Nombre = Nombre;
        this.Ciudad = Ciudad;
        this.Dpto = Dpto;
        this.NProducto = NProducto;
        this.Subtotal = Subtotal;
        this.Descuento = Descuento;
        this.Total = Total;
    }

    public String getCTienda() {
        return CTienda;
    }

    public void setCTienda(String CTienda) {
        this.CTienda = CTienda;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDpto() {
        return Dpto;
    }

    public void setDpto(String Dpto) {
        this.Dpto = Dpto;
    }

    public String getNProducto() {
        return NProducto;
    }

    public void setNProducto(String NProducto) {
        this.NProducto = NProducto;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(int Subtotal) {
        this.Subtotal = Subtotal;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
    public String getArchivoDatos (){
        return this.CTienda + ";" 
                + this.Nombre + ";" 
                + this.Ciudad + ";" 
                + this.Dpto + ";" 
                + this.NProducto + ";" 
                + this.Subtotal + "+" 
                + this.Descuento + ";" 
                + this.Total;
  
    }
}
