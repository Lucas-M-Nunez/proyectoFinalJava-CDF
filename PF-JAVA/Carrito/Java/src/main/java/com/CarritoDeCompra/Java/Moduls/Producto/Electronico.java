package com.CarritoDeCompra.Java.Moduls.Producto;

public class Electronico extends Producto {
    private String marca;

    public Electronico(String nombre, double precioBase, String marca) {
        super(nombre, precioBase);
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public double CalcularPrecio() {
        return super.getPrecioBase();
    }
}
