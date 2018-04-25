package vizdiztree.answer;

import org.bson.Document;
import vizdiztree.answer.Answer;
import vizdiztree.db.BsonCompatible;

import java.util.*;

public class Question implements BsonCompatible {
    private String title;
    private ArrayList<Answer> lista = new ArrayList<>();


    public Question(String _title, ArrayList<String> _lista) {
        setTitle(_title);
        addAnswers(_lista);

    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public String getTitle() {
        return this.title;
    }

    private void addAnswers(ArrayList<String> _lista) {
        for (String a : _lista) {
            Answer ans = new Answer(a);
            lista.add(ans);
        }
    }

    public ArrayList<Answer> getAnswers() {
        return this.lista;
    }

    public Document toBson() {
		ArrayList<String> listas = new ArrayList<>();
		for(Answer a : lista) {
		    listas.add(a.getTitle());
        }
        return new Document("title", this.title)
                .append("lista", listas);
    }

    public static Question fromBson(Document d) {
        return new Question((String)d.get("title"), (ArrayList<String>)d.get("lista"));
    }

}
