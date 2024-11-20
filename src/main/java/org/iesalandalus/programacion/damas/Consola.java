package org.iesalandalus.programacion.damas;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() { // constructor privado para impedir instanciación

    }

    public static void mostrarMenu () {
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
}
