package PROYECUPC;
import java.util.List;
import java.util.Scanner;

public class Reportes {
    static Scanner scanner = new Scanner(System.in);
    static List<Solicitud> solicitudes = RegistroDeSolicitud.solicitudes;

    public static void generarReportes() {

        System.out.println("=======================================");
        System.out.println("--------------REPORTES-----------------");
        System.out.println("=======================================");
        System.out.println();
        /*for (Solicitud solicitud : solicitudes) {
            System.out.println(solicitud.toString());
        }
        System.out.println();*/

        int opcion;
        do {
            System.out.println("Seleccione el tipo de reporte:");
            System.out.println("Lista de Soportes......(1)");
            System.out.println("Lista de Soportes Completados......(2)");
            System.out.println("Lista de Soportes Pendientes....(3)");
            System.out.println("Volver al menú principal..................(0)");
            System.out.print("Seleccione la opción que desea realizar: ");
        
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    listaSoportes();
                    break;
                case 2:
                    listaSoportesCompletados();
                    break;
                case 3:
                    listaSoportesPendientes();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void listaSoportes() {
        System.out.println();
        for (Solicitud solicitud : solicitudes) {
            System.out.println(solicitud.toString());
        }
        System.out.println();

    }

    private static void listaSoportesCompletados() {
        System.out.println();
        for (Solicitud solicitud : solicitudes) {
            String estado = solicitud.getEstado();
            if(estado.trim() == "Completado"){
                System.out.println(solicitud.toString());
            }
        }
        System.out.println();

    }

    private static void listaSoportesPendientes() {
        System.out.println();
        for (Solicitud solicitud : solicitudes) {
            String estado = solicitud.getEstado();
            if(estado.trim() == "Registrada"){
                System.out.println(solicitud.toString());
            }
        }
        System.out.println();
    }
}
