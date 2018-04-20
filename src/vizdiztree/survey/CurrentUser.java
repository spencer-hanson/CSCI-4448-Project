package vizdiztree.survey;

public class CurrentUser {
    private SurveyAdmin user;

    public CurrentUser(SurveyAdmin admin){
        setUser(admin);
    }
    public SurveyAdmin getUser() {
        return user;
    }

    private void setUser(SurveyAdmin user) {
        this.user = user;
    }
}
