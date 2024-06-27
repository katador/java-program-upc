package PROYECUPC;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistroDeSolicitud {
    static List<Solicitud> solicitudes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void registrar() {
        System.out.println("=======================================");
        System.out.println("---------REGISTRO DE SOLICITUD---------");
        System.out.println("=======================================");


        System.out.print("Escriba nombre de cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.println("Indique tipo de servicio");
        System.out.println("Reparación...............(1)");
        System.out.println("Instalación..............(2)");
        System.out.println("Configuración............(3)");
        System.out.print(": ");
        int tipoServicio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Indique dispositivo");
        System.out.println("Impresora...............(1)");
        System.out.println("PC......................(2)");
        System.out.println("Laptop..................(3)");
        System.out.println("Otro....................(4)");
        System.out.print(":");
        int tipoDispositivo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite la descripción del problema: ");
        String descripcionProblema = scanner.nextLine();

        Solicitud solicitud = new Solicitud(nombreCliente, tipoServicio, tipoDispositivo, descripcionProblema);
        solicitudes.add(solicitud);

        System.out.println("Solicitud registrada con éxito: ");
        System.out.println(solicitud);
    }
}
