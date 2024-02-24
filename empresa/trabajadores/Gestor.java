package empresa.trabajadores;

import empresa.Departamento;
import empresa.Trabajador;

/**
 * Clase que contiene la información necesaria del tipo de trabajador gestor
 * @author Elias Roig
 */

public class Gestor extends Trabajador {

    // Atributos
    private String especialidad;

    // Constructor
    public Gestor(String nombre,
                  String mail,
                  String telefono,
                  Departamento departamento,
                  String identificador,
                  int horasExtra,
                  String especialidad) {
        super(nombre, mail, telefono, departamento, identificador, horasExtra);
        this.especialidad = especialidad;
    }

    // Métodos getters y setters
    public String getEspecialidad() {
        return this.especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public double calcularSueldoBase(double sueldoBaseMaximo) {
        return sueldoBaseMaximo * 0.7;
    }

    @Override
    public double calcularNomina(double sueldoBaseMaximo) {
        return calcularSueldoBase(sueldoBaseMaximo) +
                (calcularSueldoBase(sueldoBaseMaximo) / 80 * horasExtra);
    }
}
