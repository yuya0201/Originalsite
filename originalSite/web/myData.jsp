<%-- 
    Document   : myData
    Created on : 2016/09/21, 11:37:10
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataDTO"%>
<%
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)session.getAttribute("udd");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(udd!=null)%>
        <%for(int i=0; i<udd.size(); i++){%>
        <%=udd.get(i).getEvaluation()%>
        <%=udd.get(i).getReviews()%>   
        <%}%>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
