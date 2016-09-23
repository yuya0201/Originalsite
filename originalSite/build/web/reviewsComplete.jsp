<%-- 
    Document   : reviewsComplete
    Created on : 2016/09/09, 16:17:00
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.ReviewsDataBeans"%>
<%
    HttpSession hs = request.getSession();
    ReviewsDataBeans rdb = (ReviewsDataBeans)hs.getAttribute("rdb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>口コミを登録しました</h1>
        <%=rdb.getEvaluation()%><br>
        <%=rdb.getReviews()%><br>
           <%=JumsHelper.getInstance().home()%>
    </body>
</html>
