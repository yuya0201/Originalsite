<%-- 
    Document   : memberRegistrationComplete
    Created on : 2016/09/09, 11:34:15
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs =  request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録結果</h1>
            <%=udb.getName()%><br>
            <%=udb.getPassword()%><br>
            <%=udb.getMail()%><br>
            <%=udb.getAddres()%><br>
            <%=JumsHelper.getInstance().home()%>
    </body>
</html>
