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

import entity.ImageGallery;
import java.util.ArrayList;

/**
 * This class contains methods to help us manipulate ImageGallery objects in the
 * database.
 *
 * @author nangnnhe130538
 */
public interface IImageGalleryDAO {

    /**
     * Get all ImageGallery options according in the database and paging
     *
     * @param id it is an int number.
     * @param pageSize it is an int number.
     * @param pageIndex it is an int number.
     * @return a list <code>ImageGallery</code> object
     * @throws Exception
     */
    public ArrayList<ImageGallery> getImageGalleryPaging(int id, int pageSize, int pageIndex) throws Exception;

    /**
     * Get number of ImageGallery options according in the database
     *
     * @param id it is an int number.
     * @param pageSize it is an int number.
     * @return an int number.
     * @throws Exception
     */
    public int getNumberPages(int id, int pageSize) throws Exception;

}
