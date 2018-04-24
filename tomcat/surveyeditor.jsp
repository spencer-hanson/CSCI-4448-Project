<%@ page import="vizdiztree.survey.SurveyAdmin" %>
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
                <head>
                    <script type="text/javascript">
                        var Questioncount=2;
                        var AnswerCount=3;
                        function addTextArea(){

                            var div = document.getElementById('div_quotes[]');
                            div.innerHTML += "<input name='Answer" +AnswerCount.toString()+ "' value='Enter Answer' />";
                           //div.innerHTML += "\n<br />";
                           AnswerCount=AnswerCount+1;
                        }
                        function addTextArea1(){
                            AnswerCount=AnswerCount+1;
                            var div = document.getElementById('div_quotes1');
                            div.innerHTML += "<div ><form action='surveyeditor.jsp'><fieldset><legend><form><input size='40' type='text' value='Enter Question Title Here'></form></div></legend><div>Answers:<br><input size='15' type='text' name='Answer"+AnswerCount+"' value='Enter Answer'><div id='div_quotes[]'></div><input type='button' value='Add Answer'  onClick='addTextArea();'></div><input type='submit' value='Save' ></fieldset></form></div>";
                           div.innerHTML += "\n<br />";
                            QuestionCount=QuestionCount+1;
                        }

                    </script>
                </head>
                <div style=" text-align: right;">
                    Hello, Admin!
                    <form>
                        <input type="button" value="Log Out">
                    </form>
                </div>
                <img src="img/logo.png" style="width:100px;height:160px; " class="center">

                <!--div for entering survey title -->
                <div class="container">
                    <form action="surveyeditor.jsp">
                        <input size="64" type="text" name="SurveyTitle" value="Enter Survey Title Here">
                        <input type="submit" value="Save" >
                    </form>
                </div>

                <div >
                    <form action="surveyeditor.jsp">
                        <fieldset>
                            <legend>
                                <!--div for entering question title -->
                                <div>
                                    <form>
                                        <input size="40" type="text" name="Question1" value="Enter Question Title Here">
                                    </form>
                                </div>

                            </legend>

                            <!--div for adding answers -->
                            <div>
                                Answers:<br>
                                <input size="15" type="text" name="Answer" value="Enter Answer">
                                <input size="15" type="text" name="Answer1" value="Enter Answer">
                                <div id="div_quotes[]"></div>
                                <input type="button" value="Add Answer"  onClick="addTextArea();">
                            </div>
                           <input type="submit" value="Save" >
                        </fieldset>
                    </form>
                </div>

                <!--div for adding more questions -->
                <div id="div_quotes1"></div>

                <div class="container">
                    <form>
                        <fieldset>
                            <input type="button" value="Add Question" onClick="addTextArea1();">
                        </fieldset>
                    </form>
                </div>

                <!--div for save and cancel button -->
                <div class="container">
                    <form>
                        <input type="submit" value="Save" onClick="done();">
                        <input type="button" value="Cancel">
                    </form>
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
            String surveyTitle = request.getParameter("SurveyTitle");
            if(surveyTitle != null) {
                    s.addSurvey(surveyTitle);
             }

            } catch (Exception e) { e.printStackTrace(); }
    } else {
        // Not logged in
        %>Not logged in!<%
    }
%>

