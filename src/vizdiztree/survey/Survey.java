package vizdiztree.survey;

import vizdiztree.answer.*;

import java.util.*;

public class Survey {
    private String title;
    private ArrayList<SurveyResponse> responses= new ArrayList<>();
    private ArrayList<Question> questions= new ArrayList<>();

    public Survey(String _title){
        setTitle(_title);
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

    public ArrayList<SurveyResponse> takeSurvey(){
        int i=0;

        ArrayList<SurveyResponse> r=new ArrayList<>();
        while(i<10) {
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
    public Survey convertSurvey(){
        return null;
    }
}
