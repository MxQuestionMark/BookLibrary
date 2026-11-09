import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;
    public Library(String n) {
        name = n;
        books = new ArrayList<Book>();
    }
    public String getName() {
        return name;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void addBook(Book b) {
        books.add(b);
    }
}
