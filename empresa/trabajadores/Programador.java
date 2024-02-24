package empresa.trabajadores;

import empresa.Departamento;
import empresa.Trabajador;

/**
 * Clase que contiene la información necesaria sobre el tipo de trabajador y
 * hereda la clase trabajador.
 * @author Elias Roig
 */

public class Programador extends Trabajador {

    private String lenguaje;

// constructor
    public Programador(String nombre,
                       String mail,                             // además me faltaria añadir identificador en el constructor tambien
                       String telefono,                         // y el identificador haciendolo como strin tambien le escribo ""?
                       Departamento departamento,
                       String identificador,
                       int horasExtra,
                       String lenguaje)
    {
        super(nombre, mail, telefono, departamento, identificador, horasExtra);
        this.lenguaje = lenguaje;
    }

    // Métodos getters y setters
    public String getLenguaje() {
        return this.lenguaje;
    }
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public double calcularSueldoBase(double sueldoBaseMaximo) {
        return sueldoBaseMaximo * 0.4;
    }

    @Override
    public double calcularNomina(double sueldoBaseMaximo) {
        return calcularSueldoBase(sueldoBaseMaximo) +
                (calcularSueldoBase(sueldoBaseMaximo) / 80 * horasExtra);
    }
}
