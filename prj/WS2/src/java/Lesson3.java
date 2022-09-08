/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Context.UserDAO;
import Validate.Input;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author duypham0705
 */
public class Lesson3 extends HttpServlet {

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
        String ret = "";
        if (!Input.checkInt(request.getParameter("numberInput"), 3, Integer.MAX_VALUE)) {
            ret = "Enter an integer n";
            request.setAttribute("ret", ret);
            request.getRequestDispatcher("Lesson3.jsp").forward(request, response);
            return;
        }
        int n = Integer.parseInt(request.getParameter("numberInput"));
        request.setAttribute("n", n);
        UserDAO user = new UserDAO();
        if (user.checkInum(n)) {
            ret = n + " result : " + user.getResult(n,3);
        } else {
            ret = n + " does not exist in database";
        }
        request.setAttribute("ret", ret);
        if (request.getParameter("set") != null) {
            String result = "", sum = "";

            if (user.checkInum(n)) {
                result = setString(n);
                sum = sum(n);
                user.update(n, "array :" + result + " sum : " + sum,3);
            } else {
                result = "No results";
            }
            request.setAttribute("ret", result);
            request.setAttribute("sum", sum);

        }
        request.getRequestDispatcher("Lesson3.jsp").forward(request, response);

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

    private String setString(int n) {
        String ret = "";
        for (int i = 0; i < n; i += 2) {
            ret = ret + " " + i;
        }
        return ret;
    }

    private String sum(int n) {
        int sum = 0;
        for (int i = 0; i < n; i += 2) {
            sum += i;
        }
        return String.valueOf(sum);
    }

}
