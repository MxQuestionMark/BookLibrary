import java.util.ArrayList;
public class BookLibrary {
  // This is a function to clear the terminal so you arent overwhelmed by lines...
  private static void clear() {
    for (int i = 0; i < 60; i++) {
      IO.println();
    }
  }
  public static void main(String[] args) {
    ArrayList<Library> libs = Library.getLibs();
    Library currentLib = new Library(null);
    
    IO.println("Hello and welcome to the BookLibrary program!");
    boolean newUser = true;
    boolean cont = true;
    
    clear();

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
          Library.update(currentLib);
          cont = false;
        }
      }
    }
    // Overall Actions Loop
    boolean loggedin = true;
    String cmd;
    while (loggedin) {
      Library.update(currentLib);
      clear();
      cmd = IO.readln("What would you like to do? (New/View/Edit/Log Out): ");
      while (!(cmd.equals("New") || cmd.equals("View") || cmd.equals("Edit") || cmd.equals("Log Out"))) {
        cmd = IO.readln("Please enter a valid response. (New/View/Edit): ");
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
        IO.readln("Press enter to continue...");
      } else if (cmd.equals("View")) {
        ArrayList<Book> books = currentLib.getBooks(); // Gets list of books and prints all the books
        for (int i = 0; i < books.size(); i++) {
          IO.println(i+": "+books.get(i));
        }
        boolean cont1 = true; // continue var to loop until they want to stop viewing books
        while (cont1) {
          String ans = IO.readln("Please select a book to view further or exit. (# or Exit) ");
          while (!(ans.equals("Exit") || currentLib.validNumber(ans))) {
            ans = IO.readln("Please enter a valid response. (# or Exit) ");
          }
          clear();
          if (ans.equals("Exit")) {
            cont1 = false;
          } else {
            Book book = books.get(Integer.parseInt(ans)); // add more info in the future here
            IO.println(book.getTitle() + " by " + book.getAuthor());
            IO.println(book.isRead() ? "Already read!" : "Not yet read...");
            IO.println("Page count: " + book.getPages());
          }
        }
      } else if (cmd.equals("Edit")) {
        ArrayList<Book> books = currentLib.getBooks(); // Gets list of books and prints all the books
        for (int i = 0; i < books.size(); i++) {
          IO.println(i+": "+books.get(i));
        }
        boolean cont1 = true; // continue var to loop until they want to stop editing books
        while (cont1) {
          String ans = IO.readln("Please select a book to edit or exit. (# or Exit) ");
          while (!(ans.equals("Exit") || currentLib.validNumber(ans))) {
            ans = IO.readln("Please enter a valid response. (# or Exit) ");
          }
          clear();
          if (ans.equals("Exit")) {
            cont1 = false;
          } else {
            Book book = books.get(Integer.parseInt(ans)); // add more info in the future here
            IO.println("Current Information:");
            IO.println(book.getTitle() + " by " + book.getAuthor());
            IO.println(book.isRead() ? "Already read!" : "Not yet read...");
            IO.println("Page count: " + book.getPages());
            IO.println("What would you like to change? (#)");
            IO.println("(1) - Title");
            IO.println("(2) - Author");
            IO.println("(3) - Pages");
            IO.println("(4) - Read");
            String editAns = IO.readln();
            while (!(editAns.equals("1") || editAns.equals("2") || editAns.equals("3") || editAns.equals("4"))) {
              editAns = IO.readln("Please enter a valid response (#)");
            }
            switch (editAns) {
              case "1" -> {
                String s = IO.readln("New Title: ");
                book.setTitle(s);
              }
              case "2" -> {
                String s = IO.readln("New Author: ");
                book.setAuthor(s);
              }
              case "3" -> {
                String s = IO.readln("New Page Count: ");
                book.setPages(s);
              }
              case "4" -> {
                book.toggleRead();
              }
            }
            IO.println("New Information:");
            IO.println(book.getTitle() + " by " + book.getAuthor());
            IO.println(book.isRead() ? "Already read!" : "Not yet read...");
            IO.println("Page count: " + book.getPages());
            IO.println("Press enter to continue...");
            IO.readln();
            clear();
          }
        }
      } else if (cmd.equals("Log Out")) {
          Library.update(currentLib);
          loggedin = false;
          IO.println("Goodbye!");
      }
    }
  }
}
