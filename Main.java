import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main class that runs the Library Management System (LMS). It allows the
 * user to interact with the catalog of books and perform various operations.
 */
public class Main {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Catalog catalog = new Catalog();
	private static User loggedUser = new User();

	/**
	 * The main method to run the LMS.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		// login user
		if (loginUser()){
			System.out.println();
			System.out.println("Welcome, " + loggedUser.getUsername() + "!\nStatus :" + loggedUser.getRole()+"\n");
			System.out.print("Enter the filename of the text file to load books from: ");
			String fileName = scanner.nextLine();
			try {
				catalog.loadBooksFromFile(fileName);
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
			System.out.println("Books loaded successfully.\n");
			System.out.println(catalog);

			boolean exit = false;
			while (!exit) {
				printMenu();
				int choice = -1;
				try {
					choice = Integer.parseInt(scanner.nextLine());
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}
				switch (choice) {
					case 1:
						if (loggedUser.isAdmin()){
							System.out.print("Enter the name of the text file to load books from: ");

							String booksData = scanner.nextLine();
							try {
								catalog.loadBooksFromFile(booksData);
							} catch (Exception e) {
								System.err.println("Error: " + e.getMessage());
							}
						}else {
							System.out.println("You must be an admin to Add a Book from file.");
						}
						System.out.println();
						break;
					case 2:
						if (loggedUser.isAdmin()) {  // if its admin, do the following
							System.out.print("Enter the ID of the book to remove: ");
							try {
								int idToRemove = Integer.parseInt(scanner.nextLine());
								catalog.deleteBook(idToRemove);
								System.out.println("Book deleted successfully.");
							} catch (Exception e) {
								System.err.println("Error: " + e.getMessage());
							}
						} else {
							System.out.println("You must be an admin to Delete a Book.");
						}
						System.out.println();
						break;
					case 3:
						if (loggedUser.isAdmin()) {  // if its admin, do the following
							try {
								// prompt user to enter book unique id, book title and the book author
								System.out.print("Enter the ID: ");
								int newId = Integer.parseInt(scanner.nextLine());

								System.out.print("Enter the title: ");
								String newTitle = scanner.nextLine();

								System.out.print("Enter the author: ");
								String newAuthor = scanner.nextLine();

								// Create an object for each book and add it to the LMS
								Book b = new Book(newId, newTitle, newAuthor);
								if (catalog.addBook(b)) {
									System.out.println("Book added successfully.");
								} else {
									System.err.println("Book ID already Exist1");
								}
							} catch (Exception e) {
								System.err.println("Error: " + e.getMessage());
							}
						} else {
							System.out.println("You must be an admin to Add a Book.");
						}
						System.out.println();
						break;
					case 0:
						exit = true;
						break;
					default:
						System.out.println("Invalid option. Please try again.");
				}
				// display the updated list of books
				System.out.println(catalog);
			}
		}
		System.out.println("Exiting the program. Goodbye!");
	}

	/**
	 * Attempts to log in a user with up to three attempts. Asks for a username and
	 * password and checks against the list of users.
	 *
	 * @return true if login is successful, false otherwise
	 */
	private static boolean loginUser() {
		List<User> users = getUsers();
		System.out.println("Welcome to our Library Management System (LMS).");
		System.out.println("\tEnter your login credentials to access the system.\n\tYou have 5 attempts\n");
		for (int i = 1; i <= 5; i++) {
			// prompt user for login credentials
			System.out.print("Enter Username: ");
			String username = scanner.nextLine();

			System.out.print("Enter Password: ");
			String password = scanner.nextLine();

			// loop list of users to check is login credentials match
			for (User user : users) {
				// check if logins match
				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					System.out.println("Login Successful..!");
					loggedUser = user;
					return true;  // if logins match
				}
			}
			System.out.println("Invalid username or password. Attempts remaining: " + (5 - i));
		}
		System.out.println("Login Failed!.....");
		return false; // if logins are incorrect 5 times
	}

	/**
	 * Prints the menu options to the console. The menu includes options to: 1. Add
	 * new books from a text file 2. Remove a book by ID 3. Add a single book from
	 * the terminal 4. Exit the program
	 */
	private static void printMenu() {
		System.out.println("Choose Option from the list:");
		System.out.println("1. Add new books from a text file");
		System.out.println("2. Remove a book by ID");
		System.out.println("3. Add a single book");
		System.out.println("0. EXIT");
		System.out.print("Choose an option: ");
	}

	/**
	 * Creates a list of 10 users.
	 *
	 * @return the list of users
	 */
	private static List<User> getUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User("admin1", "password1", Role.ADMIN));
		users.add(new User("admin2", "password2", Role.ADMIN));
		users.add(new User("des", "des", Role.ADMIN));
		users.add(new User("d1", "d1", Role.SUBSCRIBER));
		users.add(new User("user2", "password4", Role.SUBSCRIBER));
		users.add(new User("user3", "password5", Role.SUBSCRIBER));
		users.add(new User("user4", "password6", Role.SUBSCRIBER));
		users.add(new User("user5", "password7", Role.SUBSCRIBER));
		users.add(new User("user6", "password8", Role.SUBSCRIBER));
		users.add(new User("user7", "password9", Role.SUBSCRIBER));
		users.add(new User("user8", "password10", Role.SUBSCRIBER));
		return users;
	}
}
