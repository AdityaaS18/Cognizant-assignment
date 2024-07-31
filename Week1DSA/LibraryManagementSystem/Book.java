package Week1DSA.LibraryManagementSystem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}
class Library {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        Book[] books = new Book[numBooks];

        for (int i = 0; i < numBooks; i++) {
            System.out.print("Enter book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            books[i] = new Book(bookId, title, author);
        }

        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.print("Enter title to search: ");
        String searchTitle = scanner.nextLine();

        Book foundBookLinear = findBookByTitleLinear(books, searchTitle);
        if (foundBookLinear != null) {
            System.out.println("Found book using linear search: " + foundBookLinear);
        } else {
            System.out.println("Book not found using linear search");
        }

        Book foundBookBinary = findBookByTitleBinary(books, searchTitle);
        if (foundBookBinary != null) {
            System.out.println("Found book using binary search: " + foundBookBinary);
        } else {
            System.out.println("Book not found using binary search");
        }
    }

    public static Book findBookByTitleLinear(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    public static Book findBookByTitleBinary(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle)); // sort books by title
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (books[mid].getTitle().toLowerCase().equals(title.toLowerCase())) {
                return books[mid];
            } else if (books[mid].getTitle().toLowerCase().compareTo(title.toLowerCase()) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}

