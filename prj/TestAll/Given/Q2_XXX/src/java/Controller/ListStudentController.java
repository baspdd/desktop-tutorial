/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Student;
import dal.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author duypham0705
 */
public class ListStudentController extends HttpServlet {

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
        StudentDao set = new StudentDao();
        ArrayList<Student> listAll = set.getAll();
        request.setAttribute("listAll", listAll);

        if (!checkInt(request.getParameter("id"), 0, Integer.MAX_VALUE)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if (set.checkID(request.getParameter("id"))) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if (request.getParameter("name") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if (request.getParameter("sex") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if (!checkInt(request.getParameter("type"), 0, Integer.MAX_VALUE)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("sex");
        boolean sex = true;
        if (gender.equalsIgnoreCase("female")) {
            sex = false;
        }
        int type = Integer.parseInt(request.getParameter("type"));

        if (request.getParameter("submit") != null) {
            Student stu = new Student(id, name, sex, type);
            set.Insert(stu);
            listAll.add(new Student(id, name, sex, type));
        }
        request.setAttribute("listAll", listAll);

        request.getRequestDispatcher("index.jsp").forward(request, response);
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

    public boolean checkInt(String mess, int min, int max) {
        if (mess.matches("[0-9]+")) {
            int ret = Integer.parseInt(mess);
            if (min <= ret && ret <= max) {
                return true;
            }
        }
        return false;
    }
}
