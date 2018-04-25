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
                  %>
                  <form action="takesurvey.jsp">
                        <input type="hidden" name="username" value="<%= username %>" />
                        <input type="hidden" name="password" value="<%= password %>" />
                  <ul><%
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

                                           <input type="radio" name="response<%=counter%>" value="Yes" checked> Yes<br>
                                           <input type="radio" name="response<%=counter%>" value="No"> No<br>


                                   </div> <%
                    counter=counter+1;
                  }%>
                </ul>


                  <input type="submit" value="Submit">

              </form>
</div>
                <style>
                    .container {
                        text-align: center;
                        margin-top: 2rem;

                        font-family: sans-serif;
                    }
                </style>
       <%

       //I know its crappy; need to fix
       ArrayList<String> resp=new ArrayList<>();
       resp.add(request.getParameter("response1"));
        resp.add(request.getParameter("response2"));
        resp.add(request.getParameter("response3"));
        resp.add(request.getParameter("response4"));
        resp.add(request.getParameter("response5"));
        resp.add(request.getParameter("response6"));
        resp.add(request.getParameter("response7"));
        resp.add(request.getParameter("response8"));
        resp.add(request.getParameter("response9"));
        resp.add(request.getParameter("response10"));

        int index=0;
        if(resp.get(index)!=null){
        for(SurveyResponse ri: r){
            ri.addResponse(resp.get(index));
            index=index+1;
        }
        s.setResponses(r);
         %> <script type="text/javascript"> window.location.href = "mainmenu.jsp?username=<%= username %>&password=<%= password %>";</script> <%
        }

        } catch (Exception e) { e.printStackTrace(); }
    } else {
        // Not logged in
        %>Not logged in!<%
    }
%>