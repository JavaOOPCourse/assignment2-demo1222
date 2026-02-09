import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // capacity from user (or set a fixed one like 10)
        System.out.print("Enter library capacity: ");
        int capacity = readInt(sc);

        Library library = new Library(capacity);

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            int choice = readInt(sc);

            switch (choice) {
                case 1: { // Add book
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");
                    int year = readInt(sc);

                    library.addBook(new Book(title, author, year));
                    break;
                }

                case 2: { // Add e-book
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");
                    int year = readInt(sc);

                    System.out.print("File size (MB): ");
                    double fileSize = readDouble(sc);

                    library.addBook(new EBook(title, author, year, fileSize));
                    break;
                }

                case 3: { // Display all books
                    library.displayBooks();
                    break;
                }

                case 4: { // Search by title
                    System.out.print("Enter title to search: ");
                    String title = sc.nextLine();

                    Book found = library.searchByTitle(title);
                    if (found == null) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.println(found);
                    }
                    break;
                }

                case 5: { // Borrow book
                    System.out.print("Enter title to borrow: ");
                    String title = sc.nextLine();
                    library.borrowBook(title);
                    break;
                }

                case 6: { // Return book
                    System.out.print("Enter title to return: ");
                    String title = sc.nextLine();
                    library.returnBook(title);
                    break;
                }

                case 7: { // Exit
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                }

                default:
                    System.out.println("Invalid option. Try again.");
            }

            System.out.println();
        }

        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== Library Menu =====");
        System.out.println("1. Add book");
        System.out.println("2. Add e-book");
        System.out.println("3. Display all books");
        System.out.println("4. Search book by title");
        System.out.println("5. Borrow book");
        System.out.println("6. Return book");
        System.out.println("7. Exit");
    }

    // Safe integer input (avoids Scanner newline issues)
    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    // Safe double input
    private static double readDouble(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
