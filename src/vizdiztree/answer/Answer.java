package vizdiztree.answer;

public class Answer {
	private String title;

	public Answer(String _title){
		setTitle(_title);
	}

	public void setTitle(String _title){
		this.title=_title;
	}

	public String getTitle(){
		return this.title;
	}

	//TODO: Need to check specific conversion details for desicion tree.
	public Answer convertAnswer(){
		return null;
	}
}
