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
public class ex3 extends HttpServlet {

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

            if (!Input.checkInt(request.getParameter("n"), 1, 100)) {
                out.println("re-input n");
                return;
            }
            int n = Integer.parseInt(request.getParameter("n"));
            String type = request.getParameter("type");
            if (type.isEmpty()) {
                out.println("Selection a function");
                return;
            }
            switch (type) {
                case "1":
                    int sum = 0;
                    for (int i = 1; i <= n; i++) {
                        sum += i;
                    }
                    out.println("Sum Result :" + sum);
                    break;
                case "2":
                    out.println("Result :" + factorial(n));
                    break;
                case "3":
                    out.println("Odd Result :");
                    for (int i = 1; i <= n; i += 2) {
                        out.println(" " + i);
                    }
                    break;
                case "4":
                    out.println("Even Result :");
                    for (int i = 0; i <= n; i += 2) {
                        out.println(" " + i);
                    }
                    break;
                case "5":
                    if (isPrime(n)) {
                        out.println(n + " is a prime number");
                    } else {
                        out.println(n + " is not a prime number");
                    }
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

    private int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return (n * factorial(n - 1));
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
