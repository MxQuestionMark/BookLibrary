public class Book {
    private String title;
    private String author;
    private String pages;
    private boolean read;
    public Book(String t, String a, String p, boolean r) {
        title = t;
        author = a;
        pages = p;
        read = r;
    }
    public void edit(String t, String a, String p, boolean r) {
        title = t;
        author = a;
        pages = p;
        read = r;
    }
}
