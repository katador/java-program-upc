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
        for (Solicitud solicitud : solicitudes) {
            
        }

        int opcion;
        /*do {
            System.out.println("=======================================");
            System.out.println("--------------REPORTES-----------------");
            System.out.println("=======================================");
            

            System.out.println();
            System.out.println("Seleccione el tipo de reporte:");
            System.out.println("Por soporte realizado......(1)");
            System.out.println("Por estado de soporte......(2)");
            System.out.println("Por tiempo de ejecución....(3)");
            System.out.println("Por tipo de servicio.......(4)");
            System.out.println("Por tipo de dispositivo....(5)");
            System.out.println("Por técnico...............(6)");
            System.out.print("Seleccione la opción que desea realizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    reportePorSoporteRealizado();
                    break;
                case 2:
                    reportePorEstadoSoporte();
                    break;
                case 3:
                    reportePorTiempoEjecucion();
                    break;
                case 4:
                    reportePorTipoServicio();
                    break;
                case 5:
                    reportePorTipoDispositivo();
                    break;
                case 6:
                    reportePorTecnico();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);*/
    }

    private static void reportePorSoporteRealizado() {
        System.out.println("Reporte por soporte realizado:");

    }

    private static void reportePorEstadoSoporte() {
        System.out.println("Reporte por estado de soporte:");

    }

    private static void reportePorTiempoEjecucion() {
        System.out.println("Reporte por tiempo de ejecución:");

    }

    private static void reportePorTipoServicio() {
        System.out.println("Reporte por tipo de servicio:");

    }

    private static void reportePorTipoDispositivo() {
        System.out.println("Reporte por tipo de dispositivo:");

    }

    private static void reportePorTecnico() {
        System.out.println("Reporte por técnico:");

    }
}
