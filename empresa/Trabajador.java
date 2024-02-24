package empresa;

import java.time.Year;

/**
 * Clase que sirve para llamar toda la información de los trabajadores que contiene la clase padre
 * Trabajador.
 *
 * @author Elias Roig
 */

public abstract class Trabajador {

    // Método para calcular el sueldo base
    public abstract double calcularSueldoBase(double sueldoBaseMaximo);

    // Método para calcular la nómina
    public abstract double calcularNomina(double sueldoBaseMaximo);

    protected String nombre;
    protected String mail;
    protected String telefono;
    protected String identificador;
    protected Departamento departamento;
    protected int horasExtra;

    // Constructor
    public Trabajador(String nombre,
                      String mail,
                      String telefono,
                      Departamento departamento,
                      String identificador,
                      int horasExtra) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
        this.departamento = departamento;
        this.horasExtra = horasExtra;
        this.identificador = calcularIdentificador();
    }


    // Métodos getters y setters
    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() { return this.mail; }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() { return this.telefono; }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Departamento getDepartamento() { return this.departamento; }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
        calcularIdentificador(); // Recalculamos el identificador cuando se cambia el departamento
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public int getHorasExtra() {
        return this.horasExtra;
    }
    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }


    // Método para calcular el identificador
    public String calcularIdentificador() {
        String año = String.valueOf(Year.now().getValue());
        String nombreDepartamento = departamento.getNombre().substring(0, Math.min(3, departamento.getNombre().length())).toUpperCase();
        // aquí se está diviendo el nombre en partes con un espacio
        String[] partesNombre = nombre.split(" ");
        String nombreCorto = "";
        for (String parte : partesNombre) {
            nombreCorto += parte.charAt(0);
        }
        String identificador = año + nombreDepartamento + nombreCorto;

        return identificador;
    }


}

