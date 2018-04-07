package vizdiztree.answer.Answer
import java.util.*;
public class Question {
	private String title;
	private ArrayList<Answer> lista;

	public Question(String _title, ArrayList<Answer> _lista){
		setTitle(_title);
		addAnswers(_lista);
	}

	public void setTitle(String _title){
		this.title=_title;
	}

	public String getTitle(){
		return this.title;
	}

	public void addAnswers(ArrayList<String> _lista){
		// for(String a: _lista){

		// }
	}

	public ArrayList<Answer> getAnswers(){
		return this.lista;
	}

	//TODO: Need to check specific conversion details for desicion tree.
	public Question convertQuestion(){
		return null;
	}

}
