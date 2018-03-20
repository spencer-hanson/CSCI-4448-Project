package vizdiztree;
import vizdiztree.answer.Answer;
import vizdiztree.answer.Question;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Test Answer class methods
        Answer ans= new Answer("Yes");
        System.out.println(ans.getTitle());
        ans.setTitle("No");
        System.out.println(ans.getTitle());

        //Testing Question class methods
        ArrayList<String> ans1= new ArrayList<>();
        ans1.add("<2000");
        ans1.add("2000-4000");
        ans1.add(">4000");
        Question q= new Question("Car Price?",ans1);
        System.out.println(q.getTitle());
        for(Answer a: q.getAnswers()){
            System.out.println("Possible Answers " + a.getTitle());
        }
        q.setTitle("House Price?");
        System.out.println(q.getTitle());

    }
}