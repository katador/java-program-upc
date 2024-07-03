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
        System.out.println("==============================================");
        System.out.println("------------HISTORIAL ----------");
        System.out.println("==============================================");
        System.out.println(historial.toString());
    }
}
