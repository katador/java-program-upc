package PROYECUPC;
import java.util.Scanner;
import java.util.List;

public class GestionDeSolicitud {
    static Scanner scanner = new Scanner(System.in);
    static List<Solicitud> solicitudes = RegistroDeSolicitud.solicitudes;

    public static void gestionar() {
        int opcion;
        do {
            System.out.println("==============================================");
            System.out.println("---------------GESTION DE SOLICITUDES---------");
            System.out.println("==============================================");
            System.out.println("Lista de todas las solicitudes............(1)");
            System.out.println("Buscar por código de solicitud............(2)");
            System.out.println("Cambiar de técnico asignado...............(3)");
            System.out.println("Actualizar estado de solicitud............(4)");
            System.out.println("Eliminar solicitud........................(5)");
            System.out.println("Volver al menú principal..................(0)");
            System.out.print("Seleccione la opción que desea realizar: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    listarSolicitudes();
                    break;
                case 2:
                    buscarSolicitud();
                    break;
                case 3:
                    cambiarTecnico();
                    break;
                case 4:
                    actualizarEstado();
                    break;
                case 5:
                    eliminarSolicitud();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private static void listarSolicitudes() {
        System.out.println("Lista de todas las solicitudes:");
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
        } else {
            for (Solicitud solicitud : solicitudes) {
                System.out.println(solicitud);
            }
        }
        Historial.agregarEntrada("Busqueda de listado");
    }
    private static void buscarSolicitud() {
        System.out.print("Ingrese el código de la solicitud: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrada = false;
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo() == codigo) {
                System.out.println("Solicitud encontrada:");
                System.out.println(solicitud);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Solicitud con código " + codigo + " no encontrada.");
        }
    }

    private static void cambiarTecnico() {
        System.out.print("Ingrese el código de la solicitud: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrada = false;
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo() == codigo) {
                System.out.print("Ingrese el DNI del nuevo técnico: ");
                String nuevoDniTecnico = scanner.nextLine();
                String antiguoDniTecnico = solicitud.getDniTecnico();
                solicitud.setDniTecnico(nuevoDniTecnico);
                System.out.println("Técnico asignado con éxito.");
                Historial.agregarEntrada("Cambio de técnico de " + antiguoDniTecnico + " a " + nuevoDniTecnico + " al " + solicitud.getCodigo());
                Historial.agregarEntrada("Tecnico asignado de " + nuevoDniTecnico + " al codigo " + solicitud.getCodigo());
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Solicitud con código " + codigo + " no encontrada.");
        }
    }

    public static void actualizarEstado() {
        System.out.print("Ingrese el código de la solicitud: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrada = false;
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo() == codigo) {
                System.out.print("Ingrese el nuevo estado de la solicitud: ");
                String nuevoEstado = scanner.nextLine();
                solicitud.setEstado(nuevoEstado);
                System.out.println("Estado actualizado con éxito.");
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Solicitud con código " + codigo + " no encontrada.");
        }
    }


    private static void eliminarSolicitud() {
        System.out.print("Ingrese el código de la solicitud: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean eliminada = false;
        for (int i = 0; i < solicitudes.size(); i++) {
            Solicitud solicitud = solicitudes.get(i);
            if (solicitud.getCodigo() == codigo) {
                solicitudes.remove(i);
                System.out.println("Solicitud eliminada con éxito.");
                Historial.agregarEntrada("Se eliminó la solicitud " + codigo);
                eliminada = true;
                break;
            }
        }

        if (!eliminada) {
            System.out.println("Solicitud con código " + codigo + " no encontrada.");
        }
    }

}


