import java.util.*;

public class User {
	private String id;
	private String name;
	private String phoneNumber;
	private double fund = 500;
	private HashMap<String, Boolean> premiumMember = new HashMap<String, Boolean>();
	private HashMap<String, ArrayList<String>> contentBought = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> item = new ArrayList<String>();
	
	//Constructors for User class
	public User(String id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		premiumMember.put(this.id, false);
	}

	public User(String id, String name, String phoneNumber, double fund) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.fund = fund;
		premiumMember.put(this.id, false);
	}
	
	//Method to make a user Premium member
	public void becomePremium() {
		if (premiumMember.get(this.id) == true) {
			System.out.println("user is already premium member.");
		} else {
			premiumMember.put(this.id, true);
			this.fund -= 100;
			System.out.println("User "+ this.id +" is upgraded to premium");
		}
		
	}
	
	//20% discounted price
	public double discountedPrice(double price) {
		return 0.8*price;
	}
	
	public void addContentBought(String userId, String item) {
		this.item.add(item);
		contentBought.put(userId, this.item);
	}
	
	//Method to buy a book
	public void buyContent(Book book) {
		addContentBought("Contents bought by user " + this.id, "Book: " + book.getId());
		
		if (premiumMember.get(this.id)) 
			this.fund -= discountedPrice(book.getPrice());
		else this.fund -= book.getPrice();
		
		book.setDownloads(book.getDownloads() + 1);
		System.out.println("The user " + this.id + " has bought the book.");
	}
	
	//Method to buy a magazine
	public void buyContent(Magazine magazine) {
		addContentBought("Contents bought by user " + this.id, "Magazine: " + magazine.getId());
		
		if (premiumMember.get(this.id)) 
			this.fund -= discountedPrice(magazine.getPrice());
		else this.fund -= magazine.getPrice();
		
		magazine.setDownloads(magazine.getDownloads() + 1);
		System.out.println("The user " + this.id + " has bought the magazine.");
	}	
	
	//Method to buy an Application
	public void buyContent(Application app) {
		addContentBought("Contents bought by user " + this.id, "Application: " + app.getId());
		
		if (premiumMember.get(this.id)) 
			this.fund -= discountedPrice(app.getPrice());
		else this.fund -= app.getPrice();
		
		app.setDownloads(app.getDownloads() + 1);
		System.out.println("The user " + this.id + " has bought the application.");
	}

	//Method to get id
	public String getId() {
		return id;
	}
	
	//Method to show content bought.
	public void showContentBought() {
		if (contentBought.size() != 0) {
		System.out.println(contentBought);
		contentBought.clear();
		} else
			System.out.println("User did not purchase anything.");
	}
}
