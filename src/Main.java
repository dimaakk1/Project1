import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager manager = new NoteManager();
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Створити нотатку");
            System.out.println("2. Переглянути нотатки");
            System.out.println("3. Оновити нотатку");
            System.out.println("4. Видалити нотатку");
            System.out.println("5. Сортувати нотатки");
            System.out.println("6. Шукати нотатку");
            System.out.println("0. Вихід");

            System.out.print("Оберіть опцію: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> manager.createNote();
                case 2 -> manager.readNotes();
                case 3 -> manager.updateNote();
                case 4 -> manager.deleteNote();
                case 5 -> manager.sortNotes();
                case 6 -> manager.searchNotes();
                case 0 -> {
                    System.out.println("Вихід з програми...");
                    running = false;
                }
                default -> System.out.println("Некоректний вибір!");
            }
        }
    }
}
