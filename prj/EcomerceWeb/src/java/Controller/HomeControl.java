/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DaoCategory;
import DAO.DaoProduct;
import Model.Account;
import Model.Category;
import Model.product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author kienb
 */
public class HomeControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        int count = 0;
        Account acc = (Account) session.getAttribute("acc");
        if(acc != null){
            String txt = "";
            Cookie[] cookies = request.getCookies();
            for(Cookie i : cookies){
                if(i.getName().equals("Cart" + acc.getUsername())){
                    txt = i.getValue();
                }
            }
            String[] temp = txt.split("/");
            count = temp.length / 2;
        }
        session.setAttribute("NumberOfCart", count==0?"" : count+"");
        DaoProduct dpro = new DaoProduct();
        DaoCategory dcate = new DaoCategory();
        List<Category> listCategory = dcate.listAllCategory();
        List<product> listProduct = dpro.getTop3();
        List<product> list8Last = dpro.get8Last();
        List<product> list4LapTopLast = dpro.get4LaptopLast();
        List<product> list4SmartPhoneLast = dpro.get4SmartPhoneLast();
        product last = dpro.getLast();
        request.setAttribute("listP", listProduct);
        request.setAttribute("listCC", listCategory);
        request.setAttribute("list8Last", list8Last);
        request.setAttribute("list4LapTopLast", list4LapTopLast);
        request.setAttribute("list4SmartPhoneLast", list4SmartPhoneLast);
        request.setAttribute("p", last);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
