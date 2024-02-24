package empresa;

import empresa.trabajadores.Director;
import empresa.trabajadores.Gestor;
import empresa.trabajadores.Programador;
import utilidades.ArrayTrabajadores;

import java.util.Scanner;


/**
 * Clase Empresa principal donde se abre el menú y de dirige al resto de métodos y clases
 * @author Elias Roig
 */

public class Empresa {
    // Variable para almacenar el sueldo base máximo de la empresa.empresa
    static double sueldoBaseMaximo = 5200d;

    private static final ArrayTrabajadores arrayTrabajadores = new ArrayTrabajadores();


    // 1 - Desplegar Menú
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        // Ciclo del menú
        boolean salir = false;
        while (!salir) {
            // Mostrar el menú
            System.out.println("Menú:");
            System.out.println("1. Establecer sueldo base máximo de la Empresa");
            System.out.println("2. Añadir un nuevo trabajador a la Empresa");
            System.out.println("3. Mostrar los datos de todos los trabajadores de la Empresa");
            System.out.println("4. Modificar el número de horas extraordinarias de un trabajador");
            System.out.println("5. Mostrar la nómina de un trabajador");
            System.out.println("6. Mostrar el número de trabajadores y el pago total en nóminas de un departamento");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");

            // Leer la opción del usuario
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            // Realizar acciones según la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el sueldo base máximo de la Empresa: ");
                    sueldoBaseMaximo = sc.nextDouble();
                    System.out.println("Sueldo base máximo establecido correctamente.");
                    break;

                case 2:
                    // Comprobar si se pueden añadir más trabajadores
                    if (!arrayTrabajadores.espacioAddTrabajador()) { return; }

                    // Pedir información básica del trabajador
                    System.out.println("\nIntroduce los datos del nuevo trabajador");
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Correo: ");
                    String mail = sc.nextLine();
                    System.out.println("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.println("Departamento: ");
                    String nombreDepartamento = sc.nextLine();
                    System.out.println("Ubicación del departamento: ");
                    String ubicacionDepartamento = sc.nextLine();
                    // Crea el departamento y el trabajador vacío
                    Departamento departamento = new Departamento(nombreDepartamento, ubicacionDepartamento);
                    Trabajador trabajador = null;

                    // Definición de la profesión del trabajador

                        System.out.println("¿Qué profesión hará el trabajador?\n1. 1.- Programador\n2. 2.- Gestor\n3. 3.- Director");
                        String profesion = sc.nextLine();
                        try {
                            Trabajador nuevoTrabajador = null;
                            switch (profesion) {
                                case "1":
                                    System.out.println("Lenguaje de programación: ");
                                    String lenguaje = sc.nextLine();
                                    trabajador = new Programador(nombre, mail, telefono, departamento, "", 0, lenguaje);
                                    break;
                                case "2":
                                    System.out.println("Especialidad de gestión: ");
                                    String especialidad = sc.nextLine();
                                    trabajador = new Gestor(nombre, mail, telefono, departamento, "", 0, especialidad);
                                    break;
                                case "3":
                                    System.out.println("Antigüedad del director: ");
                                    int antiguedad = Integer.parseInt(sc.nextLine());
                                    trabajador = new Director(nombre, mail, telefono, departamento,"",0, antiguedad);
                                    break;
                                default:
                                    System.out.println("Rol no válido");  //
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: introduzca la profesión acordada.");
                        }

                    break;

                case 3:
                    // Lógica para mostrar los datos de todos los trabajadores
                    if (!arrayTrabajadores.existenTrabajadores()) { return; }
                    System.out.println("\n DATOS DE LOS TRABAJADORES");
                    System.out.println("****************************");
                    Trabajador[] trabajadores = arrayTrabajadores.getTrabajadores();
                    for (Trabajador trabajador : trabajadores) {
                        if (trabajador != null) {
                            System.out.println("Identificador: " + trabajador.getIdentificador());
                            System.out.println("Nombre: " + trabajador.getNombre());
                            System.out.println("Mail: " + trabajador.getMail());
                            System.out.println("Teléfono: " + trabajador.getTelefono());
                            System.out.println("Departamento: " + trabajador.getDepartamento().getNombre());
                            if (trabajador instanceof Programador) {
                                System.out.println("Rol: Programador");
                                System.out.println("Lenguaje: " + ((Programador)trabajador).getLenguaje());
                            } else if (trabajador instanceof Gestor) {
                                System.out.println("Rol: Gestor");
                                System.out.println("Especialidad: " + ((Gestor)trabajador).getEspecialidad());
                            } else if (trabajador instanceof Director) {
                                System.out.println("Rol: Director");
                                System.out.println("Antigüedad: " + ((Director)trabajador).getAntiguedad());
                            }
                            System.out.println("****************************");
                        }
                    }
                    break;

                case 4:
                    // Lógica para modificar el número de horas extraordinarias de un trabajador
                    if (!arrayTrabajadores.existenTrabajadores()) { return; }
                    System.out.println("\n Introduce el indentificador del trabajador: ");
                    String identificador = sc.nextLine();
                    try {
                        Trabajador trabajador = arrayTrabajadores.getTrabajador(identificador);
                        System.out.println("Introduce las horas extraordinarias relizadas: ");
                        int horasExtra = sc.nextInt();
                        sc.nextLine();
                        trabajador.setHorasExtra(horasExtra);
                        System.out.println("Horas extras modificadas.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    // Lógica para mostrar la nómina de un trabajador
                    if (!arrayTrabajadores.existenTrabajadores()) { return; }
                    System.out.println("\n Introduce el identificador del trabajador: ");
                    String identificador = sc.nextLine();
                    try {
                        Trabajador trabajador = arrayTrabajadores.getTrabajador(identificador);
                        System.out.println("Nómina de " + trabajador.getNombre());
                        System.out.println("Sueldo base: " + trabajador.calcularSueldoBase(sueldoBaseMaximo));
                        System.out.println("Horas Extras: " + trabajador.getHorasExtra());
                        System.out.println("Total nómina: " + trabajador.calcularNomina(sueldoBaseMaximo));
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    // Lógica para mostrar el número de trabajadores y el pago total en nóminas de un departamento
                    if (!arrayTrabajadores.existenTrabajadores()) { return; }
                    System.out.println("\n Introduce el nombre del departamento: ");
                    nombreDepartamento = sc.nextLine();
                    try {
                        trabajadores = arrayTrabajadores.getTrabajadores();
                        int existenTrabajadores = 0;
                        double sueldoTotal = 0;
                        for (Trabajador trabajador : trabajadores) {
                            if (trabajador != null && trabajador.getDepartamento().getNombre().equals(nombreDepartamento)) {
                                existenTrabajadores++;
                                sueldoTotal += trabajador.calcularNomina(sueldoBaseMaximo);
                            }
                        }
                        System.out.println("Número de trabajadores: " + existenTrabajadores);
                        System.out.println("Total de nóminas: " + sueldoTotal);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 7:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 7.");
                    break;
            }
        }

        sc.close();
    }
}
