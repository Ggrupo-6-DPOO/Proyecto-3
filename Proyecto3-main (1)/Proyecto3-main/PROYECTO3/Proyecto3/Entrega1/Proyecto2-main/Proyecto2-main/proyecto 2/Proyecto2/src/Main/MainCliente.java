package Main;

import Usuarios.Cliente;
import parque.ventas.Tiquete;
import parque.ventas.TipoTiquete;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainCliente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear cliente de prueba
        List<String> contraindicaciones = new ArrayList<>();
        contraindicaciones.add("Hipertensión");

        Cliente cliente = new Cliente(
                1001,
                "Ana Pérez",
                28,
                1.68,
                58.0,
                contraindicaciones,
                "ana123",
                "clave123"
        );

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ CLIENTE =====");
            System.out.println("1. Ver datos personales");
            System.out.println("2. Ver contraindicaciones");
            System.out.println("3. Comprar tiquete (simulado)");
            System.out.println("4. Ver tiquetes comprados");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Datos personales ---");
                    System.out.println("Nombre: " + cliente.getNombre());
                    System.out.println("ID: " + cliente.getId());
                    System.out.println("Edad: " + cliente.getEdad());
                    System.out.println("Altura: " + cliente.getAltura() + " m");
                    System.out.println("Peso: " + cliente.getPeso() + " kg");
                    break;

                case 2:
                    System.out.println("\n--- Contraindicaciones ---");
                    if (cliente.getContraindicaciones().isEmpty()) {
                        System.out.println("No tiene contraindicaciones registradas.");
                    } else {
                        for (String c : cliente.getContraindicaciones()) {
                            System.out.println("- " + c);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Compra de tiquete simulada ---");
                    Tiquete tiquete = new Tiquete(
                            1,                    // ID del tiquete
                            50000.0,              // Precio
                            100,                  // Cupo máximo
                            false,                // ¿Es de temporada?
                            TipoTiquete.FAMILIAR,   // Tipo de tiquete (debes tener el enum)
                            new Date(),           // Fecha de compra
                            5000.0,               // Descuento
                            true                  // FastPass
                    );
                    cliente.comprarTiquete(tiquete);
                    System.out.println("¡Tiquete comprado exitosamente!");
                    break;

                case 4:
                    System.out.println("\n--- Tiquetes Comprados ---");
                    if (cliente.getTiquetesComprados().isEmpty()) {
                        System.out.println("No ha comprado tiquetes aún.");
                    } else {
                        for (Tiquete t : cliente.getTiquetesComprados()) {
                            System.out.println(t.mostrarDetalles());
                        }
                    }
                    break;

                case 5:
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
