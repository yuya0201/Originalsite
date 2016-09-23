<%-- 
    Document   : searchresult.jsp
    Created on : 2016/09/07, 15:50:26
    Author     : yuya
--%>
<%@page import="jums.JumsHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.SalonBeans"%>
<%
    HttpSession hs = request.getSession();
    ArrayList<SalonBeans> salonList = (ArrayList<SalonBeans>)hs.getAttribute("salonList");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>検索結果</h1>
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
             <%for(int i=0; i<salonList.size(); i++){%>
             <td><a href="Salon?code=<%=i%>"><%=salonList.get(i).getName()%></td>
               <td><%=salonList.get(i).getAccess()%></td>
               <td><%=salonList.get(i).getAccess_navi()%></td>
               <td><%=salonList.get(i).getAddres()%></td>
               <td><%=salonList.get(i).getCapacity()%></td>
               <td><%=salonList.get(i).getCatch_copy()%></td>
               <td><%=salonList.get(i).getClose()%></td>
     <td><img src="<%=salonList.get(i).getImage()%>"></td>
           </tr>
           <%}%>
           </table>
               <%=JumsHelper.getInstance().home()%>
    </body>
</html>
