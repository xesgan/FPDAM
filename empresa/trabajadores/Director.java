package empresa.trabajadores;

import empresa.Departamento;
import empresa.Trabajador;

/**
 * Clase que contiene la información necesaria del tipo de trabajador director
 * y hereda la clase trabajador.
 *
 * @author Elias Roig
 */

public class Director extends Trabajador {

    private int antiguedad;

    // Constructor
    public Director(String nombre,
                    String mail,
                    String telefono,
                    Departamento departamento,
                    String identificador,
                    int horasExtra,
                    int antiguedad) {
        super(nombre, mail, telefono, departamento, identificador, horasExtra);
        this.antiguedad = antiguedad;
    }

    // Métodos getters y setters
    public int getAntiguedad() {
        return this.antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }


    @Override
    public double calcularSueldoBase(double sueldoBaseMaximo) {
        return sueldoBaseMaximo;
    }
    @Override
    public double calcularNomina(double sueldoBaseMaximo) {
        return sueldoBaseMaximo + (antiguedad * 45) +
                (sueldoBaseMaximo / 80 * horasExtra);
    }
}
