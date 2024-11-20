package org.iesalandalus.programacion.damas;

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
}
