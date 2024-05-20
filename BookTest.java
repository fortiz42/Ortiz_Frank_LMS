import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    public void testBookConstructorAndGetters() {
        Book book = new Book(1, "To Kill a Mockingbird", "Harper Lee");

        assertEquals(1, book.getId());
        assertEquals("To Kill a Mockingbird", book.getTitle());
        assertEquals("Harper Lee", book.getAuthor());
    }

    @Test
    public void testSetters() {
        Book book = new Book(1, "To Kill a Mockingbird", "Harper Lee");

        book.setId(2);
        book.setTitle("1984");
        book.setAuthor("George Orwell");

        assertEquals(2, book.getId());
        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
    }

    @Test
    public void testToString() {
        Book book = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        String expected = "Book ID\t:1\nTitle\t:To Kill a Mockingbird\nAuthor\t:Harper Lee";

        assertEquals(expected, book.toString());
    }
}
