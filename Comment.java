
public class Comment {
	
	private User user;
	private String comment;
	
	//constructor for Comment.
	public Comment(User user, String comment) {
		super();
		this.user = user;
		this.comment = comment;
	}
	
	//getter for comment.
	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		return "Review by user = " + user.getId() + ", comment=" + comment ;
	}

}
