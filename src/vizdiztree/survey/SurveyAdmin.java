package vizdiztree.survey;

import java.util.ArrayList;

public class SurveyAdmin {
    private ArrayList<Survey> surveys;
    private String username;
    private String password;


    public SurveyAdmin(String username, String password) {
        // TODO database login lookup here
        this.surveys = new ArrayList<>();
        this.username = username;
        this.password = password;
    }

    // Create a new survey, given just a title
    public Survey addSurvey(String title) {
        return null;
    }

    // Get the list of all the surveys in DB
    public ArrayList<Survey> getSurveys() {
        return this.surveys;
    }

    // Get username of logged in SurveyAdmin
    public String getUsername() {
        return this.username;
    }

    // For changing username
    // Returns true if username change was successful
    public boolean setUsername(String username) {
        //TODO database stuff
        this.username = username;
        return true;
    }

    // For changing password
    public void setPassword(String password) {
        //TODO database stuff
        this.password = password;
    }

    //Check username and password before init'ing a SurveyAdmin object
    // Returns true if username and password are in DB
    public static boolean tryLogin(String name, String password) {
        //TODO database stuff
        return false;
    }

}
