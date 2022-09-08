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
public class DemoSeverlet extends HttpServlet {

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
            out.println("<title>Servlet DemoSeverlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemoSeverlet at " + request.getContextPath() + "</h1>");
            out.println("<form method='get'>");
            out.println("Enter a : <input type=\"text\" name='a'> ");
            out.println("<br> Enter b :<input type=\"text\" name='b'> ");
            out.println("<br> <button>ok</button>");
            out.println("</form>");

            // nhân thông tin từ cilent gửi lên cho sever
            String valueA = request.getParameter("a");
            int a = Integer.parseInt(valueA);
            int b = Integer.parseInt(request.getParameter("b"));

// C1 : truền tham số trên addresser
            if (request.getParameter("o") == null) {
                out.println("no hope");
                return;
            }
            int o = Integer.parseInt(request.getParameter("o"));
// C2 : tạo giá trị lưu trong web.xml 
//            int o = Integer.parseInt(getServletContext().getInitParameter("o"));

// C3 : tạo giá trị lưu trong init-param trong web.xml ( chỉ trong demoseverlet)
//            int o = Integer.parseInt(getInitParameter("o"));
            // xử lý thông tin
            int c = 0;
            if (o == 1) {
                c = a + b;
            }
            // response lại kết quả cho cilent
            out.println("<br> Result :" + c);
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
