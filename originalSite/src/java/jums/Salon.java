/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yuya
 */
public class Salon extends HttpServlet {

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
                    request.setCharacterEncoding("UTF-8");
                HttpSession hs = request.getSession();
                SalonDataDTO sdd =  new SalonDataDTO();
                SalonBeans sb = new SalonBeans();
                
                int itemcode = Integer.parseInt(request.getParameter("code"));              
                ArrayList<SalonBeans> salonList = (ArrayList<SalonBeans>)hs.getAttribute("salonList");
                
                sb.setName(salonList.get(itemcode).getName());
                sb.setAccess(salonList.get(itemcode).getAccess());
                sb.setAccess_navi(salonList.get(itemcode).getAccess_navi());
                sb.setAddres(salonList.get(itemcode).getAddres());
                sb.setCapacity(salonList.get(itemcode).getCapacity());
                sb.setCatch_copy(salonList.get(itemcode).getCatch_copy());
                sb.setImage(salonList.get(itemcode).getImage());
                sb.setClose(salonList.get(itemcode).getClose());
                sb.setUrl((salonList.get(itemcode).getUrl()));
                
               
                sb.UD2DTOMapping(sdd);
                
                
               SalonDataDTO sd = UserDataDAO.getInstance().salonSearchID(sdd);

                if(sd.getName()==null){
                UserDataDAO.getInstance().salonInsert(sdd);
                sd = UserDataDAO.getInstance().salonSearchID(sdd);
                }
                
          
        ArrayList<SalonDataDTO> ary =   UserDataDAO.getInstance().searchsalonID(sd);
                
                
                //sdを
                sb.DTO2UDMapping(sd);

                hs.setAttribute("sb",sb);
                hs.setAttribute("ary", ary);
                
                request.getRequestDispatcher("/salonDetail.jsp").forward(request, response); 
            
               }catch(Exception e){                  
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
           request.getRequestDispatcher("/salonDetail.jsp").forward(request, response);
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
