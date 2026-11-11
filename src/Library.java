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
    public boolean validNumber(String s) {
        try {
            int num = Integer.parseInt(s);
            return (num >= 0 && num < books.size());
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
