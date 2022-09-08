/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

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
public class ex5 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("string").isEmpty()) {
                out.println("Nhập lại xâu");
                return;
            }
            String ret = request.getParameter("string");
            out.println("Nhập thành công");
            out.println("<br>Tổng số ký tự : " + ret.length());
            if (Input.checkInt(request.getParameter("index"), 0, Integer.MAX_VALUE)) {
                int index = Integer.parseInt(request.getParameter("index"));
                out.println("<br>Ký tự vị trí " + index + " là " + ret.charAt(index));
            }

            if (!request.getParameter("element").isEmpty()) {
                String subString = request.getParameter("element");
                if (ret.indexOf(subString) > -1) {
                    out.println("<br>vị trí tương ứng" + ret.indexOf(subString));
                } else {
                    out.println("<br>" + subString + " không thuộc xâu  ");
                }
            }

            if (Input.checkInt(request.getParameter("begin"), 0, Integer.MAX_VALUE)) {
                int begin = Integer.parseInt(request.getParameter("begin"));
                if (Input.checkInt(request.getParameter("begin"), begin, Integer.MAX_VALUE)) {
                    int end = Integer.parseInt(request.getParameter("end"));
                    out.println("<br>Xâu tương ứng " + ret.substring(begin, end + 1));

                } else {
                    out.println("reinput end");
                }

            }
        }

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
