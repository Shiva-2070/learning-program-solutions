class Book {
    String id;
    String title;
    String author;
    
    Book(String i, String t, String a) {
        id = i;
        title = t;
        author = a;
    }
}

public class Library {
    Book[] books;
    int count;
    
    Library() {
        books = new Book[100];
        count = 0;
    }
    
    // Linear search
    Book searchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equals(title)) {
                return books[i];
            }
        }
        return null;
    }
    
    // Binary search (needs sorted array)
    Book binarySearch(String title) {
        int left = 0;
        int right = count-1;
        
        while (left <= right) {
            int mid = (left + right)/2;
            int cmp = title.compareTo(books[mid].title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) right = mid-1;
            else left = mid+1;
        }
        return null;
    }
    
    void addBook(String id, String title, String author) {
        if (count < books.length) {
            books[count++] = new Book(id, title, author);
        }
    }
    
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("B001", "Java Basics", "A. Smith");
        lib.addBook("B002", "Data Structures", "B. Lee");
        
        Book found = lib.searchByTitle("Java Basics");
        if (found != null) {
            System.out.println("Found: " + found.author);
        }
    }
}