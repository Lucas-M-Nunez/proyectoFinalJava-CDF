// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

/*
    TAMAGOTCHI - MASCOTA VIRTUAL

MAX_ENERGIA = 100
    MIN_ENERGIA = 0

    nombre: string
    energia: entero ;
    peso : doble
    dormido: booleano
    humor: entero 1😞 2😒 3😐 4😊 5😎
    cantComer: entero

    comer(): // aumenta energia, aumenta peso
    dormir(): // dormir true
    despertar(): // dormir false
    caminar(): // disminuye energia, disminuye peso
    correr(): // disminuye mucha energia, disminuye mucho peso
    obtenerEnergia(): // aumenta energia
    estaVivo(): // devuelve true o false segun energia
 */

import Entidades.Mascota;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de su Tamagotchi: ");
        String nombre = sc.nextLine();

        Mascota miTamagotchi = new Mascota(nombre);

        while (miTamagotchi.estaVivo()) {
            miTamagotchi.mostrarEstado();

            System.out.println("\nAcciones disponibles:");
            System.out.println("1. Comer");
            System.out.println("2. Dormir");
            System.out.println("3. Despertar");
            System.out.println("4. Caminar");
            System.out.println("5. Correr");
            System.out.println("6. Obtener Energía");
            System.out.println("7. Salir");

            System.out.print("Ingrese el número de la acción deseada: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    miTamagotchi.comer();
                    break;
                case 2:
                    miTamagotchi.dormir();
                    break;
                case 3:
                    miTamagotchi.despertar();
                    break;
                case 4:
                    miTamagotchi.caminar();
                    break;
                case 5:
                    miTamagotchi.correr();
                    break;
                case 6:
                    miTamagotchi.obtenerEnergia();
                    break;
                case 7:
                    System.out.println("¡Adiós! Gracias por cuidar de " + nombre);
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        System.out.println("¡" + nombre + " ha fallecido! 😢");
    }
}