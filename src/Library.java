public class Library {

    private Book[] books;
    private int count;

    // Constructor
    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // Add book to array
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Display all books
    public void displayBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    // Search book by title
    public Book searchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Borrow book by title
    public void borrowBook(String title) {
        Book book = searchByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable()) {
            System.out.println("Book is already borrowed.");
        } else {
            book.borrowBook();
            System.out.println("Book borrowed successfully.");
        }
    }

    // Return book by title
    public void returnBook(String title) {
        Book book = searchByTitle(title);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable()) {
            System.out.println("Book was not borrowed.");
        } else {
            book.returnBook();
            System.out.println("Book returned successfully.");
        }
    }
}
