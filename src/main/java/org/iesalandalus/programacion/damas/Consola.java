package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() { // constructor privado para impedir instanciación

    }

    public static void mostrarMenu() {
        System.out.println("Menú principal Damas");
        System.out.println("1. Crear dama por defecto");
        System.out.println("2. Crear dama eligiendo el color");
        System.out.println("3. Mover dama");
        System.out.println("4. Salir del menú");
    }

    // metodo para elegir una opción del menú
    public static int elegirOpcionMenu() {
        int opcion;
        do {
            System.out.print("Elige una opción del menú (1 al 4): ");
            opcion = Entrada.entero(); // lee un entero y lo almacena en opcion
            if (opcion < 1 || opcion > 4) {
                System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 4.");
            }
        } while (opcion < 1 || opcion > 4); // repite mientras la opción sea inválida
        return opcion; // devuelve la opción válida
    }

    // elegir color dama
    public static Color elegirOpcion() {
        int opcion;
        do {
            System.out.println("Elige el color de la dama (1 -> blanca | 2 -> negra): ");
            opcion = Entrada.entero();

            if (opcion != 1 && opcion != 2) {
                System.out.println("Error, opción no válida. Elige el color de la dama (1 -> blanca | 2 -> negra): ");
            }
        } while (opcion != 1 && opcion != 2); // repetir hasta opción válida

        if (opcion == 1) {
            return Color.BLANCO;
        } else {
            return Color.NEGRO;
        }
    }

    // menú direcciones
    public static void mostrarMenuDirecciones() {
        System.out.println("Menú de direcciones");
        System.out.println("1. Noreste");
        System.out.println("2. Sureste");
        System.out.println("3. Suroeste");
        System.out.println("4. Noroeste");
    }

    // metodo para elegir dirección
    public static Direccion elegirDireccion() {
        int opcion;
        Direccion direccionElegida = null; // se inicializa a null
        do {
            System.out.println("Elige una dirección del menú (1 al 4): ");
            opcion = Entrada.entero();

            switch (opcion) {
                case 1:
                    direccionElegida = Direccion.NORESTE;
                    break;
                case 2:
                    direccionElegida = Direccion.SURESTE;
                    break;
                case 3:
                    direccionElegida = Direccion.SUROESTE;
                    break;
                case 4:
                    direccionElegida = Direccion.NOROESTE;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 4.");
            }
        }while (direccionElegida == null); // se repite hasta que se elija opción válida

        return direccionElegida; // devuelve la dirección elegida
    }

}
