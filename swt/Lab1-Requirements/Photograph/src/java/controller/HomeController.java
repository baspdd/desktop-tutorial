/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-13    1.0        NangNN           First Version<br>
 */
package controller;

import dao.IGalleryDAO;
import dao.IIntroductionDAO;
import dao.IShareDAO;
import entity.Gallery;
import entity.Introduction;
import entity.Share;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.GalleryDAOImpl;
import dao.impl.IntroductionDAOImpl;
import dao.impl.ShareDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Process:<br>
 * - Get Top 3 galleries for header<br>
 * - GEt introduction in home page<br>
 * - Get paging gallery in page with 3 galleries<br>
 * - Get link share<br>
 *
 * Exception:<br>
 * - If output failed, it will return to error page.
 *
 * @author nangnnhe130538
 */
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request it is a object of
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response it is a object of
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(10 * 60);
        
        try {
            int pageSize = 3;
            // get page current
            int page = 0;
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException ex) {
                page = 1;
            }
            if (page <= 0) {
                page = 1;
            }

            IGalleryDAO galleryDAO = new GalleryDAOImpl();

            // get Top 3 gallery for header
            ArrayList<Gallery> top3Gallery = galleryDAO.getTopGalleries(3);
            request.setAttribute("Top3Gallery", top3Gallery);

            // get introduction in home page
            IIntroductionDAO introductionDAO = new IntroductionDAOImpl();
            Introduction intro = introductionDAO.getIntroduction();
            request.setAttribute("Introduction", intro);

            // paging get gallery in page with 3 galleries
            ArrayList<Gallery> galleries = galleryDAO.getGalleries(pageSize, page);
            request.setAttribute("PagingGallery", galleries);
            if (!galleries.isEmpty()) {
                // get number page
                int numberPage = galleryDAO.getNumberPages(pageSize);
                request.setAttribute("numberPage", numberPage);
                request.setAttribute("page", page);
            }

            // get link share
            IShareDAO shareDAO = new ShareDAOImpl();
            ArrayList<Share> shareList = shareDAO.getShare();

            request.setAttribute("ShareList", shareList);
            request.setAttribute("boldHome", "font-bold");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
