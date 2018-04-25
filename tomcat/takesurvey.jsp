<%@ page import="vizdiztree.survey.*" %>
<%@ page import="vizdiztree.answer.*" %>
<%@ page import="java.util.*" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username != null && password != null) {
        // Logged in
            try {
                SurveyAdmin user = new SurveyAdmin(username, password);
                Survey s= new Survey("Should I Buy this Car?");

                ArrayList<String> ans1= new ArrayList<>();
                ans1.add("<2000");
                ans1.add("2000-4000");
                ans1.add(">4000");
                Question q= new Question("Car Price?",ans1);
                s.addQuestion(q);
                ArrayList<String> ans2= new ArrayList<>();
                ans2.add("Yes");
                ans2.add("No");
                 s.addQuestion("Is it new?", ans2);
                // code here
                %>
                <!--div for title of survey -->
                <div class="container">

                    <h2><%=s.getTitle()%></h2>

                 <h3 class="container">Attributes:</h4>

                 <%
                    for(Question q4: s.getQuestions()){
                        %><h5><%=q4.getTitle()%></h6><%
                    }
                  %>


           <% ArrayList<SurveyResponse> r=s.takeSurvey();
                 int counter=1;
                  %><ul><%
                for(SurveyResponse r1: r){
                    %>

                        <li>Question <%=counter%> :
                    <%
                 for(String t: r1.getResponses()){
                 %>
                    <%=t     %>
                  <%

                 }
                 %> </li>
                <!--div for Yes No responses -->
                                   <div class="Container">
                                       <form>
                                           <input type="radio" name="response" value="Yes" checked> Yes<br>
                                           <input type="radio" name="response" value="No"> No<br>

                                       </form>
                                   </div> <%
                    counter=counter+1;
                  }%>
                </ul>
                <!--div: enumerate each question with a random answer -->





                <!--div for submit and continue button -->
                <div class="container">
                    <form>
                        <input type="submit" value="Submit">

                    </form>
                </div>
</div>
                <style>
                    .container {
                        text-align: center;
                        margin-top: 2rem;

                        font-family: sans-serif;
                    }
                </style>
       <%
        } catch (Exception e) { e.printStackTrace(); }
    } else {
        // Not logged in
        %>Not logged in!<%
    }
%>