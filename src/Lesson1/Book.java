package Lesson1;

public class Book {
	
	
	String name;
	
	String author;
	
	int numOfPages;
	
	double price;
	
	public Book(){
		
	}
	
	public Book(String name, String author){
		this.name=name;
		
		this.author=author;
	}
	
	public void switchBookName(String newName){
		this.name=newName;
		
	}
	
	

}
