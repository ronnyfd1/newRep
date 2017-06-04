package Lesson1;

public class StringsClass {

	public static void main(String[] args) {

		String name = "israel israeli";

		String g;
		
		int end=name.indexOf(" ");
		
		g=name.substring(0, end);
		
		System.out.println(g);

		String t = "dssd";
		
		
		int length=name.length();
		
		System.out.println("length: "+length);
		
		
		String numString="9999";
		
		int sNum=Integer.valueOf(numString);
		
		String r=String.valueOf(sNum);
		
		
		
		
		System.out.println("after convert: " +sNum);
		
		

	}

}
