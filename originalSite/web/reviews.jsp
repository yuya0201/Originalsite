<%-- 
    Document   : reviews
    Created on : 2016/09/09, 14:46:04
    Author     : yuya
--%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.ReviewsDataBeans"%>
<%
    HttpSession hs = request.getSession();
    ReviewsDataBeans rdb = new  ReviewsDataBeans();
    UserDataDTO ud = (UserDataDTO)hs.getAttribute("ud");
    
      boolean reinput = false;
            if(request.getParameter("mode")!=null && request.getParameter("mode").equals("REINPUT")){
                reinput = true;
                rdb = (ReviewsDataBeans)hs.getAttribute("rdb");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>担当スタイリストへの一言</h1>
        <%if(ud!=null){%>
        <form action="ReviewsConfirm" method="POST">
            評価:<select name="evaluation"><br>
                        <option value="">--</option>
                    <% for(int i = 1; i<=5; i++){ %>
                        <option value="<%=i%>"<%if(reinput){out.println(rdb.getEvaluation());}%>><%=i%></option>
                    <% } %>
                </select><br>
            ご感想:<br>
            <textarea name="reviews" rows="4" cols="40" ><%if(reinput){out.println(rdb.getReviews());}%></textarea><br>
            <input type="submit" name="btnSubmit" value="口コミ登録画面へ">
        </form>
            <%}%>
               <%=JumsHelper.getInstance().home()%>
    </body>
</html>
