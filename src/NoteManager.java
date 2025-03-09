import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;

public class NoteManager {
    private List<Note> notes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createNote() {
        System.out.print("Введіть заголовок: ");
        String title = scanner.nextLine();
        System.out.print("Введіть вміст: ");
        String content = scanner.nextLine();
        notes.add(new Note(title, content));
        System.out.println("Нотатка створена!");
    }

    public void readNotes() {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток.");
            return;
        }
        for (int i = 0; i < notes.size(); i++) {
            System.out.println("ID: " + i);
            System.out.println(notes.get(i));
        }
    }

    public void updateNote() {
        readNotes();
        if (notes.isEmpty()) return;

        System.out.print("Введіть ID нотатки для оновлення: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < notes.size()) {
            System.out.print("Новий заголовок: ");
            String newTitle = scanner.nextLine();
            System.out.print("Новий вміст: ");
            String newContent = scanner.nextLine();
            notes.get(index).setTitle(newTitle);
            notes.get(index).setContent(newContent);
            System.out.println("Нотатка оновлена!");
        } else {
            System.out.println("Некоректний ID.");
        }
    }

    public void deleteNote() {
        readNotes();
        if (notes.isEmpty()) return;

        System.out.print("Введіть ID нотатки для видалення: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Нотатка видалена!");
        } else {
            System.out.println("Некоректний ID.");
        }
    }

    public void sortNotes() {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток для сортування.");
            return;
        }

        System.out.println("Оберіть спосіб сортування:");
        System.out.println("1. За заголовком (A-Z)");
        System.out.println("2. За датою створення (від нових до старих)");
        System.out.print("Введіть варіант: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // очищення буфера

        switch (option) {
            case 1 -> notes.sort(Comparator.comparing(Note::getTitle));
            case 2 -> notes.sort(Comparator.comparing(Note::getCreatedAt).reversed());
            default -> {
                System.out.println("Некоректний вибір!");
                return;
            }
        }

        System.out.println("Нотатки після сортування:");
        readNotes();
    }
}

