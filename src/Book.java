import java.io.Serializable;

public class Book implements Serializable{
    private String title;
    private String author;
    private String pages;
    private boolean read;
    private String summary;
    public Book(String t, String a, String p, boolean r) {
        title = t;
        author = a;
        pages = p;
        read = r;
        summary = null;
    }
    public void edit(String t, String a, String p, boolean r) {
        title = t;
        author = a;
        pages = p;
        read = r;
    }
    @Override 
    public String toString() {
        return (title + " by " + author) + (read ? " [X]" : " [ ]");
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPages() {
        return pages;
    }
    public boolean isRead() {
        return read;
    }
    public void setTitle(String t) {
        title = t;
    }
    public void setAuthor(String a) {
        author = a;
    }
    public void setPages(String p) {
        pages = p;
    }
    public void toggleRead() {
        read = !read;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String s) {
        summary = s;
    }
    public boolean hasSummary() {
        return !(summary == null);
    }
}
