package vizdiztree.surveytree;
import vizdiztree.answer.*;
import java.util.*;
import java.io.*;

public class SurveyTree {
    public int buildTree() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "testing.py");
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int ret = new Integer(in.readLine()).intValue();
            System.out.println(ret);

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

}