package Lesson3;



public class Admin extends User {

	public Admin(String userName, String password) {
		super(userName, password);

	}

	public User createUser(String userName, String password) {
		User user = new User(userName, password);

		return user;
	}

}
