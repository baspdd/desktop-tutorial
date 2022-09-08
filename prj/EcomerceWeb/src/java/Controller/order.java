/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DaoOrder;
import DAO.DaoProduct;
import Model.Account;
import Model.Email;
import Model.product;
import Support.EmailUtils;
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
public class order extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            response.sendRedirect("login");
            return;
        }
        String txt = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie i : cookies) {
            if (i.getName().equals("Cart" + a.getUsername())) {
                txt = i.getValue();
            }
        }
        if (txt.isEmpty()) {
            session.setAttribute("mess", "Khong co san pham nao!!");
            response.sendRedirect("managerCart");
        } else {
            String[] temp = txt.split("/");
            HashMap<String, Integer> list = new HashMap<>();
            for (int i = 0; i < temp.length; i += 2) {
                list.put(temp[i], Integer.parseInt(temp[i + 1]));
            }
            DaoOrder dorder = new DaoOrder();
            for (String i : list.keySet()) {
                dorder.insertOrder(a.getId(), i, list.get(i));
            }
            response.sendRedirect("DatHang.jsp");
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
        try {
            String emailAddress = request.getParameter("email");
            String name = request.getParameter("name");
            String phoneNumber = request.getParameter("phoneNumber");
            String deliveryAddress = request.getParameter("deliveryAddress");
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("acc");
            if (a == null) {
                response.sendRedirect("login");
                return;
            }
            String txt = "";
            Cookie[] cookies = request.getCookies();
            for (Cookie i : cookies) {
                if (i.getName().equals("Cart" + a.getUsername())) {
                    txt = i.getValue();
                }
            }
            List<product> listP = new ArrayList<>();
            DaoProduct dpro = new DaoProduct();
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
            double totalMoney = 0;
            for (product i : listP) {
                totalMoney += i.getPrice() * i.getQuantity();
            }
            double totalMoneyVAT = totalMoney + totalMoney * 0.1;
            //old code
            Email email = new Email();
            email.setFrom("truongphhe163246@fpt.edu.vn");
            email.setFromPassword("truongtruong123123");
            email.setTo(emailAddress);
            email.setSubject("Dat hang thanh cong");
            StringBuilder sb = new StringBuilder();
            sb.append("Dear ").append(name).append("<br>");
            sb.append("Ban vua dat dang tu website cua chung toi. <br> ");
            sb.append("Dia chi nhan hang cua ban la: <b>").append(deliveryAddress).append(" </b> <br>");
            sb.append("So dien thoai khi nhan hang cua ban la: <b>").append(phoneNumber).append(" </b> <br>");
            sb.append("Cac san pham ban dat la: <br>");
            for (product p : listP) {
                sb.append(p.getProduct_name()).append(" | ").append("Price:").append(p.getPrice()).append("$").append(" | ").append("Amount:").append(p.getQuantity()).append("<br>");
            }
            sb.append("Tong Tien: ").append(StringHelper.printPrice(totalMoneyVAT)).append("$").append("<br>");
            sb.append("Cam on ban da dat hang<br>");
            sb.append("NGUYEN HOANG KIEN");
            email.setContent(sb.toString());
            EmailUtils.send(email);
            request.setAttribute("mess", "Dat hang thanh cong!");
            for (Cookie i : cookies) {
                if (i.getName().equals("Cart" + a.getUsername())) {
                    i.setMaxAge(0);
                    response.addCookie(i);
                }
            }
        } catch (Exception e) {
            request.setAttribute("error", "Dat hang that bai!");
            e.printStackTrace();
        }
        request.getRequestDispatcher("DatHang.jsp").forward(request, response);
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
