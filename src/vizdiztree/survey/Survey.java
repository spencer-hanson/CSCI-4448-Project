package vizdiztree.survey;
import vizdiztree.answer.*;
import java.util.*;
import java.io.*;

public class Survey {
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

    public ArrayList<SurveyResponse> getResponses() {
        return responses;
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
}
