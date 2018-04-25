<%@ page import="vizdiztree.survey.SurveyAdmin" %>
<div class="container">
    <h1>Survey Tree</h1>
    <h4>A Decision Tree Visualization and Learning Tool</h4>
</div>

<img src="img/logo.png" style="width:200px;height:300px; " class="center">

<div class="container">
    <form>
        <fieldset>
            <legend>
                Sign Up
            </legend>

            <!--div for username and password boxes-->
            <div>
                <form action="signup.jsp">
                    Username:<br />
                    <input type="text" name="username"><br />
                    Password:<br />
                    <input type="password" name="password1"><br />
                    Retype Password:<br />
                    <input type="password" name="password2"> <br />
                    <input type="submit" value="Sign Up">
                </form>
            </div>

            <!--div for login and sign up buttons -->
            <div>


            </div>

        </fieldset>
    </form>
</div>



<center><b>
<%
    String username = request.getParameter("username");
    String password1 = request.getParameter("password1");
    String password2 = request.getParameter("password2");
    if(username != null && password1 != null && password2 != null && !username.equals("")) {
        if (password1.equals(password2)) {
            if(SurveyAdmin.addAdmin(username, password1)) {
                %>
                Created! Redirecting...
                <script type="text/javascript">
                    window.setTimeout(function(){
                        window.location.href = "index.jsp";
                    }, 2000);
                </script>
                <%
            } else {
                %>User already exists!<%
            }
        } else {
            %>Passwords do not match!<%
        }
    } else {
        // Not filled out
    }
%>
</b></center>

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