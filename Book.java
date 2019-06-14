import java.util.ArrayList;
import java.util.Arrays;
 
public class Book extends Publicatoin {
	private String[] authors;
	
	//Constructor for book class.
	public Book(String id, String name, double price, String publisher, int pages, String[] authors) {
		super(id, name, price, publisher, pages);
		this.authors = authors;
	}
}
