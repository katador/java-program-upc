package PROYECUPC;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GestionDeSolicitud {
    
    private Scanner scanner;
    private List<Solicitud> solicitudes;
   
    public GestionDeSolicitud() {
        this.scanner = new Scanner(System.in);
        this.solicitudes = new ArrayList<>();
     
    }

    public void gestionar() {
        int opcion;
        do {
            String title = "GESTION DE SOLICITUDES";
            String[] options = {
                "Lista de todas las solicitudes............(1)",
                "Buscar por código de solicitud............(2)",
                "Cambiar de técnico asignado...............(3)",
                "Completar estado solicitud................(4)",
                "Eliminar solicitud........................(5)",
                "Volver al menú principal..................(0)"
            };
            ConsoleUtils.printFrame(title, options);
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
                    ConsoleUtils.clearConsole();
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    ConsoleUtils.clearConsole();
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private void listarSolicitudes() {
        ConsoleUtils.clearConsole();
        String title = "LISTA DE SOLICITUDES";
        String[] options = solicitudes.isEmpty() ? 
            new String[]{"No hay solicitudes registradas."} : 
            solicitudes.stream().map(Solicitud::toString).toArray(String[]::new);
        ConsoleUtils.printFrame(title, options);
        Historial.agregarEntrada("Busqueda de listado");
        esperarEnter();
    }

    private void buscarSolicitud() {
        ConsoleUtils.clearConsole();
        String title = "BUSCAR SOLICITUD";
        String[] options = {"Ingrese el código de la solicitud"};
        ConsoleUtils.printFrame(title, options);
        System.out.print(": ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrada = false;
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo() == codigo) {
                String[] result = {"Solicitud encontrada:", solicitud.toString()};
                ConsoleUtils.printFrame(title, result);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            String[] result = {"Solicitud con código " + codigo + " no encontrada."};
            ConsoleUtils.printFrame(title, result);
        }
        esperarEnter();
    }

    private void cambiarTecnico() {
        ConsoleUtils.clearConsole();
        String title = "CAMBIAR TECNICO";
        String[] options = {"Ingrese el código de la solicitud"};
        ConsoleUtils.printFrame(title, options);
        System.out.print(": ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrada = false;
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo() == codigo) {
                ConsoleUtils.clearConsole();
                String[] dniOptions = {
                    "Solicitud: " + codigo,
                    "Ingrese el DNI del nuevo técnico"
                };
                ConsoleUtils.printFrame(title, dniOptions);
                System.out.print(": ");
                String nuevoDniTecnico = scanner.nextLine();
                String antiguoDniTecnico = solicitud.getDniTecnico();
                solicitud.setDniTecnico(nuevoDniTecnico);
                String[] successMessage = {"Técnico asignado con éxito."};
                ConsoleUtils.printFrame(title, successMessage);
                Historial.agregarEntrada("Cambio de técnico de " + antiguoDniTecnico + " a " + nuevoDniTecnico + " al " + solicitud.getCodigo());
                Historial.agregarEntrada("Tecnico asignado de " + nuevoDniTecnico + " al codigo " + solicitud.getCodigo());
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            String[] result = {"Solicitud con código " + codigo + " no encontrada."};
            ConsoleUtils.printFrame(title, result);
        }
        esperarEnter();
    }

    public void actualizarEstado() {
        ConsoleUtils.clearConsole();
        String title = "ACTUALIZAR ESTADO";
        String[] options = {"Ingrese el código de la solicitud"};
        ConsoleUtils.printFrame(title, options);
        System.out.print(": ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean encontrada = false;
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getCodigo() == codigo) {
                solicitud.setEstado("Completado");
                String[] successMessage = {"Servicio completado con éxito."};
                ConsoleUtils.printFrame(title, successMessage);
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            String[] result = {"Solicitud con código " + codigo + " no encontrada."};
            ConsoleUtils.printFrame(title, result);
        }
        esperarEnter();
    }

    private void eliminarSolicitud() {
        ConsoleUtils.clearConsole();
        String title = "ELIMINAR SOLICITUD";
        String[] options = {"Ingrese el código de la solicitud"};
        ConsoleUtils.printFrame(title, options);
        System.out.print(": ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean eliminada = false;
        for (int i = 0; i < solicitudes.size(); i++) {
            Solicitud solicitud = solicitudes.get(i);
            if (solicitud.getCodigo() == codigo) {
                solicitudes.remove(i);
                String[] successMessage = {"Solicitud eliminada con éxito."};
                ConsoleUtils.printFrame(title, successMessage);
                Historial.agregarEntrada("Se eliminó la solicitud " + codigo);
                eliminada = true;
                break;
            }
        }

        if (!eliminada) {
            String[] result = {"Solicitud con código " + codigo + " no encontrada."};
            ConsoleUtils.printFrame(title, result);
        }
        esperarEnter();
    }

    private void esperarEnter() {
        System.out.println("Presiona Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
