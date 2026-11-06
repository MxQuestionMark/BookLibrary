import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> books;
    public Library(String n) {
        name = n;
        books = new ArrayList<Book>();
    }
}
