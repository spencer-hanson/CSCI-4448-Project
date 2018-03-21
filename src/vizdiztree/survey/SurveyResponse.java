package vizdiztree.survey;

import java.util.ArrayList;

public class SurveyResponse {
    private ArrayList<String> responses= new ArrayList<>();

    public void addResponse(String resp) {
        this.responses.add(resp);
    }

    public ArrayList<String> getResponses() {
        return this.responses;
    }
}
