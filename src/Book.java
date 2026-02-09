import java.util.Objects;

public class Book {

    // Fields must be private
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    // Parameterized constructor (sets isAvailable = true)
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true;
    }

    // Copy constructor
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.year = other.year;
        this.isAvailable = other.isAvailable;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Borrow logic: only borrow if available
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    // Return logic: make it available again
    public void returnBook() {
        isAvailable = true;
    }

    // toString() in required format
    @Override
    public String toString() {
        return "Title: " + title
                + ", Author: " + author
                + ", Year: " + year
                + ", Available: " + isAvailable;
    }

    // equals(): title, author, year must match
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;

        Book other = (Book) obj;
        return year == other.year
                && Objects.equals(title, other.title)
                && Objects.equals(author, other.author);
    }
}
