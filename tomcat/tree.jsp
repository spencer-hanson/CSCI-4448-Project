<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username != null && password != null) {
        // Logged in

            %>
                <img src="img/logo.png" style="width:100px;height:160px; " class="center">

                 <form action="mainmenu.jsp">
                     <input type="hidden" name="username" value="<%= username %>" />
                     <input type="hidden" name="password" value="<%= password %>" />
                     <input type="submit" value="Main Menu">
                 </form>
                 <%

     }else {
         // Not logged in
         %>Not logged in!<%
     }
 %>
