<%-- 
    Document   : memberRegistrationConfirm
    Created on : 2016/09/09, 10:50:32
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataBeans"%>
<%
    JumsHelper jh = new  JumsHelper();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    ArrayList<String> chkList = udb.chkproperties();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録確認</h1>
        <% if(chkList.size()==0){ %>
            <%=udb.getName()%><br>
            <%=udb.getPassword()%><br>
            <%=udb.getMail()%><br>
            <%=udb.getAddres()%><br>
            上記の内容で登録します。よろしいですか？
        <form action="MemberRegistrationComplete" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <%}else{%>
              <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList)%>
        <% } %>
        <form action="memberRegistration.jsp" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
        </form>
           <%=JumsHelper.getInstance().home()%>
    </body>
</html>
