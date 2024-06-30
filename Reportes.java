package PROYECUPC;
import java.util.List;
import java.util.Scanner;

public class Reportes {
    static Scanner scanner = new Scanner(System.in);
    static List<Solicitud> solicitudes = RegistroDeSolicitud.solicitudes;

    public static void generarReportes() {
        String title = "REPORTES";
        String[] mainMenuOptions = {
            "Seleccione el tipo de reporte:",
            "Lista de Soportes........................(1)",
            "Lista de Soportes Completados............(2)",
            "Lista de Soportes Pendientes.............(3)",
            "Volver al menú principal.................(0)"
        };

        int opcion;
        do {
            ConsoleUtils.clearConsole();
            ConsoleUtils.printFrame(title, mainMenuOptions);
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
                    ConsoleUtils.clearConsole();
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    ConsoleUtils.clearConsole();
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void listaSoportes() {
        ConsoleUtils.clearConsole();
        String title = "LISTA DE SOPORTES";
        String[] options = solicitudes.isEmpty() ? 
            new String[]{"No hay solicitudes registradas."} : 
            solicitudes.stream().map(Solicitud::toString).toArray(String[]::new);
        ConsoleUtils.printFrame(title, options);
        esperarEnter();
    }

    private static void listaSoportesCompletados() {
        ConsoleUtils.clearConsole();
        String title = "LISTA DE SOPORTES COMPLETADOS";
        List<String> completados = solicitudes.stream()
            .filter(solicitud -> solicitud.getEstado().trim().equals("Completado"))
            .map(Solicitud::toString)
            .toList();
        String[] options = completados.isEmpty() ? 
            new String[]{"No hay solicitudes completadas."} : 
            completados.toArray(new String[0]);
        ConsoleUtils.printFrame(title, options);
        esperarEnter();
    }

    private static void listaSoportesPendientes() {
        ConsoleUtils.clearConsole();
        String title = "LISTA DE SOPORTES PENDIENTES";
        List<String> pendientes = solicitudes.stream()
            .filter(solicitud -> solicitud.getEstado().trim().equals("Registrada"))
            .map(Solicitud::toString)
            .toList();
        String[] options = pendientes.isEmpty() ? 
            new String[]{"No hay solicitudes pendientes."} : 
            pendientes.toArray(new String[0]);
        ConsoleUtils.printFrame(title, options);
        esperarEnter();
    }

    private static void esperarEnter() {
        System.out.println("Presiona Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
