import java.util.ArrayList;

public class Publicatoin extends Content {
	private String publisher;
	private int pages;

	//Constructor for publication class.
	public Publicatoin(String id, String name, double price, String publisher, int pages) {
		super(id, name, price);
		this.publisher = publisher;
		this.pages = pages;
	}
}
	
	
	
	


