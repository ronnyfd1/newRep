package Lesson2;

public class BasketItem {

	private int id;

	private double price;

	private String name;

	private int quantityInStock;

	private boolean existInStock;

	private String description;

	private String imageUrl;

	private double weight;

	private double length;
	private double width;
	private double height;
	
	private double volume;
	
	public BasketItem(String name,double width, double height,double length){
		
		
		this.name=name;
		this.description=name;
		
		this.volume=width*height*length;
		
		System.out.println("item created with name: "+name);
	}
	
	
	
	/**
	 * 
	 * @param price - this is the price - 
	 * @param name
	 * @param existInStock
	 */
	public BasketItem(double price, String name, boolean existInStock) {
		
//		this.price = price;
//		this.name = name;
//		this.existInStock = existInStock;
	}
	
	public String getDetails(){
		String details="";
		
		details+="name: "+name;
		
		details+=", id "+id;
		
		return details;
		
		
	}
	
	public String getDetails(String text){
		return null;
	}




	




	




	




	public BasketItem() {
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public boolean isExistInStock() {
		return existInStock;
	}
	public void setExistInStock(boolean existInStock) {
		this.existInStock = existInStock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

}
