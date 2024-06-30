package PROYECUPC;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUtils {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printFrame(String title, String[] options) {
        clearConsole();
        int width = 50;
        String horizontalBorder = "+" + "-".repeat(width - 2) + "+";
        System.out.println(horizontalBorder);
        System.out.printf("| %-46s |\n", title);
        System.out.println(horizontalBorder);

        for (String option : options) {
            printWrappedLine(option, width);
        }

        System.out.println(horizontalBorder);
    }

    private static void printWrappedLine(String text, int width) {
        int maxLength = width - 4; // Ancho del contenido (excluyendo los bordes)
        while (text.length() > maxLength) {
            int spaceIndex = text.lastIndexOf(' ', maxLength);
            if (spaceIndex == -1) spaceIndex = maxLength;
            System.out.printf("| %-46s |\n", text.substring(0, spaceIndex));
            text = text.substring(spaceIndex).trim();
        }
        System.out.printf("| %-46s |\n", text);
    }

}