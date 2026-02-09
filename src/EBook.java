public class EBook extends Book {

    private double fileSize; // in MB

    // Constructor using super()
    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
        this.fileSize = fileSize;
    }

    // Override toString()
    @Override
    public String toString() {
        return "[E-Book] Title: " + getTitle()
                + ", Author: " + getAuthor()
                + ", Year: " + getYear()
                + ", File Size: " + fileSize + "MB"
                + ", Available: " + isAvailable();
    }
}
