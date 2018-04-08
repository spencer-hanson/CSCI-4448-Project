package vizdiztree.answer;
import vizdiztree.answer.Answer;
import java.util.*;
public class Question {
	private String title;
	private ArrayList<Answer> lista= new ArrayList<>();

	public Question(String _title, ArrayList<String> _lista){
		setTitle(_title);
		addAnswers(_lista);
	}

	public void setTitle(String _title){
		this.title=_title;
	}

	public String getTitle(){
		return this.title;
	}

	private void addAnswers(ArrayList<String> _lista){
		 for(String a: _lista){
		     Answer ans= new Answer(a);
			lista.add(ans);
		 }
	}

	public ArrayList<Answer> getAnswers(){
		return this.lista;
	}

	//TODO: Need to check specific conversion details for decision tree.
	public Question convertQuestion(){
		return null;
	}



}
