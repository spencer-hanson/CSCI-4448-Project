package vizdiztree.survey;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import org.bson.Document;
import vizdiztree.answer.*;
import vizdiztree.db.BsonCompatible;

import java.util.*;
import java.io.*;

public class Survey implements BsonCompatible {
    private String title;
    private ArrayList<SurveyResponse> responses= new ArrayList<>();
    private ArrayList<ArrayList<Integer>> convertedResponses=new ArrayList<>();

    private ArrayList<Question> questions= new ArrayList<>();
    private HashMap<String, Integer> keys= new HashMap<>();

    public Survey(String _title){

        setTitle(_title);
        keys.put("Yes",1);
        keys.put("No",0);
    }

    public void setTitle(String _title){
        this.title=_title;
    }

    public String getTitle(){
        return this.title;
    }

    public ArrayList<Question> getQuestions(){
        return questions;
    }

    public void addQuestion(String _title, ArrayList<String> lista){
        questions.add(new Question(_title, lista));
    }

    public void addQuestion(Question q) { questions.add(q); }

    public void addResponse(SurveyResponse sr) { responses.add(sr); }

    public ArrayList<SurveyResponse> getResponses() {
        return responses;
    }

    public void setResponses(ArrayList<SurveyResponse> r){
        responses=r;
    }

    public HashMap<String, Integer> getKeys() {
        return keys;
    }


    public ArrayList<SurveyResponse> takeSurvey(){
        int i=0;

        while(i<10) {
            responses.add(new SurveyResponse());
            for (Question q : questions) {
                Random rand = new Random();
                ArrayList<Answer> alist = q.getAnswers();
                int index = rand.nextInt(alist.size());
                Answer a = alist.get(index);
                SurveyResponse newR= responses.get(i);
                newR.addResponse(a.getTitle());
                responses.set(i,newR);
            }
            i = i + 1;
        }
        return getResponses();

    }

    public void setKeys(HashMap<String, Integer> keys) {
        this.keys = keys;
    }

    public void createKeys(){
        int count=2;
         for(Question q: questions){
           for(Answer a: q.getAnswers()){
               if(!keys.containsKey(a.getTitle())) {
                   keys.put(a.getTitle(), count);
                   count=count+1;
               }
           }
         }

    }

    //Converts all responses to integers given the hashMap keys
    public ArrayList<ArrayList<Integer>> convertResponses(){


        for(SurveyResponse r: responses){
            ArrayList<Integer> conR=new ArrayList<>();
            for(String title: r.getResponses()){
                conR.add(keys.get(title));

            }
            convertedResponses.add(conR);
        }
        return convertedResponses;
    }

    public ArrayList<ArrayList<Integer>> getConvertedResponses() {
        return convertedResponses;
    }

    public Document toBson() {
        ArrayList<ArrayList<String>> responses = new ArrayList<>();

        for(SurveyResponse s :  this.responses) {
            responses.add(s.getResponses());
        }

        ArrayList<Document> qs = new ArrayList<>();
        for (Question q : this.questions) {
            qs.add(q.toBson());
        }

        Document d = new Document()
                .append("title", this.title)
                .append("responses", responses)
                .append("questions", qs)
                .append("keys", keys);
        return d;
    }

    public static Survey fromBson(Document d) {

        Survey s = new Survey((String)d.get("title"));

        for(Document qd: (ArrayList<Document>) d.get("questions")) {
            s.addQuestion(Question.fromBson(qd));
        }

        for(ArrayList<String> rd: (ArrayList<ArrayList<String>>) d.get("responses")) {
            SurveyResponse sr = new SurveyResponse();
            for(String rdi : rd) {
                sr.addResponse(rdi);
            }
            s.addResponse(sr);
        }
        DBObject keys = (DBObject) JSON.parse(((Document)d.get("keys")).toJson());

        s.setKeys((HashMap<String, Integer>)keys.toMap());

        return s;
    }
}
