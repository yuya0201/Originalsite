<%-- 
    Document   : login
    Created on : 2016/09/12, 16:39:25
    Author     : yuya
--%>

<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginConfirmation" method="POST">
            <input type="text" name="name"  placeholder="ユーザーの名前を入力して下さい" size="26"><br>
            <input type="text" name="password" placeholder="パスワードを入力して下さい" size="22" ><br>
            <input type="submit" value="ログイン">
        </form>
           <%=JumsHelper.getInstance().home()%>   
 
    </body>
</html>
