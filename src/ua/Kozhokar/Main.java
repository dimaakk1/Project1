package ua.Kozhokar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager manager = new NoteManager();
        boolean running = true;

        manager.loadNotesFromFile("notes.json");

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Створити нотатку");
            System.out.println("2. Переглянути нотатки");
            System.out.println("3. Оновити нотатку");
            System.out.println("4. Видалити нотатку");
            System.out.println("5. Сортувати нотатки");
            System.out.println("6. Шукати нотатку");
            System.out.println("7. Зберегти зміни");
            System.out.println("0. Вихід");

            System.out.print("Оберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Введіть заголовок: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть зміст: ");
                    String content = scanner.nextLine();
                    manager.createNote(title, content);
                }
                case 2 -> manager.readNotes();
                case 3 -> {
                    System.out.print("Введіть ID нотатки: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть новий заголовок: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Введіть новий зміст: ");
                    String newContent = scanner.nextLine();
                    manager.updateNote(id, newTitle, newContent);
                }
                case 4 -> {
                    System.out.print("Введіть ID нотатки для видалення: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    manager.deleteNote(id);
                }
                case 5 -> {
                    System.out.println("Оберіть критерій сортування: 1 - за заголовком, 2 - за датою створення");
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    manager.sortNotes(option);
                }
                case 6 -> {
                    System.out.println("Оберіть критерій пошуку: 1 - за заголовком, 2 - за датою створення (yyyy-MM-dd HH:mm)");
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введіть пошуковий запит: ");
                    String query = scanner.nextLine();
                    manager.searchNotes(option, query);
                }
                case 7 -> {
                    manager.saveNotesToFile("notes.json");
                }
                case 0 -> {
                    System.out.println("Вихід з програми...");
                    running = false;
                }
                default -> System.out.println("Некоректний вибір!");
            }
        }
        scanner.close();
    }
}




