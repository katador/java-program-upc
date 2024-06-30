package PROYECUPC;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historial {
    private static StringBuilder historial = new StringBuilder();

    public static void agregarEntrada(String entrada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formatter);
        historial.append(fechaHora).append(" | ").append(entrada).append("\n");
    }

    public static void verHistorial() {
        String title = "HISTORIAL";
        String[] options = historial.length() == 0 ? 
            new String[]{"No hay entradas en el historial."} : 
            historial.toString().split("\n");
        ConsoleUtils.printFrame(title, options);
        System.out.println("Presiona Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
