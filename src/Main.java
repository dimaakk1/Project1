import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Створення");
            System.out.println("2. Видалення");
            System.out.println("3. Зчитування");
            System.out.println("4. Оновлення");
            System.out.println("5. Пошук");
            System.out.println("6. Сортування");
            System.out.println("0. Вихід");

            System.out.print("Оберіть опцію: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Функція створення...");
                case 2 -> System.out.println("Функція видалення...");
                case 3 -> System.out.println("Функція зчитування...");
                case 4 -> System.out.println("Функція оновлення...");
                case 5 -> System.out.println("Функція пошуку...");
                case 6 -> System.out.println("Функція сортування...");
                case 0 -> {
                    System.out.println("Вихід з програми...");
                    running = false;
                }
                default -> System.out.println("Невідома команда!");
            }
        }
    }
}
