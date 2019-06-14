
import java.util.ArrayList;

public class PlayStore {
	
	// Declare a private variable (array or similar) to store your Content objects here
	private ArrayList<Content> content = new ArrayList<Content>();

	// Declare a private variable (array or similar) to store your User objects here
	private ArrayList<User> user = new ArrayList<User>();
	
	public PlayStore() {
		// any code you need here
	}
	
	public void addContent(Content content) {
		// add the content into your content list
		this.content.add(content);
	}

	public void addUser(User user) {
		// add the user to your list of users
		this.user.add(user);
	}	

	public void showContent() {
		for(Content i: this.content) {
			System.out.println(i);
		}
	}
}
