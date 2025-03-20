package ua.Kozhokar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NoteManager {
    private List<Note> notes = new ArrayList<>();
    private final Gson gson;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public NoteManager() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
        gsonBuilder.setPrettyPrinting();
        gson = gsonBuilder.create();
    }

    public void createNote(String title, String content) {
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

    public void updateNote(int index, String newTitle, String newContent) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setTitle(newTitle);
            notes.get(index).setContent(newContent);
            System.out.println("Нотатка оновлена!");
        } else {
            System.out.println("Некоректний ID.");
        }
    }

    public void deleteNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Нотатка видалена!");
        } else {
            System.out.println("Некоректний ID.");
        }
    }

    public void sortNotes(int option) {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток для сортування.");
            return;
        }

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

    public void searchNotes(int option, String query) {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток для пошуку.");
            return;
        }

        List<Note> results = switch (option) {
            case 1 -> notes.stream()
                    .filter(note -> note.getTitle().toLowerCase().contains(query.toLowerCase()))
                    .toList();
            case 2 -> {
                try {
                    LocalDateTime searchDate = LocalDateTime.parse(query, formatter);
                    yield notes.stream()
                            .filter(note -> note.getCreatedAt().toLocalDate().equals(searchDate.toLocalDate()))
                            .toList();
                } catch (Exception e) {
                    System.out.println("Некоректний формат дати.");
                    yield new ArrayList<>();
                }
            }
            default -> {
                System.out.println("Некоректний вибір!");
                yield new ArrayList<>();
            }
        };

        displaySearchResults(results);
    }

    private void displaySearchResults(List<Note> results) {
        if (results.isEmpty()) {
            System.out.println("Нотатки не знайдено.");
        } else {
            System.out.println("Знайдені нотатки:");
            results.forEach(System.out::println);
        }
    }

    public void saveNotesToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(notes, writer);  // Серіалізація нотаток в JSON файл
            System.out.println("Нотатки збережені у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні нотаток: " + e.getMessage());
        }
    }

    public void loadNotesFromFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Note[] loadedNotes = gson.fromJson(reader, Note[].class);
            notes = new ArrayList<>(Arrays.asList(loadedNotes));
            System.out.println("Нотатки завантажено з файлу.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні нотаток: " + e.getMessage());
        }
    }
}

