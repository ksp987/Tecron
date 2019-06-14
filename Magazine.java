
public class Magazine extends Publicatoin {
	private int volume;

	//Constructor for Magazine class.
	public Magazine(String id, String name, double price, String publisher, int pages, int volume) {
		super(id, name, price, publisher, pages);
		this.volume = volume;
	}
}
