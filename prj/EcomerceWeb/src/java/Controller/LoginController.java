/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DaoAcc;
import Model.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author kienb
 */
public class LoginController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DaoAcc acc = new DaoAcc();
        if (acc.checkAccountExist(username, password)) {
            HttpSession session = request.getSession();
            Account account = acc.checkUsernameExisted(username);
            session.setAttribute("acc", account);
            Cookie[] list = request.getCookies();
            String txt = "";
            int count = 0;
            for (Cookie i : list) {
                if (i.getName().equals("name") || i.getName().equals("pass")) {
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
                if (i.getName().equals("Cart" + username)) {
                    txt = i.getValue();
                }
            }
            if (!txt.isEmpty()) {
                String[] t = txt.split("/");
            }
            Cookie name = new Cookie("name", username);
            Cookie pass = new Cookie("pass", password);
            name.setMaxAge(3600 * 24);
            pass.setMaxAge(3600 * 24);
            response.addCookie(name);
            response.addCookie(pass);
            response.sendRedirect("HomeControl");
        } else {
            request.setAttribute("error", "Username or password not match. Please try again!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
