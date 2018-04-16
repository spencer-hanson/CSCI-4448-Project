package vizdiztree.surveytree;
//import org.supercsv.cellprocessor.ift.CellProcessor;
import vizdiztree.answer.*;
import vizdiztree.survey.*;
import java.util.*;
import java.io.*;


public class SurveyTree {
    private Survey survey;

    public Survey getSurvey(){
        return this.survey;
    }
    public void setSurvey(Survey s){
        survey = s;
    }

    public void writeData(ArrayList<ArrayList<Integer>> convertedresponses){
        //write convertedResponses to a text file
        try {
            System.out.println("hello");
            PrintWriter writer = new PrintWriter("survey_data.txt", "UTF-8");
            writer.println(convertedresponses);
            writer.close();
        }
        catch (UnsupportedEncodingException fnfe) {
            // do something sensible with the exception.
        }
        catch (FileNotFoundException fnfe) {
            // do something sensible with the exception.
        }
    }

    public void writeQuestions() {
        try {
            PrintWriter writer = new PrintWriter("question_data.txt", "UTF-8");
            for (Question q1 : survey.getQuestions()) {
                System.out.println("Question: " + q1.getTitle());


                System.out.print("hi\n");

                writer.append(q1.getTitle()+'\n');

            }
            writer.close();
        }
            catch (UnsupportedEncodingException fnfe) {
                // do something sensible with the exception.
            }
            catch (FileNotFoundException fnfe) {
                // do something sensible with the exception.
            }
        }


    public void buildTree() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "decision_tree.py");
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int ret = new Integer(in.readLine()).intValue();
            System.out.println(ret);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}