import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a catalog of books.
 */
public class Catalog {
    private List<Book> books;

    /**
     * Constructs a new, empty Catalog.
     */
    public Catalog() {
        this.books = new ArrayList<>();
    }
    
    /**
     * Checks if a book can be added to the catalog.
     * A book can be added only if there is no existing book with the same ID in the catalog.
     *
     * @param book the book to check
     * @return true if the book can be added, false otherwise
     */
   public boolean canAdd(Book book) {
       for (Book bk : books) {
           if (book.getId() == bk.getId()) {
               return false;
           }
       }
       return true;
   }
   /**
    * Adds a book to the catalog if the book can be added 
    * (i.e., it doesn't already exist in the catalog).
    *
    * @param book the book to add
    * @return true if the book was successfully added, 
    * false if the book already exists in the catalog
    */
    public boolean addBook(Book book) {
    	if(canAdd(book)) {
    		books.add(book);
    		return true;
    	}else {
    		return false;
    	}
    }

    /**
     * Deletes a book from the catalog by its ID.
     *
     * @param bookId the ID of the book to delete
     */
    public void deleteBook(int bookId) {
    	if(getIndex(bookId) != -1)
    		books.remove(getIndex(bookId));
    }
    
    /**
     * Returns the index of a book in the catalog by its ID.
     *
     * @param bookId the ID of the book to find
     * @return the index of the book, or -1 if the book is not found
     */
	private int getIndex(int bookId) {
		for (Book book : books) {
	        if(bookId == book.getId()) {
	        	return books.indexOf(book);
	        }
	    }
		return -1;
	} 
     
    /**
     * Returns the list of all books in the catalog.
     *
     * @return the list of all books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Returns a string representation of the catalog.
     * 
     * @return a string representation of the catalog with all books
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalog:\n=================================================\n");
        for (Book book : books) {
            sb.append(book.toString()).append("\n\n");
        }
        sb.append("=================================================\n");
        return sb.toString();
    }

    /**
     * Loads books from a text file and adds them to the catalog.
     * The text file should have lines in the format: id, title, author.
     *
     * @param fileName the name of the file to read books from
     * @throws IOException if an I/O error occurs
     */
    public void loadBooksFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    // Create an object for each book and add it to the LMS
                    Book b = new Book(id, title, author);
                    if(!addBook(b)) {
                    	System.err.println("Error : Book already Exits: \n"+b);
                    }
                }
            }
        }
    }
}
