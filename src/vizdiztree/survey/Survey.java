package vizdiztree.survey;

import vizdiztree.answer.*;

import java.util.*;

public class Survey {
    private String title;
    private ArrayList<SurveyResponse> responses= new ArrayList<>();
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

        ArrayList<SurveyResponse> r=new ArrayList<>();
        while(i<10) {
            r.add(new SurveyResponse());
            for (Question q : questions) {
                Random rand = new Random();
                ArrayList<Answer> alist = q.getAnswers();
                int index = rand.nextInt(alist.size());
                Answer a = alist.get(index);
                SurveyResponse newR= r.get(i);
                newR.addResponse(a.getTitle());
                r.set(i,newR);
            }
            i = i + 1;
        }
        return r;

    }

    //TODO: Need to check specific conversion details for decision tree.
    public HashMap<String, Integer> convertSurvey(){
        int count=2;
         for(Question q: questions){
           for(Answer a: q.getAnswers()){
               if(!keys.containsKey(a.getTitle())) {
                   keys.put(a.getTitle(), count);
                   count=count+1;
               }
           }
         }
        return keys;
    }
}
