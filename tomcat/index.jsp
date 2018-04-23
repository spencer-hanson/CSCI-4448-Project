<div class="container">
    <h1>Survey Tree</h1>
    <h4>A Decision Tree Visualization and Learning Tool</h4>
</div>

<%@ page import="vizdiztree.survey.SurveyAdmin" %>


<img src="img/logo.png" style="width:200px;height:300px; " class="center">
<div class="container">
    <form>
        <fieldset>
            <legend>
                Login
            </legend>

            <!--div for username and password boxes-->
            <div>
                <form action="index.jsp">
                    Username:<br />
                    <input type="text" name="username"><br>
                    Password:<br />
                    <input type="password" name="password">
                    <br />
                    <input type="submit" value="Login">
                </form>
            </div>

            <!--div for login and sign up buttons -->
            <div>


                <form action="signup.jsp">
                    <input type="submit" value="Sign Up">
                </form>
            </div>

        </fieldset>
    </form>
</div>

<%
    String username = request.getParameter("username");
    if(username != null) {
        String password = request.getParameter("password");
        if(SurveyAdmin.tryLogin(username, password)) {
            %> <script type="text/javascript"> window.location.href = "surveyeditor.jsp?username=<%= username %>";</script> <%
        } else {
            %><center><b>Invalid Login!</b></center> <%
        }
    } else {
        // Not logged in
    }
%>

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