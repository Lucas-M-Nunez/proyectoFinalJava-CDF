package Entidades;

public class Mascota {

    private static final int MAX_ENERGIA = 100;
    private static final int MIN_ENERGIA = 0;

    private String nombre;
    private int energia;
    private double peso;
    private boolean dormido;
    private int humor;
    private int cantComer;

    public Mascota() {
    }

    public Mascota(String nombre) {
        this.nombre = nombre;
        this.energia = 50;
        this.peso = 5.0;
        this.dormido = false;
        this.humor = 3;
        this.cantComer = 0;
    }

    public void comer() {
        if (!dormido) {
            energia += 20;
            peso += 0.5;
            cantComer++;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha comido! Energía aumentada, peso aumentado.");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda comer.");
        }
    }

    public void dormir() {
        if (!dormido) {
            dormido = true;
            System.out.println("¡" + nombre + " está durmiendo!");
        } else {
            System.out.println("¡" + nombre + " ya está dormido!");
        }
    }

    public void despertar() {
        if (dormido) {
            dormido = false;
            System.out.println("¡" + nombre + " se ha despertado!");
        } else {
            System.out.println("¡" + nombre + " ya está despierto!");
        }
    }

    public void caminar() {
        if (!dormido) {
            energia -= 10;
            peso -= 0.2;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha caminado! Energía disminuida, peso disminuido.");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda caminar.");
        }
    }

    public void correr() {
        if (!dormido) {
            energia -= 30;
            peso -= 0.5;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha corrido! Energía disminuida mucho, peso disminuido mucho.");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda correr.");
        }
    }

    public void obtenerEnergia() {
        if (!dormido) {
            energia += 15;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha obtenido energía!");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda obtener energía.");
        }
    }

    public boolean estaVivo() {
        return energia > MIN_ENERGIA && energia <= MAX_ENERGIA;
    }

    public void mostrarEstado() {
        System.out.println("Estado actual de " + nombre);
        System.out.println("Energía: " + energia);
        System.out.println("Peso: " + peso);
        System.out.println("Humor: " + obtenerHumor());
        System.out.println("Valor CantComer: " +cantComer);
    }

    private String obtenerHumor() {
        return switch (humor) {
            case 1 -> "😞";
            case 2 -> "😒";
            case 3 -> "😐";
            case 4 -> "😊";
            case 5 -> "😎";
            default -> "Desconocido";
        };
    }

    private void ajustarEstado() {
        humor = calcularHumor();
    }

    private int calcularHumor() {
        int humorComida;
        if (cantComer >= 3) {
            humorComida = 5;  // Muy feliz si ha comido al menos 3 veces
        } else if (cantComer >= 1) {
            humorComida = 3;  // Neutro si ha comido al menos 1 vez
        } else {
            humorComida = 2;  // Triste si no ha comido
        }

        int humorEnergia;
        if (energia >= 85) {
            humorEnergia = 5;  // Muy feliz si la energía es alta
        } else if (energia >= 50) {
            humorEnergia = 3;  // Neutro si la energía es moderada
        } else {
            humorEnergia = 1;  // Otro estado si la energía es baja
        }
        // Tomar el peor de los dos estados de humor
        return Math.min(humorComida, humorEnergia);
    }
}
