import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {
    public static int linearSearchByTitle(Book[] books, String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1; 
    }

    public static int binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "The Lord of the Rings", "J.R.R. Tolkien"),
                new Book(2, "The fault in our stars", "John Green"),
                new Book(3, "1984", "George Orwell")
        };

        int index = linearSearchByTitle(books, "The fault in our stars");
        if (index != -1) {
            System.out.println("Book found at index: " + index);
        } else {
            System.out.println("Book not found");
        }

        Arrays.sort(books, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
        index = binarySearchByTitle(books, "1984");
        if (index != -1) {
            System.out.println("Book found at index: " + index);
        } else {
            System.out.println("Book not found");
        }
    }
}
