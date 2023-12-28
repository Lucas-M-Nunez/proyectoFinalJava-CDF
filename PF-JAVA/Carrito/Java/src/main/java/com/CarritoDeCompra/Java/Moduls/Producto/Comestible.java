package com.CarritoDeCompra.Java.Moduls.Producto;

public class Comestible extends Producto {

    public Comestible(String nombre, double precioBase) {
        super(nombre, precioBase);
    }

    @Override
    public double CalcularPrecio() {
        return super.getPrecioBase();
    }
}
