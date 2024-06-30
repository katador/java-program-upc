package PROYECUPC;

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
        int width = 40;
        String horizontalBorder = "+" + "-".repeat(width - 2) + "+";
        System.out.println(horizontalBorder);
        System.out.printf("| %-36s |\n", title);
        System.out.println(horizontalBorder);

        for (String option : options) {
            System.out.printf("| %-36s |\n", option);
        }

        System.out.println(horizontalBorder);
    }
}