/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-13    1.0        NangNN           First Version<br>
 */
package dao;

import entity.Gallery;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate Gallery objects in the
 * database.
 *
 * @author nangnnhe130538
 */
public interface IGalleryDAO {

    /**
     * Get top 3 Galleries options according in the database
     *
     * @param top it is an int
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    public ArrayList<Gallery> getTopGalleries(int top) throws Exception;

    /**
     * Get all Galleries options according in the database and paging
     *
     * @param pageSize. It is an int number.
     * @param pageIndex. It is an int number.
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    public ArrayList<Gallery> getGalleries(int pageSize, int pageIndex) throws Exception;

    /**
     * Get number of Galleries options according in the database
     *
     * @param pageSize. It is an int number.
     * @return an int number.
     * @throws Exception
     */
    public int getNumberPages(int pageSize) throws Exception;

    /**
     * Get a Gallery option according in the database by Gallery id
     *
     * @param id. It is an int number.
     * @return a <code>Gallery</code> object
     * @throws Exception
     */
    public Gallery getGalleryByID(int id) throws Exception;

}
