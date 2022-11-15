/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-13    1.0        NangNN           First Version<br>
 */
package entity;

/**
 *
 * This class represents the ImageGallery table in database
 *
 * @author nangnnhe130538
 */
public class ImageGallery {

    /**
     * ImageGallery image
     */
    private String image;
    /**
     * ImageGallery galleryId
     */
    private int galleryId;

    /**
     * Constructor
     */
    public ImageGallery() {
    }

    /**
     * Constructor
     *
     * @param image it is a <code>java.lang.String</code>
     * @param galleryId it is an int
     */
    public ImageGallery(String image, int galleryId) {
        this.image = image;
        this.galleryId = galleryId;
    }

    /**
     * Get value from image attribute of ImageGallery class. <br>
     *
     * @return image it is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of ImageGallery class
     *
     * @param image it is a <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value from getGalleryId attribute of ImageGallery class. <br>
     *
     * @return getGalleryId. It is an int
     */
    public int getGalleryId() {
        return galleryId;
    }

    /**
     * Set value to galleryId attribute of ImageGallery class
     *
     * @param galleryId it is an int
     */
    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }
}
