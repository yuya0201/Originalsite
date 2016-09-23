<%-- 
    Document   : reviewsConfirm
    Created on : 2016/09/09, 15:34:07
    Author     : yuya
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.ReviewsDataBeans"%>
<%
    HttpSession hs = request.getSession();
    ReviewsDataBeans rdb = ( ReviewsDataBeans)session.getAttribute("rdb");
    JumsHelper jh = new  JumsHelper();
    ArrayList<String> chkList = rdb.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>レビュー登録確認</h1>
        <% if(chkList.size()==0){ %> 
            感想:<br>
            <%=rdb.getReviews()%><br>
            評価:<br>
            <%=rdb.getEvaluation()%><br>
        上記の内容で口コミを登録しますか？
        <form action="ReviewsComplete" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <%}else{%>
        <h1>入力が不完全です</h1>
            <%=jh.chkinput(chkList)%>
            <% } %>
        <form action="reviews.jsp" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
        </form>       
           <%=JumsHelper.getInstance().home()%>
    </body>
</html>
