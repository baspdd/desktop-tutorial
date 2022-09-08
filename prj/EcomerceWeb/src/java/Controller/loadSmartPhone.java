/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DaoProduct;
import Model.product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author kienb
 */
public class loadSmartPhone extends HttpServlet {

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
        String amount = request.getParameter("exitsSmartPhone");
        int iamount = Integer.parseInt(amount);
        DaoProduct dao = new DaoProduct();
        List<product> list = dao.getNext4SmartPhoneProduct(iamount);
        PrintWriter out = response.getWriter();
        for (product o : list) {
            out.println("<div class=\"productSmartPhone col-12 col-md-6 col-lg-3\">\r\n"
                    + "                                <div class=\"card\">\r\n"
                    + "                                 <div class=\"view zoom z-depth-2 rounded\">\r\n"
                    + "                                    <img class=\"img-fluid w-100\" src=\"" + o.getImage() + "\" alt=\"Card image cap\">\r\n"
                    + "                                    </div>\r\n"
                    + "                                    <div class=\"card-body\">\r\n"
                    + "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid=" + o.getProduct_id() + "\" title=\"View Product\">" + o.getProduct_name() + "</a></h4>\r\n"
                    + "                                        <p class=\"card-text show_txt\">" + o.getTiltle() + "</p>\r\n"
                    + "                                        <div class=\"row\">\r\n"
                    + "                                            <div class=\"col\">\r\n"
                    + "                                                <p class=\"btn btn-success btn-block\">" + o.displayPrice() + "</p>\r\n"
                    + "                                            </div>\r\n"
                    + "                                            \r\n"
                    + "                                        </div>\r\n"
                    + "                                    </div>\r\n"
                    + "                                </div>\r\n"
                    + "                            </div>");
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
