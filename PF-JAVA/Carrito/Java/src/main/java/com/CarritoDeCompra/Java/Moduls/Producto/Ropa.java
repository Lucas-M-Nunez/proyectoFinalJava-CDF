package com.CarritoDeCompra.Java.Moduls.Producto;

public class Ropa extends Producto{

    private String talle;
    private String Marca;
    private String Description;

    public Ropa(String nombre, double precioBase, String talle, String marca, String description) {
        super(nombre, precioBase);
        this.talle = talle;
        Marca = marca;
        Description = description;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public double CalcularPrecio() {
        return super.getPrecioBase();
    }
}
