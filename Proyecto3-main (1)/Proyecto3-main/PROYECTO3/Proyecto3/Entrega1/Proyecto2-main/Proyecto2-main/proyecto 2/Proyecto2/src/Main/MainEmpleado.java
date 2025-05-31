package Main;

import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import Usuarios.Turno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEmpleado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        List<String> capacitaciones = new ArrayList<>();
        capacitaciones.add("Atención al cliente");
        capacitaciones.add("Primeros auxilios");

        
        Empleado empleado = new Empleado(
                "Carlos López",
                101,
                RolEmpleado.CAJERO,
                capacitaciones,
                Turno.APERTURA,
                "Taquilla",
                "carlos",
                "1234"
        );

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ EMPLEADO =====");
            System.out.println("1. Ver datos personales");
            System.out.println("2. Ver rol y capacitaciones");
            System.out.println("3. Consultar asignación de turno y lugar");
            System.out.println("4. Registrar entrada");
            System.out.println("5. Registrar salida");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Datos personales ---");
                    System.out.println("Nombre: " + empleado.getNombre());
                    System.out.println("ID: " + empleado.getId());
                    break;

                case 2:
                    System.out.println("\n--- Rol y Capacitaciones ---");
                    System.out.println("Rol: " + empleado.getRol());
                    System.out.println("Capacitaciones:");
                    for (String c : empleado.getCapacitaciones()) {
                        System.out.println(" - " + c);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Asignación ---");
                    System.out.println(empleado.consultarAsignacion());
                    break;

                case 4:
                    System.out.println("\nEntrada registrada a las " + java.time.LocalTime.now());
                    break;

                case 5:
                    System.out.println("\nSalida registrada a las " + java.time.LocalTime.now());
                    break;

                case 6:
                    salir = true;
                    System.out.println("Sesión finalizada.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
