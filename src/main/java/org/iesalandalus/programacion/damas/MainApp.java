package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {

    // atributo de clase de tipo Dama
    private static Dama dama;

    // metodo opcines
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    // metodo dama por defecto
    public static void crearDamaDefecto() {
        dama = new Dama(); // crea una dama usando el constructor por defecto
        System.out.println("Dama creada por defecto: " + dama);
    }

    // metodo dama según color
    public static void crearDamaColor() {
        Color color = Consola.elegirOpcion();
        dama = new Dama(color); // según el color almacenado en "color" crea una dama
        System.out.println("Dama creada segñun el color " + color + ": " + dama);
    }
}
