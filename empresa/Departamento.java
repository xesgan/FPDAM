package empresa;

/**
 * Clase Departamento
 * Esta clase Departamento está compuesta por dos propiedades: nombre y ubicación.
 * He provisto un constructor para establecer estos atributos inicialmente, además
 * de los métodos de acceso (getters) y modificación (setters) requeridos para interactuar con ellos.
 *
 * @author Elias Roig
 */

public class Departamento {

    private String nombre;
    private String ubicacion;

    // Constructor
    public Departamento(String nombre, String ubicacion) {

    }

    // métodos - getters - setters necesarios
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() { return this.ubicacion; }
    public void setUbicacion() {
        this.ubicacion = ubicacion;
    }

}
