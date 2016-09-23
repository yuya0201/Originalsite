<%-- 
    Document   : memberRegistration
    Created on : 2016/09/09, 10:33:03
    Author     : yuya
--%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();

        boolean reinput = false;
            if(request.getParameter("mode")!=null && request.getParameter("mode").equals("REINPUT")){
                reinput = true;
                udb = (UserDataBeans)hs.getAttribute("udb");
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
                 <h1>新規会員登録</h1>
        <form action="MemberRegistrationConfirm" method="POST">
   ユーザー名:<input type="text" name="name" value="<%if(reinput){out.println(udb.getName());}%>"><br>
   パスワード:<input type="text" name="password"  value="<%if(reinput){out.println(udb.getPassword());}%>"><br>
      メール:<input type="text" name="mail"  value="<%if(reinput){out.println(udb.getMail());}%>"><br>           
        住所:<input type="text" name="addres"  value="<%if(reinput){out.println(udb.getAddres());}%>"><br>  
        <input type="submit"   name="btnSubmit"  value="登録確認画面へ">
        </form>
              <%=JumsHelper.getInstance().home()%>
    </body>
</html>
