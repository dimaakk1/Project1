import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteManager {
    private List<Note> notes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Створення нотатки
    public void createNote() {
        System.out.print("Введіть заголовок: ");
        String title = scanner.nextLine();
        System.out.print("Введіть вміст: ");
        String content = scanner.nextLine();
        notes.add(new Note(title, content));
        System.out.println("Нотатка створена!");
    }

    // Читання всіх нотаток
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

    // Оновлення нотатки
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

    // Видалення нотатки
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
}

