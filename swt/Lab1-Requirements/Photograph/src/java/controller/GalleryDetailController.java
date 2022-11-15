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
import dao.IImageGalleryDAO;
import dao.IShareDAO;
import entity.Gallery;
import entity.ImageGallery;
import entity.Share;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.GalleryDAOImpl;
import dao.impl.ImageGalleryDAOImpl;
import dao.impl.ShareDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Process:<br>
 * - Get Top 3 galleries for header<br>
 * - Get image gallery to paging<br>
 * - Get big image<br>
 * - Get link share
 *
 * Exception:<br>
 * - If output failed, it will return to error page.
 *
 * @author nangnnhe130538
 */
public class GalleryDetailController extends HttpServlet {

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
        try {
            int pageSize = 8;
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
            // Get the ID of the gallery  wants to see in detail
            int id = 0;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                id = -1;
                request.setAttribute("errorMessage", e.toString());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            IGalleryDAO galleryDAO = new GalleryDAOImpl();

            // get Top 3 gallery for header
            ArrayList<Gallery> top3Galleries = galleryDAO.getTopGalleries(3);
            request.setAttribute("Top3Gallery", top3Galleries);

            // big image
            request.setAttribute("galleryCurrent", galleryDAO.getGalleryByID(id));
            request.setAttribute("id", id);

            // get image gallery to paging
            IImageGalleryDAO imageGalleryDAO = new ImageGalleryDAOImpl();
            ArrayList<ImageGallery> imageGalleries = imageGalleryDAO.getImageGalleryPaging(id, pageSize, page);
            request.setAttribute("imgGalleryList", imageGalleries);
            if (!imageGalleries.isEmpty()) {
                // get number page
                int numberPage = imageGalleryDAO.getNumberPages(id, pageSize);
                request.setAttribute("numberPage", numberPage);
                request.setAttribute("page", page);
            }

            // get link share
            IShareDAO shareDAO = new ShareDAOImpl();
            ArrayList<Share> shareList = shareDAO.getShare();
            request.setAttribute("ShareList", shareList);

            request.getRequestDispatcher("galleryDetail.jsp").forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(GalleryDetailController.class.getName()).log(Level.SEVERE, null, e);
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
