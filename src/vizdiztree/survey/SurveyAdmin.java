package vizdiztree.survey;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import vizdiztree.db.VizDizTreeMongo;


import java.util.ArrayList;


public class SurveyAdmin {
    private ArrayList<Survey> surveys;
    private String username;
    private String password;
    private VizDizTreeMongo mongo;
    private Document admin;
    private Bson filter;

    private class SurveyAdminException extends Exception {
        SurveyAdminException(String s) {
            super(s);
        }
    }

    public SurveyAdmin(String username, String password) throws Exception {
        this.username = username;
        this.password = password;
        this.mongo = new VizDizTreeMongo();
        this.filter = Filters.and(
                Filters.eq("password", this.password),
                Filters.eq("username", this.username));

        this.admin = this.mongo.getCollection().find(this.filter).first();
        if (this.admin == null) {
            throw new SurveyAdminException("Unable to connect with given user/password!");
        }

        this.surveys = new ArrayList<>();
        ArrayList<Document> surveys = (ArrayList<Document>) admin.get("surveys");
        if (surveys != null) { // no saved surveys
            for(Document survey: surveys) {
                this.surveys.add(Survey.fromBson(survey));
            }
        }
    }

    // Create a new survey, given just a title
    public Survey addSurvey(String title) {
        return this.addSurvey(new Survey((title)));
    }

    public Survey addSurvey(Survey s) {
        this.surveys.add(s);
        this.syncSurveys();
        return s;
    }

    private void syncSurveys() {
        ArrayList<Document> sd = new ArrayList<>();
        for(Survey s: this.surveys) {
            sd.add(s.toBson());
        }
        this.mongo.getCollection().updateOne(this.filter, new Document("$set", new Document("surveys", sd)));
    }

    // Get the list of all the surveys in DB
    public ArrayList<Survey> getSurveys() {
        this.syncSurveys();
        return this.surveys;
    }

    // Get username of logged in SurveyAdmin
    public String getUsername() {
        return this.username;
    }

    // For changing username
    // Returns true if username change was successful
    public boolean setUsername(String username) {
        Document newuser = this.mongo.getCollection().find(Filters.eq("username", username)).first();
        if (newuser == null) {
            this.mongo.getCollection().updateOne(this.filter, new Document("$set", new Document("username", username)));
            this.username = username;
            return true;
        } else {
            // Username is taken
            return false;
        }
    }

    // For changing password
    public void setPassword(String password) {
        this.mongo.getCollection().updateOne(this.filter, new Document("$set", new Document("password", password)));
        this.password = password;
    }

    //Check username and password before init'ing a SurveyAdmin object
    // Returns true if username and password are in DB
    public static boolean tryLogin(String name, String password) {
        try {
            new SurveyAdmin(name, password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addAdmin(String username, String password) {
        VizDizTreeMongo mongo = new VizDizTreeMongo();
        Document newuser = mongo.getCollection().find(Filters.eq("username", username)).first();
        if (newuser == null) {
            Document admin = new Document("username", username).append("password", password);
            mongo.getCollection().insertOne(admin);
            return true;
        } else {
            // Username is taken
            return false;
        }

    }

}
