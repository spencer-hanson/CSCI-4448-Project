<%@ page import="vizdiztree.survey.*" %>
<%@ page import="vizdiztree.answer.*" %>
<%@ page import="vizdiztree.surveytree.*" %>
<%@ page import="java.util.*" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username != null && password != null) {
        // Logged in
            try {
                SurveyAdmin user = new SurveyAdmin(username, password);
                int done=0;
                // code here
                %>

            <div class="container">
                <form>
                    <fieldset>
                    <legend>
                        SurveyTree
                    </legend>
                    <h1>Main Menu</h1>
                    </fieldset>
                </form>
            </div>

             <div class="container">

                        <div>
                            <img src="img/plus.png" style="width:100px;height:100px; " class="center">
                            <form action="surveyeditor.jsp">
                                <input type="hidden" name="username" value="<%= username %>" />
                                <input type="hidden" name="password" value="<%= password %>" />
                                <input type="submit" value="New Survey">
                            </form>
                        </div>
                <h2> My Surveys</h2>
              <%  for(Survey s: user.getSurveys()){

              %>
                        <div>
                            <fieldset>
                            <legend>
                             <h4><%=s.getTitle()%></h4>
                             </legend>
                            <form action="takesurvey.jsp">
                                <input type="hidden" name="username" value="<%= username %>" />
                                <input type="hidden" name="password" value="<%= password %>" />
                                <input type="hidden" name="surveyTitle" value="<%= s.getTitle()%>" />
                                <input type="submit" value="Take Survey">
                            </form>

                            <form action="mainmenu.jsp">
                                 <input type="hidden" name="username" value="<%= username %>" />
                                 <input type="hidden" name="password" value="<%= password %>" />
                                 <input type="hidden" name="surveyTitle" value="<%= s.getTitle()%>" />
                                <input type="submit" value="View Tree">
                            </form>
                            </fieldset>
                        </div>
                <% } %>
            </div>

            <style>
                .container {
                    text-align: center;
                    margin-top: 3rem;

                    font-family: sans-serif;
                }

                .center {
                    display: block;
                    margin-left: auto;
                    margin-right: auto;
                    width: 50%;
                }
            </style>
<%
         String surveyTitle= request.getParameter("surveyTitle");
          if(surveyTitle!=null){
               Survey s= user.findSurvey(surveyTitle);
                s.createKeys();
                s.convertResponses();
                SurveyTree st =  new SurveyTree();
                st.setSurvey(s);
                Exception r=st.buildTree();
                st.writeData(s.getConvertedResponses());
                st.writeQuestions();
                %><%=r%><%
            }


            } catch (Exception e) { e.printStackTrace(); }
    } else {
        // Not logged in
        %>Not logged in!<%
    }
%>