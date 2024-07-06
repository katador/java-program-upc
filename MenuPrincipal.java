package PROYECUPC;
import java.util.Scanner;

public class MenuPrincipal {
  
    private Scanner scanner;
    private RegistroDeSolicitud registroDeSolicitud;
    private GestionDeSolicitud gestionDeSolicitud;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
        gestionDeSolicitud = new GestionDeSolicitud();
        registroDeSolicitud = new RegistroDeSolicitud(gestionDeSolicitud);
   
    }

    public void mostrarMenu() {
        int opcion;

        do {
            
            String title = "MENU PRINCIPAL";
            String[] options = {
                "Registro de solicitud......................(1)",
                "Asignación de técnico......................(2)",
                "Gestión de solicitud.......................(3)",
                "Historial..................................(4)",
                "Reportes...................................(5)",
                "Salir......................................(6)"
            };

            ConsoleUtils.printFrame(title, options);

            System.out.print("Indique una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            ConsoleUtils.clearConsole();

            switch (opcion) {
                case 1:
                    registroDeSolicitud.registrar();
                    break;
                case 2:
                    AsignacionDeTecnico.asignar();
                    break;
                case 3:
                    gestionDeSolicitud.gestionar();
                    break;
                case 4:
                    Historial.verHistorial();
                    break;
                case 5:
                    Reportes.generarReportes();
                    break;
                
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }
}

