package Lesson2;

public class StoreClass {

	public static void main(String[] args) {

		BasketItem b1 = new BasketItem();

		b1.setName("shirt A");

		System.out.println(b1.getName());
		
		BasketItem mp3Player=new BasketItem(300, "Sandisk mp3", true);
		
		
		BasketItem b2=new BasketItem(200, "tennis shoes", false);
		
		System.out.println(b2.getDetails());

	}

}
