package PROYECUPC;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroDeSolicitud {
    static List<Solicitud> solicitudes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void registrar() {
        while (true) {
            String title = "REGISTRO DE SOLICITUD";
            String[] options = {
                "Escriba nombre de cliente",
                "Regresar al menú principal.................(6)"
            };

            ConsoleUtils.printFrame(title, options);

            System.out.print("Escriba nombre de cliente: ");
            String nombreCliente = scanner.nextLine().trim();
            if (nombreCliente.equals("6")) {
                return; // Regresar al menú principal
            }
            if (nombreCliente.isEmpty()) {
                System.out.println("El nombre del cliente no puede estar vacío. Presiona Enter para continuar...");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                continue;
            }

            ConsoleUtils.clearConsole();
            String[] servicios = {
                "Nombre de Cliente: "+nombreCliente,
                "----------------------------------------------",
                "TIPO DE SERVICIO                   ",
                "----------------------------------------------",
                "Reparación.................................(1)",
                "Instalación................................(2)",
                "Configuración..............................(3)"
            };
            ConsoleUtils.printFrame("REGISTRO DE SOLICITUD", servicios);
            System.out.print("Seleccione una opción: ");
            int tipoServicio = scanner.nextInt();
            scanner.nextLine();

            ConsoleUtils.clearConsole();
            String[] dispositivos = {
                "Nombre de Cliente: "+nombreCliente,
                "Tipo de servicio: "+tipoServicio,
                "----------------------------------------------",
                "TIPO DE DISPOSITIVO                ",
                "----------------------------------------------",
                "Impresora..................................(1)",
                "PC.........................................(2)",
                "Laptop.....................................(3)",
                "Otro.......................................(4)"
            };
            ConsoleUtils.printFrame("REGISTRO DE SOLICITUD", dispositivos);
            System.out.print("Seleccione una opción ");

            int tipoDispositivo = scanner.nextInt();
            scanner.nextLine();
            

            ConsoleUtils.clearConsole();

            String[] descripcion = {
                "Nombre de Cliente: "+nombreCliente,
                "Tipo de servicio: "+tipoServicio,
                "Tipo de dispositivo: "+tipoDispositivo,
                "----------------------------------------------",
                "DESCRIPCION DEL PROBLEMA           ",

            };
            ConsoleUtils.printFrame("REGISTRO DE SOLICITUD", descripcion);
            System.out.println("Digite la descripción del problema: ");

           String descripcionProblema = scanner.nextLine().trim();
            System.out.println("Presione enter para continuar");
           scanner.nextLine();


            Solicitud solicitud = new Solicitud(nombreCliente, tipoServicio, tipoDispositivo, descripcionProblema);
            solicitudes.add(solicitud);

            ConsoleUtils.clearConsole();


            String[] solicitudLine = {
                "Nombre de Cliente: "+nombreCliente,
                "Tipo de servicio: "+tipoServicio,
                "Tipo de dispositivo: "+tipoDispositivo,
                "Descripcion: "+descripcionProblema,
                "----------------------------------------------",
                "Solicitud registrada con éxito  ",
                "----------------------------------------------"
            };
            ConsoleUtils.printFrame("REGISTRO DE SOLICITUD", solicitudLine);
            System.out.println(solicitud);
            System.out.println("Presiona Enter para continuar...");

        
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        }
    }
 
}
