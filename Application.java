import java.util.ArrayList;

public class Application extends Content {
	
	private String osRequired;
	
	//Constructor for Appliction.
	public Application(String id, String name, double price, String osRequired) {
		super(id, name, price);
		this.osRequired = osRequired;
	}

	
	public Application(String id, String name, String osRequired) {
		super(id, name);
		this.osRequired = osRequired;
	}
}
