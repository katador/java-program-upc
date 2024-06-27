package PROYECUPC;
import java.util.List;
import java.util.Scanner;

public class AsignacionDeTecnico {

    static Scanner scanner = new Scanner(System.in);
    static List<Solicitud> solicitudes = RegistroDeSolicitud.solicitudes;

    public static void asignar() {
        System.out.println("=======================================");
        System.out.println("----------ASIGNACION DE TECNICO--------");
        System.out.println("=======================================");

        System.out.print("Escriba el código de la solicitud: ");
        int codigoSolicitud = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Solicitud solicitud = null;
        for (Solicitud s : solicitudes) {
            if (s.getCodigo() == codigoSolicitud) {
                solicitud = s;
                break;
            }
        }

        if (solicitud == null) {
            System.out.println("Código de solicitud no válido.");
            return;
        }

        System.out.println("Escriba el DNI del técnico");
        System.out.print(": ");
        String dniTecnico = scanner.nextLine();

        System.out.println("Indique el nivel de prioridad");
        System.out.println("Alto............(1)");
        System.out.println("Intermedio......(2)");
        System.out.println("Bajo............(3)");
        System.out.print(": ");
        int nivelPrioridad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Indique el tipo de asistencia");
        System.out.println("Remoto virtual...........(1)");
        System.out.println("Telefónico...............(2)");
        System.out.println("Presencial...............(3)");
        System.out.print(": ");
        int tipoAsistencia = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Escriba si tiene alguna indicación para el técnico: ");
        System.out.print(": ");
        String indicaciones = scanner.nextLine();

        solicitud.asignarTecnico(dniTecnico, nivelPrioridad, tipoAsistencia, indicaciones);
        System.out.println(solicitud);
    }
}

