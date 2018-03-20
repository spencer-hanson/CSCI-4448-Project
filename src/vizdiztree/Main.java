package vizdiztree;
import vizdiztree.answer.Answer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Test Answer class methods
        Answer ans= new Answer("Yes");
        System.out.println(ans.getTitle());
        ans.setTitle("No");
        System.out.println(ans.getTitle());
    }
}