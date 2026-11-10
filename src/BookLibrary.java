import java.util.ArrayList;
public class BookLibrary {
  public static void main(String[] args) {
    ArrayList<Library> libs = new ArrayList<Library>();
    Library currentLib = new Library(null);
    
    IO.println("Hello and welcome to the BookLibrary program!");
    boolean newUser = true;
    boolean cont = true;
    
    // Loop to figure out if the user already has a library or should make a new one.
    while (cont) {
      String name = IO.readln("What is your name? ");
      for (Library l : libs) {
        // Library already exists.
        if (name.equals(l.getName())) {
          newUser = false;
          currentLib = l;
          cont = false;
        }
      }
      if (newUser) {
        // Library doesn't already exist
        if (IO.readln("That name doesn't currently have an associated library...\nWould you like to make a new one? (Y/N): ").equals("Y")) {
          currentLib = new Library(name);
          libs.add(currentLib);
          cont = false;
        }
      }
    }
    // Overall Actions Loop
    boolean loggedin = true;
    String cmd = "";
    while (loggedin) {
      cmd = IO.readln("What would you like to do? (New/View/Edit): ");
      while (!(cmd.equals("New") || cmd.equals("View"))) {
        cmd = IO.readln("Please pick a valid option. (New/View/Edit): ");
      }
      if (cmd.equals("New")) {
        IO.println("Generating new book!");
        String title = IO.readln("What is the title? ");
        String author = IO.readln("Who is the author? ");
        String pages = IO.readln("How many pages? ");
        String read = IO.readln("Have you read this book? (Y/N): ");
        while (!(read.equals("Y") || read.equals("N"))) {
          read = IO.readln("Have you read this book? (Y/N): ");
        }
        if (read.equals("Y")) {
          currentLib.addBook(new Book(title, author, pages, true));
        } else {
          currentLib.addBook(new Book(title, author, pages, false));
        }
        IO.println(title + " by " + author + " with " + pages + " pages has been added to your library!");
      }
    }
  }
}
