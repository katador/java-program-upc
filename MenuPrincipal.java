package PROYECUPC;
import java.util.Scanner;

public class MenuPrincipal {
    static Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("=======================================");
            System.out.println("------------MENU PRINCIPAL-------------");
            System.out.println("=======================================");
            System.out.println("Registro de solicitud.............(1)");
            System.out.println("Asignación de técnico.............(2)");
            System.out.println("Gestión de solicitud..............(3)");
            System.out.println("Historial.........................(4)");
            System.out.println("Reportes..........................(5)");
            System.out.print("Indique una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    RegistroDeSolicitud.registrar();
                    break;
                case 2:
                    AsignacionDeTecnico.asignar();
                    break;
                case 3:
                    GestionDeSolicitud.gestionar();
                    break;
                case 4:
                    Historial.verHistorial();
                    break;
                case 5:
                    Reportes.generarReportes();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }
}

