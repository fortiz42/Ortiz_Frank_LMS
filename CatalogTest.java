
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatalogTest {
    private Catalog catalog;

    @BeforeEach
    public void setUp() {
        catalog = new Catalog();
    }

    @Test
    public void testAddBook() {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book(2, "1984", "George Orwell");

        assertTrue(catalog.addBook(book1));
        assertTrue(catalog.addBook(book2));
        assertEquals(2, catalog.getBooks().size());
    }

    @Test
    public void testAddDuplicateBook() { 
        
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");

        assertTrue(catalog.addBook(book1));
         
        assertFalse(catalog.addBook(book1));
         

        assertEquals(1, catalog.getBooks().size());
    }

    @Test
    public void testDeleteBook() {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        catalog.addBook(book1);

        catalog.deleteBook(1);
        assertEquals(0, catalog.getBooks().size());
    }

    @Test
    public void testDeleteNonExistentBook() {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        catalog.addBook(book1);

        catalog.deleteBook(2); // Attempt to delete a book that does not exist
        assertEquals(1, catalog.getBooks().size());
    }

    @Test
    public void testCanAdd() {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book(2, "1984", "George Orwell");

        assertTrue(catalog.canAdd(book1));
        catalog.addBook(book1);
        assertFalse(catalog.canAdd(book1)); // Duplicate ID
        assertTrue(catalog.canAdd(book2));
    }

    @Test
    public void testLoadBooksFromFile() throws IOException {
        String fileName = "books.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("1, To Kill a Mockingbird, Harper Lee\n");
            writer.write("2, 1984, George Orwell\n");
            writer.write("3, The Great Gatsby, F. Scott Fitzgerald\n");
        }

        catalog.loadBooksFromFile(fileName);
        List<Book> books = catalog.getBooks();
        assertEquals(3, books.size());
        assertEquals("To Kill a Mockingbird", books.get(0).getTitle());
        assertEquals("1984", books.get(1).getTitle());
        assertEquals("The Great Gatsby", books.get(2).getTitle());
    }
    
    @Test
    public void testToString() {
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book(2, "1984", "George Orwell");
        catalog.addBook(book1);
        catalog.addBook(book2); 
        String expected = "Catalog:\n"
        		+ "=================================================\n"
        		+ "Book ID\t:1\n"
        		+ "Title\t:To Kill a Mockingbird\n"
        		+ "Author\t:Harper Lee\n"
        		+ "\n"
        		+ "Book ID\t:2\n"
        		+ "Title\t:1984\n"
        		+ "Author\t:George Orwell\n"
        		+ "\n"
        		+ "=================================================\n";
        assertEquals(expected, catalog.toString());
    }
}
