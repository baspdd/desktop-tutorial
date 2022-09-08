/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;

/**
 *
 * @author kienb
 */
public class addToCartByAjax extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            String id = request.getParameter("productID");
            int number = Integer.parseInt(request.getParameter("number"));
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("acc");
            if(acc == null){
                response.sendRedirect("login.jsp");
                return;
            }
            String txt = "";
            int count = 0;
            Cookie[] cookies = request.getCookies();
            for (Cookie i : cookies) {
                if (i.getName().equals("Cart" + acc.getUsername())) {
                    txt = i.getValue();
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
            }
            if (txt.isEmpty()) {
                txt = id + "/" + number;
                count = 1;
            } else {
                String temp1 = "";
                String[] temp = txt.split("/");
                HashMap<String, Integer> list = new HashMap<>();
                for (int i = 0; i < temp.length; i += 2) {
                    list.put(temp[i],Integer.parseInt(temp[i+1]));
                }
                if(list.containsKey(id)){
                    list.put(id, list.get(id) + number);
                }
                else {
                    list.put(id, number);
                }
                for(String i : list.keySet()){
                    temp1 += i + "/" + list.get(i) + "/";
                }
                txt = temp1.substring(0, temp1.length()-1);
                count = list.size();
            }
            Cookie c = new Cookie("Cart" + acc.getUsername(), txt);
            c.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(c);
            out.print(count == 0?"" : count + "");
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
