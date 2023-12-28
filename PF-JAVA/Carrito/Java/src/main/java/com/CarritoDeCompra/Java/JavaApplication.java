package com.CarritoDeCompra.Java;

import com.CarritoDeCompra.Java.Controller.TiendaController;
import com.CarritoDeCompra.Java.Moduls.CarritoDeCompras;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JavaApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavaApplication.class, args);

		Scanner sc = new Scanner(System.in);
		CarritoDeCompras accionesCarrito = new CarritoDeCompras();
		TiendaController tiendaController = new TiendaController();

		boolean salir;

		tiendaController.inicializarListas();
		System.out.println("Bienvenido!");

		do {
			salir = false;
			System.out.println("Seleccione que quiere hacer: ");
			System.out.println("1.Agregar productos al carrito");
			System.out.println("2.Ver productos en carrito");
			System.out.println("3.Eliminar producto del carrito");
			System.out.println("4.Pagar productos en carrito");
			System.out.println("5.Salir");

			int opcion = sc.nextInt();

			switch (opcion) {
				case 1:
					boolean volver;
					do {
						System.out.println("1.Agregar ropa");
						System.out.println("2.Agregar frutas y verduras");
						System.out.println("3.Agregar electronicos");
						System.out.println("4.Volver");
						int opcionAgregar = sc.nextInt();
						volver = false;
						switch (opcionAgregar) {
							case 1:
								accionesCarrito.agregarRopa();
								break;
							case 2:
								accionesCarrito.agregarComestible();
								break;
							case 3:
								accionesCarrito.agregarElectronico();
								break;
							case 4:
								volver = true;
								break;
							default:
								System.out.println("Elija una opción válida.");
								break;
						}
					} while (!volver);
					break;
				case 2:
					accionesCarrito.verCarrito();
					break;

				case 3:
					accionesCarrito.eliminarProducto();
					break;
				case 4:
					accionesCarrito.pagarCarrito();
					break;
				case 5:
					salir = true;
					break;
				default:
					System.out.println("Elija una opción válida.");
					break;
			}

		} while (!salir);
		System.out.println("¡Gracias por su visita, vuelva pronto!");
		System.exit(0);
	}

}
