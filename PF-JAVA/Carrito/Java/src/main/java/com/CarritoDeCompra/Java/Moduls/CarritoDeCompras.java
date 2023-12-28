package com.CarritoDeCompra.Java.Moduls;

import com.CarritoDeCompra.Java.Controller.TiendaController;
import com.CarritoDeCompra.Java.Moduls.Producto.Producto;
import com.CarritoDeCompra.Java.Moduls.Producto.Vendible;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CarritoDeCompras {

    Scanner sc = new Scanner(System.in);

    public static List<Vendible> ListaDeProductos = new ArrayList<>();

    public static void agregarProducto (Vendible producto) {
        ListaDeProductos.add(producto);
    }

    public void agregarRopa() {
        System.out.println("Ingrese id del producto para agregar al carrito");
        int idRopa = sc.nextInt();
        if (idRopa >= 0 && idRopa < TiendaController.listaRopa.size()) {
            Vendible productoRopa = TiendaController.listaRopa.get(idRopa);
            CarritoDeCompras.agregarProducto(productoRopa);
            Producto productoR = (Producto) productoRopa;
            System.out.println("Se agregó " + productoR.getNombre() + " al carrito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void agregarComestible() {
        System.out.println("Ingrese id del producto para agregar al carrito");
        int idComestible = sc.nextInt();
        if (idComestible >= 0 && idComestible < TiendaController.listaComestibles.size()) {
            Vendible productoComestible = TiendaController.listaComestibles.get(idComestible);
            CarritoDeCompras.agregarProducto(productoComestible);
            Producto productoC = (Producto) productoComestible;
            System.out.println("Se agregó " + productoC.getNombre() + " al carrito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void agregarElectronico() {
        System.out.println("Ingrese id del producto para agregar al carrito");
        int idElectronico = sc.nextInt();
        if (idElectronico >= 0 && idElectronico < TiendaController.listaElectronico.size()) {
            Vendible productoElectronico = TiendaController.listaElectronico.get(idElectronico);
            CarritoDeCompras.agregarProducto(productoElectronico);
            Producto productoE = (Producto) productoElectronico;
            System.out.println("Se agregó " + productoE.getNombre() + " al carrito.");
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void contenidoCarrito() {

        for (int i = 0; i < CarritoDeCompras.ListaDeProductos.size(); i++) {
            Producto producto = (Producto) CarritoDeCompras.ListaDeProductos.get(i);
            System.out.println("Id: " + i);
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecioBase());
            ;
        }
    }

    public void verCarrito() {
        if (CarritoDeCompras.ListaDeProductos.isEmpty()) {
            System.out.println("Carro vacío.");
        } else {
            contenidoCarrito();
        }
    }

    public void eliminarProducto() {
        if (CarritoDeCompras.ListaDeProductos.isEmpty()) {
            System.out.println("Carro vacío.");

        } else {
            contenidoCarrito();

            System.out.println("Id del producto a eliminar");
            int idEliminar = sc.nextInt();
            if (idEliminar >= 0 && idEliminar < CarritoDeCompras.ListaDeProductos.size()) {
                Producto producto = (Producto) CarritoDeCompras.ListaDeProductos.remove(idEliminar);
                System.out.println("Se Elimino : " + producto.getNombre() + " del carrito.");
            } else {
                System.out.println("El Id ingresado es incorrecto.");
            }
        }
    }

    public static void pagar(Double total){
        System.out.println("Ingrese dinero: ");
        Scanner sc = new Scanner(System.in);
        double importe = sc.nextDouble();
        if (importe < total){
            System.out.println("Dinero insuficiente");
        }else {
            double vuelto = importe - total;
            System.out.println(" Vuelto de $" + vuelto );
            System.exit(0);
        }
    }

    public static void aplicarDescuentos(int tipoCliente){
        double total = 0;
        for (Vendible producto:ListaDeProductos){
            total += producto.CalcularPrecio();
        }
        if (tipoCliente == 1){
            double descuentoRegular = total * 0.2;
            double totalRegular = total - descuentoRegular;
            System.out.println("Total: $" + totalRegular);
            pagar(totalRegular);
        }
        else {double descuentoPremium = total * 0.5;
            double totalPremium = total - descuentoPremium;
            System.out.println("Total : $" + totalPremium) ;
            pagar(totalPremium);
        }
    }

    public void pagarCarrito(){
        boolean valido;
        if (CarritoDeCompras.ListaDeProductos.isEmpty()) {
            System.out.println(" Carro Vacío.");
        } else {
            System.out.println("Tipo de cliente");
            do {
                valido = true;
                System.out.println("1. Regular 5% de descuento");
                System.out.println("2. Premium 10% de descuento");
                int tipoCliente = sc.nextInt();
                switch (tipoCliente) {
                    case 1:
                        CarritoDeCompras.aplicarDescuentos(1);
                        break;
                    case 2:
                        CarritoDeCompras.aplicarDescuentos(2);
                        break;
                    default:
                        System.out.println("Ingrese el tipo de cliente que sea válido");
                        valido = false;
                        break;
                }
            } while (!valido);
        }
    }
}
