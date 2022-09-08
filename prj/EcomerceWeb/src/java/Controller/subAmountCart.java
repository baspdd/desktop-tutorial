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
public class subAmountCart extends HttpServlet {

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
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login");
                return;
            }
            String productID = request.getParameter("productID");
            String txt = "";
            Cookie[] cookies = request.getCookies();
            for (Cookie i : cookies) {
                if (i.getName().equals("Cart" + a.getUsername())) {
                    txt = i.getValue();
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
            }
            String temp1 = "";
            String[] temp = txt.split("/");
            HashMap<String, Integer> list = new HashMap<>();
            for (int i = 0; i < temp.length; i += 2) {
                list.put(temp[i], Integer.parseInt(temp[i + 1]));
            }
            if (list.get(productID) == 1) {
                list.remove(productID);
                if (list.isEmpty()) {
                    response.sendRedirect("managerCart");
                    return;
                }
            } else {
                list.put(productID, list.get(productID) - 1);
            }
            for (String i : list.keySet()) {
                temp1 += i + "/" + list.get(i) + "/";
            }
            txt = temp1.substring(0, temp1.length() - 1);
            Cookie c = new Cookie("Cart" + a.getUsername(), txt);
            c.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(c);
            session.setAttribute("mess", "Da giam so luong!");
            response.sendRedirect("managerCart");
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
