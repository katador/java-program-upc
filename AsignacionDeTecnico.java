package PROYECUPC;
import java.util.List;
import java.util.Scanner;

public class AsignacionDeTecnico {

    static Scanner scanner = new Scanner(System.in);
    static List<Solicitud> solicitudes = RegistroDeSolicitud.solicitudes;

    public static void asignar() {
        String title = "ASIGNACION DE TECNICO";
        String[] options = {
            "Escriba el código de la solicitud"
        };

        ConsoleUtils.printFrame(title, options);
        System.out.print(": ");
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

        ConsoleUtils.clearConsole();
        String[] dniOptions = {
            "Solicitud: " + codigoSolicitud,
            "Escriba el DNI del técnico"
        };
        ConsoleUtils.printFrame(title, dniOptions);
        System.out.print(": ");
        String dniTecnico = scanner.nextLine();

        ConsoleUtils.clearConsole();
        String[] prioridadOptions = {
            "Solicitud: " + codigoSolicitud,
            "DNI del técnico: " + dniTecnico,
            "----------------------------------------------",
            "Indique el nivel de prioridad",
            "----------------------------------------------",
            "Alto.......................................(1)",
            "Intermedio.................................(2)",
            "Bajo.......................................(3)"
        };
        ConsoleUtils.printFrame(title, prioridadOptions);
        System.out.print(": ");
        int nivelPrioridad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        ConsoleUtils.clearConsole();
        String[] asistenciaOptions = {
            "Solicitud: " + codigoSolicitud,
            "DNI del técnico: " + dniTecnico,
            "Nivel de prioridad: " + nivelPrioridad,
            "----------------------------------------------",
            "Indique el tipo de asistencia",
            "----------------------------------------------",
            "Remoto virtual.............................(1)",
            "Telefónico.................................(2)",
            "Presencial.................................(3)"
        };
        ConsoleUtils.printFrame(title, asistenciaOptions);
        System.out.print(": ");
        int tipoAsistencia = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        ConsoleUtils.clearConsole();
        String[] indicacionesOptions = {
            "Solicitud: " + codigoSolicitud,
            "DNI del técnico: " + dniTecnico,
            "Nivel de prioridad: " + nivelPrioridad,
            "Tipo de asistencia: " + tipoAsistencia,
            "----------------------------------------------",
            "Escriba  alguna indicación para el técnico"
        };
        ConsoleUtils.printFrame(title, indicacionesOptions);
        System.out.print(": ");
        String indicaciones = scanner.nextLine();

        solicitud.asignarTecnico(dniTecnico, nivelPrioridad, tipoAsistencia, indicaciones);
        ConsoleUtils.clearConsole();
        String[] finalOptions = {
            "Solicitud asignada con éxito",
            solicitud.toString()
        };
        ConsoleUtils.printFrame(title, finalOptions);
        System.out.println(solicitud);
        System.out.println("Presiona Enter para continuar...");

        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
