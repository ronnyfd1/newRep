package Lesson1;

public class Library {
	
	public static void main(String []args){
		Book book1=new Book("harry potter", "JKRolling");
		
		System.out.println(book1.name);
		
		book1.name="fdfdsfds";
		
	//	book1.switchBookName("h_arry potter");
		
		System.out.println(book1.name);
		
		
		
		
	}

}
