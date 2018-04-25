<%@ page import="vizdiztree.survey.*" %>
<%@ page import="vizdiztree.answer.*" %>
<%@ page import="java.util.*" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username != null && password != null) {
        // Logged in
            try {
                SurveyAdmin s = new SurveyAdmin(username, password);
                int done=0;
                // code here
                %>
                <!--div for title of survey -->
                <div class="container">
                    <h2>Survey Title</h2>
                </div>

                <h4 class="container">Attributes:</h4>

                <!--div: enumerate each question with a random answer -->
                <div class="container">
                    <ul>
                        <li>Question 1: Random Answer</li>
                    </ul>
                </div>

                <!--div for Yes No responses -->
                <div class="Container">
                    <form>
                        <input type="radio" name="response" value="Yes" checked> Yes<br>
                        <input type="radio" name="response" value="No"> No<br>

                    </form>
                </div>

                <!--div for submit and continue button -->
                <div class="container">
                    <form>
                        <input type="submit" value="Continue">

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
        } catch (Exception e) { e.printStackTrace(); }
    } else {
        // Not logged in
        %>Not logged in!<%
    }
%>