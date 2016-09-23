/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonNode;

/**
 *
 * @author yuya
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                try{
                    HttpSession hs = request.getSession();
                   Json js = new Json();
                    //商品検索用URL
                    String url ="http://webservice.recruit.co.jp/beauty/salon/v1/?";
                    //アプリケーションID
                    String apiID ="acee8608d690f926";
                    //検索formからユーザーが入力するクエリ                    
                    String order =request.getParameter("order");
                    String name  =request.getParameter("salon");
                    //ユーザーが入力した情報をエンコード
                    String encodeResult = URLEncoder.encode(name,"UTF-8");
   
                    String json = js.getResult(url+"order="+order+"&format=json"+"&name="+encodeResult+"&key="+apiID);
                    
                    JsonNode jn = js.getJsonNode(json);
                    
                    ArrayList<SalonBeans> salonList =  new ArrayList<SalonBeans>();
                    
                    salonList = js.getSalonList(jn);
                                  
                    
                    hs.setAttribute("salonList",salonList);
                    hs.setAttribute("url", "/search.jsp");
                    
                    request.getRequestDispatcher("/searchresult.jsp").forward(request, response);

                 }catch(Exception e){                  
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
           request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
       }
   
              
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}