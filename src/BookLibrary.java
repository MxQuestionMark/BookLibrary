import java.util.ArrayList;
public class BookLibrary {
  public static void main(String[] args) {
    ArrayList<Library> libs = new ArrayList<Library>();
    Library currentLib;
    
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
        if (IO.readln("That name doesn't currently have an associated library...\nWould you like to make a new one? (Y/N)").equals("Y")) {
          currentLib = new Library(name);
          libs.add(currentLib);
          cont = false;
        }
      }
    }

  }
}
