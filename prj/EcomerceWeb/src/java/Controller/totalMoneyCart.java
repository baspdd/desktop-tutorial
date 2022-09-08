/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DaoProduct;
import Model.Account;
import Model.product;
import Support.StringHelper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author kienb
 */
public class totalMoneyCart extends HttpServlet {

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
            List<product> listP = new ArrayList<>();
            DaoProduct dpro = new DaoProduct();
            String txt = "";
            Cookie[] cookies = request.getCookies();
            for (Cookie i : cookies) {
                if (i.getName().equals("Cart" + a.getUsername())) {
                    txt = i.getValue();
                }
            }
            if (!txt.isEmpty()) {
                String[] temp = txt.split("/");
                HashMap<String, Integer> list = new HashMap<>();
                for (int i = 0; i < temp.length; i += 2) {
                    list.put(temp[i], Integer.parseInt(temp[i + 1]));
                }
                for (String i : list.keySet()) {
                    product p = dpro.getProductByID(i);
                    p.setQuantity(list.get(i));
                    listP.add(p);
                }
            }
            double totalMoney = 0;
            for (product i : listP) {
                totalMoney += i.getPrice() * i.getQuantity();
            }
            double totalMoneyVAT = totalMoney + totalMoney * 0.1;
            out.println(" <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng tiền hàng</strong><strong>" + StringHelper.printPrice(totalMoney) + "</strong></li>\r\n"
                    + "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Phí vận chuyển</strong><strong>Free ship</strong></li>\r\n"
                    + "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">VAT</strong><strong>10 %</strong></li>\r\n"
                    + "                                        <li class=\"d-flex justify-content-between py-3 border-bottom\"><strong class=\"text-muted\">Tổng thanh toán</strong>\r\n"
                    + "                                            <h5 class=\"font-weight-bold\">" + StringHelper.printPrice(totalMoneyVAT) + "</h5>\r\n"
                    + "                                        </li>");
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
