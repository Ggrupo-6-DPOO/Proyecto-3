package Main;

import Usuarios.Administrador;
import Usuarios.Empleado;
import Usuarios.RolEmpleado;
import Usuarios.Turno;
import Servicios.LugarServicios;
import Servicios.TipoLugar;
import Servicios.Cafeteria;
import Servicios.Taquilla;
import Servicios.Tienda;
import Atracciones.atraccion;
import Atracciones.NivelExclusividad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAdministrador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear permisos simulados
        List<String> permisos = new ArrayList<>();
        permisos.add("gestionar_atracciones");
        permisos.add("asignar_empleados");

        // Crear administrador de prueba
        Administrador admin = new Administrador(
                "Carlos Pérez",
                100,
                permisos,
                "admin1",
                "adminpass"
        );

        // Crear una atracción de prueba
        atraccion montanaRusa = new atraccion("Montaña Rusa", "Sector A", 20, 2, NivelExclusividad.REGULAR);

        // Crear lugares de servicios concretos
        Cafeteria cafeteria = new Cafeteria("Cafetería Central", "Sector A", 50, true);
        Tienda tienda = new Tienda("Tienda de Souvenirs", "Sector B", "Souvenirs");
        Taquilla taquilla = new Taquilla("Taquilla Principal", "Entrada", 1, true);

        // Crear empleado de prueba
        Empleado empleado = new Empleado(
                "Laura Gómez",
                201,
                RolEmpleado.CAJERO,
                new ArrayList<>(),
                Turno.APERTURA,
                "Cafetería Central",
                "lauraG",
                "clave123"
        );

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ ADMINISTRADOR =====");
            System.out.println("1. Ver datos del administrador");
            System.out.println("2. Activar/Desactivar atracción");
            System.out.println("3. Asignar empleado a lugar");
            System.out.println("4. Consultar permisos");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");

            int opcion;
            if(scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Datos del administrador ---");
                    System.out.println("Nombre: " + admin.getNombre());
                    System.out.println("ID: " + admin.getId());
                    break;

                case 2:
                    System.out.println("\nEstado actual de la atracción: " + (montanaRusa.isEstado() ? "Activa" : "Inactiva"));
                    System.out.print("¿Desea (1) Activar o (2) Desactivar la atracción? ");
                    if(scanner.hasNextInt()) {
                        int accion = scanner.nextInt();
                        if(accion == 1) {
                            montanaRusa.activar();
                        } else if(accion == 2) {
                            montanaRusa.desactivar();
                        } else {
                            System.out.println("Opción no válida.");
                            break;
                        }
                        System.out.println("Atracción ahora está: " + (montanaRusa.isEstado() ? "Activa" : "Inactiva"));
                    } else {
                        System.out.println("Por favor, ingrese un número válido.");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.println("\nSeleccione el lugar para asignar el empleado:");
                    System.out.println("1. Cafetería");
                    System.out.println("2. Tienda");
                    System.out.println("3. Taquilla");
                    System.out.print("Ingrese la opción: ");
                    if(scanner.hasNextInt()) {
                        int lugarOpcion = scanner.nextInt();
                        LugarServicios lugarSeleccionado = null;
                        switch(lugarOpcion) {
                            case 1:
                                lugarSeleccionado = cafeteria;
                                break;
                            case 2:
                                lugarSeleccionado = tienda;
                                break;
                            case 3:
                                lugarSeleccionado = taquilla;
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                continue;
                        }
                        try {
                            admin.asignarEmpleado(empleado, lugarSeleccionado);
                            empleado.setLugarTrabajo(lugarSeleccionado.getNombre());
                            System.out.println("Empleado asignado a " + lugarSeleccionado.getNombre());
                        } catch (IllegalArgumentException e) {
                            System.out.println("No se pudo asignar el empleado: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Por favor, ingrese un número válido.");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.println("\n--- Permisos del administrador ---");
                    for(String permiso : permisos) {
                        System.out.println("- " + permiso);
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Sesión cerrada.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}