import java.io.EOFException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("libs.data"));
//ObjectInputStream in = new ObjectInputStream(new FileInputStream("libs.data"));

public class Library implements  Serializable {
    private String name;
    private ArrayList<Book> books;
    private static ArrayList<Library> libs = new ArrayList<>();
    public static void update(Library lib) {
        getLibs();
        try {
            boolean found = false;
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/libs.data"));
            for (Library l : libs) {
                if (l.getName().equals(lib.getName())) {
                    out.writeObject(lib);
                    found = true;
                } else {
                    out.writeObject(l);
                }
            }
            if (!found) {
                out.writeObject(lib);
            }
            out.close();
        } catch (Exception e) {}
        getLibs();
    }
    public static ArrayList<Library> getLibs() {
        libs = new ArrayList<>();
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/libs.data"));
            try {
                while (true) {
                    libs.add((Library) in.readObject());
                }
            } catch (ClassNotFoundException | EOFException e1) {
                in.close();
            }
        } catch (FileNotFoundException e) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/libs.data"));
            } catch (Exception e1) {}
            return new ArrayList<Library>();
        } catch (IOException e) {}
        return libs;
    }
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
