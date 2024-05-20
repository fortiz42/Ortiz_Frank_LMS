
/**
 * Represents a book with an ID, title, and author name.
 */
public class Book { 
    private int id;
    private String title;
    private String author;

    /**
     * Constructs a new Book with the specified ID, title, and author name.
     *
     * @param id     the ID of the book
     * @param title  the title of the book
     * @param author the author of the book
     */
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    /**
     * Returns the ID of the book.
     *
     * @return the ID of the book
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the book.
     *
     * @param id the new ID of the book
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title the new title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author the new author of the book
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns a string representation of the book.
     * 
     * @return a string representation of the book 
     */
    @Override
    public String toString() {
        return "Book ID\t:" + id +
                "\nTitle\t:" + title + 
                "\nAuthor\t:" + author ;
    }
}
