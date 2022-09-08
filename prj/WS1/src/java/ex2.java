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

/**
 *
 * @author duypham0705
 */
public class ex2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
//            if (!Input.checkDouble(request.getParameter("a"))) {
//                out.println("re-input a");
//                return;
//            }
//            if (!Input.checkDouble(request.getParameter("b"))) {
//                out.println("re-input b");
//                return;
//            }
//            if (!Input.checkDouble(request.getParameter("c"))) {
//                out.println("re-input c");
//                return;
//            }
//
//            double a = Double.parseDouble(request.getParameter("a"));
//            double b = Double.parseDouble(request.getParameter("b"));
//            double c = Double.parseDouble(request.getParameter("c"));
//
//            double max = Math.max(a, Math.max(c, b));
//            double min = Math.min(a, Math.min(c, b));
//            String selection = request.getParameter("selection");
//            if (request.getParameter("find") != null) {
//                if (selection.equalsIgnoreCase("max")) {
//                    out.println("Result max :" + max);
//                    return;
//                } else if (selection.equalsIgnoreCase("min")) {
//                    out.println("Result min :" + min);
//                    return;
//                }
//            }
            if (request.getParameter("a").isEmpty()) {
                out.println("re-input ID");
                return;
            }

            String id = request.getParameter("a");
            out.println("ID Student : " + id);
            out.println("<br>");
            if (request.getParameter("b").isEmpty()) {
                out.println("re-input Name");
                return;
            }
            String name = request.getParameter("b");
            out.println("Full Name : " + name);
            out.println("<br>");
            String selection = request.getParameter("selection");
            if (request.getParameter("find") != null) {
                if (selection.equalsIgnoreCase("max")) {
                    out.println("Gender : male ");
                    out.println("<br>");
                    return;
                } else if (selection.equalsIgnoreCase("min")) {
                    out.println("Gender : male ");
                    out.println("<br>");
                    return;
                }
            }

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method. rr
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

    private static boolean check(double set, double max) {
        if (max == set) {
            return true;
        }
        return false;
    }

    private static boolean checkSelection(String mess) {

        if (mess.equalsIgnoreCase("min") || mess.equalsIgnoreCase("max")) {
            return true;
        }
        return false;
    }

}
