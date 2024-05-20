
/**
 * Represents a user with an ID, username, password, and role.
 */
public class User {
	// Properties
	private String username;
	private String password;
	private Role role;

	/**
     * Constructs a new User with default values.
     * The default username is "Anonymous", password is an empty string, and role is SUBSCRIBER.
     */
	public User() {
		this.username = "Anonymous";
		this.password = "";
		this.role = Role.SUBSCRIBER;
	}
	/**
	 * Constructs a new User with the specified ID, username, password, and role.
	 * 
	 * @param username the username of the user
	 * @param password the password of the user
	 * @param role     the role of the user (ADMIN or SUBSCRIBER)
	 */
	public User(String username, String password, Role role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * Returns the username of the user.
	 *
	 * @return the username of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username of the user.
	 *
	 * @param username the new username of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns the password of the user.
	 *
	 * @return the password of the user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the user.
	 *
	 * @param password the new password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Returns the role of the user.
	 *
	 * @return the role of the user (ADMIN or SUBSCRIBER)
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role of the user.
	 *
	 * @param role the new role of the user (ADMIN or SUBSCRIBER)
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Checks if the user has the ADMIN role.
	 *
	 * @return true if the user has the ADMIN role, false otherwise
	 */
	public boolean isAdmin() {
		return this.role == Role.ADMIN;
	}

}
