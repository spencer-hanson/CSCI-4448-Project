package vizdiztree.surveytree;
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


    public void buildTree() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python3", "decision_tree.py");
        Process p = pb.start();

//        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        int ret2 = new Integer(in.readLine()).intValue();
//        System.out.println(ret2);
//        System.out.println("Made it to try");

    }


}