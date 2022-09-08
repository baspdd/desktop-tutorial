/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author duypham0705
 */
public class ex4 extends HttpServlet {

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

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

            String[] procesString = request.getParameter("array").trim().split("\\s+");
            ArrayList<Integer> ret = new ArrayList<Integer>();
            for (String string : procesString) {
                if (Input.checkInt(string, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
                    ret.add(Integer.parseInt(string));
                }
            }
            if (!ret.isEmpty()) {
                out.println("Nhập mảng thành công");
                out.println("<br>");
            }

            String selection = request.getParameter("selection");
            switch (selection) {
                case "insert":
                    break;
                case "export":
                    out.println("Array :");
                    for (int i : ret) {
                        out.println(i);
                    }
                    out.println("<br>");
                    break;
                case "oddNumber":
                    int sum = 0;
                    for (int i : ret) {
                        if (i % 2 != 0) {
                            sum += i;
                        }
                    }
                    if (sum != 0) {
                        out.println("sum = " + sum);
                    } else {
                        out.println("Không có số lẻ");
                    }
                    out.println("<br>");
                    break;
                case "evenNumber":
                    int mul = 1;
                    for (int i : ret) {
                        if (i % 2 == 0) {
                            mul *= i;
                        }
                    }
                    if (mul != 1) {
                        out.println("mul = " + mul);
                    } else {
                        out.println("Không có số chẵn");
                    }
                    out.println("<br>");
                    break;
                case "sort":
                    Collections.sort(ret);
                    out.println("Array : ");
                    for (int i : ret) {
                        out.println(" " + i);
                    }
                    out.println("<br>");
                    break;
                default:
                    throw new AssertionError();
            }
        }
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
