package vizdiztree.survey;

import vizdiztree.answer.*;

import java.util.ArrayList;

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

    //TODO: Need to check specific conversion details for decision tree.
    public Survey convertSurvey(){
        return null;
    }
}
