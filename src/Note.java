import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Note {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");



    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Заголовок: " + title + "\n" +
                "Вміст: " + content + "\n" +
                "Дата створення: " + createdAt + "\n";
    }
}
