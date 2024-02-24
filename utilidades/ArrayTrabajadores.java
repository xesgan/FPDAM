package utilidades;

import empresa.Trabajador;

/**
 * Clase ArrayTrabajadores:
 * Esta clase, ArrayTrabajadores, posee dos atributos:
 * "trabajadores" y "numTrabajadores".
 * Incorpora un constructor para inicializar estos atributos y
 * los métodos requeridos para agregar trabajadores y obtener
 * información sobre ellos.
 *
 * @author Elias Roig
 */

public class ArrayTrabajadores {

    private final int numMaxTrabajadores = 8;
    private Trabajador[] trabajadores;
    private int numTrabajadores;

    // constructor

    public ArrayTrabajadores() {
        this.trabajadores = new Trabajador[numMaxTrabajadores];
        this.numTrabajadores = 0;
    }

    // método para ver si existen trabajadores en el array
    public boolean existenTrabajadores() {
        if (numTrabajadores == 0) {
            System.out.println("No existen trabajadores en la empresa.");
            return false;
        } else {
            return true;
        }
    }

    // método para ver si queda espacio para trabajadores en el array
    public boolean espacioAddTrabajador() {
        if (numTrabajadores == numMaxTrabajadores) {
            System.out.println("No es posible añadir más trabajadores.");
            return false;
        } else {
            return true;
        }
    }

    // método para añadir un trabajador
    public void addTrabajador(Trabajador trabajador) {
        this.trabajadores[numTrabajadores] = trabajador;
        numTrabajadores++;
    }

    // método para encontrar al trabajador por su identificador
    public Trabajador getTrabajador(String identificador) throws Exception {
        for (Trabajador trabajador : trabajadores) {
            if (trabajador != null && trabajador.getIdentificador().equals(identificador)) {
                return trabajador;
            }
        }
        return null;
    }

    // método para mostrar el array con todos los trabajadores

    public Trabajador[] getTrabajadores() {
        Trabajador[] copiaTrabajadores = new Trabajador[numTrabajadores];
        System.out.println();
        return copiaTrabajadores;
    }
}
