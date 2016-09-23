<%-- 
    Document   : salonDetail
    Created on : 2016/09/14, 12:02:55
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.SalonDataDTO"%>
<%@page import="jums.ReviewsDataBeans"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="jums.SalonBeans"%>
<%@page import="java.util.ArrayList"%>
<%
     HttpSession hs = request.getSession();
     SalonBeans sb = (SalonBeans)hs.getAttribute("sb");
     ReviewsDataBeans rdb = new ReviewsDataBeans();
     UserDataDTO ud = (UserDataDTO)hs.getAttribute("ud");
     ArrayList<SalonDataDTO> ary = (ArrayList<SalonDataDTO>)hs.getAttribute("ary");
    
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
        <table border="1">
            <tr>
                <th>名前</th><br>
                <th>アクセス</th><br>
                <th>アクセスナビ</th><br>
                <th>住所</th><br>
                <th>席数</th><br>
                <th>キャッチコピー</th><br>
                <th>定休日</th><br>
                <th>イメージ</th><br> 
            </tr>
            <tr>
             <td><%=sb.getName()%></td>
               <td><%=sb.getAccess()%></td>
               <td><%=sb.getAccess_navi()%></td>
               <td><%=sb.getAddres()%></td>
               <td><%=sb.getCapacity()%></td>
               <td><%=sb.getCatch_copy()%></td>
               <td><%=sb.getClose()%></td>
     <td><img src="<%=sb.getImage()%>"></td>
            </tr>
        </table>
        <table border="2">          　　　
　　　　　<tr>
　　　　　　  <th>スタイリストへの一言欄</th>
            <th>評価</th>
　　　　　</tr>         
               <%for(int i=0; i<ary.size(); i++){%><tr>
                <td><%=ary.get(i).getReviews()%></td><br>
                <td><%=ary.get(i).getEvaluation()%></td><br>
            </tr>
                 <%}%> 
        </table>
              <%if(ud!=null){%>
                <h1>こちらのサロンの担当スタイリストへの一言</h1>
        <form action="ReviewsConfirm" method="POST">
            評価:<select name="evaluation"><br>
                        <option value="">--</option>
                    <% for(int i = 1; i<=5; i++){ %>
                        <option value="<%=i%>"<%if(reinput){out.println(rdb.getEvaluation());}%>><%=i%></option><br>
                    <% } %>
                </select><br>
            ご感想:<br>
            <textarea name="reviews" rows="4" cols="40" ><%if(reinput){out.println(rdb.getReviews());}%></textarea><br>
            <input type="submit" name="btnSubmit" value="口コミ登録画面へ">
            <%}else{%>
            <a href="login.jsp">ログインしてから口コミを書いて下さい</a>
            <%}%>
            <a href="<%=sb.getUrl()%>">お店の予約はこちらへ</a>
            <%=JumsHelper.getInstance().home()%>
            
    </body>
</html>
