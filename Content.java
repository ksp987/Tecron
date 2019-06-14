import java.util.*;

public abstract class Content {
	private String id;
	private String name;
	private int downloads = 0;
	private double price;
	private ArrayList<Comment> reviews = new ArrayList<Comment>();
	private HashMap<String, ArrayList<String>> commentsWritten = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> comment = new ArrayList<String>();
	
	public Content(String id, String name, int downloads, double price, ArrayList<Comment> reviews) {
		super();
		this.id = id;
		this.name = name;
		this.downloads = downloads;
		this.price = price;
		this.reviews = reviews;
	}

	public Content(String id, String name, double price) {
//		this(id,name,0,price,null);
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Content(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//Write method that stores the Comments

	public Content() {}

	public void StoreComments(String contentId,  String comment) {
		this.comment.add(comment);
		commentsWritten.put(contentId, this.comment);
	}

	public void addReview(Comment reviews) {
		StoreComments(this.id, reviews.getComment());
//		this.reviews.add(reviews);
	}
	
	//Show Comments Method
		public void showComments() {
			System.out.println(commentsWritten.get(this.id));
		}
	
	//Getters 
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getDownloads() {
		return downloads;
	}

	//Methods to set downloads.
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}

	public double getPrice() {
		return price;
	}

	public void showReviews() {
		for(Comment i : this.reviews) {
			System.out.println(i);
		}
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", name=" + name + ", downloads=" + downloads + ", price=" + price + "]";
	}
}
