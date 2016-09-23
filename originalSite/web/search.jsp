<%-- 
    Document   : search
    Created on : 2016/09/07, 15:37:02
    Author     : yuya
--%>
<%@page import="jums.UserDataDTO"%>
<%
    UserDataDTO udd = (UserDataDTO)session.getAttribute("ud");
%>
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Search" method="GET">
               <input type="text" name="salon" value=""><br>
         かな順：<input type="radio" name="order" value="1"><br>
  エリアコード順：<input type="radio" name="order" value="2"><br>
 ビューティお勧め順<input type="radio" name="order" value="3"><br>
        サロン検索<input type="submit" name="サロン検索">
        </form>
        <%if(udd!=null){%>
        <form action="MyData">         
            <input type="submit" name="mydata" value="マイデータはこちら">        
        </form>
        <%}else{%>
        <form action="login.jsp" method="POST">
            <input type="submit" name="login" value="ログインはこちら">
        </form>
        <%}%>
        <form action="memberRegistration.jsp" method="POST">
            <input type="submit" name="member" value="新規会員登録はこちらへ">
        </form>
    </body>
</html>
