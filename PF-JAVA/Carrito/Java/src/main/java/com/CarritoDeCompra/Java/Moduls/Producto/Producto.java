package com.CarritoDeCompra.Java.Moduls.Producto;

public abstract class Producto implements Vendible{

    private String nombre;
    private double precioBase;


    public Producto(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public double CalcularPrecio() {
        return precioBase;
    }
}
