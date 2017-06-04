package Lesson3;

public class Mgmt {

	public static void main(String[] args) {
		
		
		//creating admin object
		Admin admin = new Admin("omer", "1234");

		//User object created by the admin (by the createUser method)
		User user1 = admin.createUser("user1", "qwerty");

		//running the login method on user1 object
		user1.login(user1.getUsername(), user1.getPassword());
	}

}
