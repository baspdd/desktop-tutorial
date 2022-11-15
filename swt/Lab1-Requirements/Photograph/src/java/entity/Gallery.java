/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE  Version ----------- Author -------- DESCRIPTION<br>
 * 2021-05-13 - 1.0 --------------- NangNN -------- First Version<br>
 */
package entity;

/**
 *
 * This class represents the Gallery table in database
 *
 * @author nangnnhe130538
 */
public class Gallery {

    /**
     * Gallery id
     */
    private int id;
    /**
     * Gallery name
     */
    private String name;
    /**
     * Gallery description
     */
    private String description;
    /**
     * Gallery image
     */
    private String image;

    /**
     * Constructor
     */
    public Gallery() {
    }

    /**
     * Constructor
     *
     * @param id it is an int
     * @param name it is a <code>java.lang.String</code>
     * @param description it is a <code>java.lang.String</code>
     * @param image it is a <code>java.lang.String</code>
     */
    public Gallery(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    /**
     * Get value form id attribute of Gallery class. <br>
     *
     * @return id it is an int
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of Gallery class
     *
     * @param id it is an int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from name attribute of Gallery class. <br>
     *
     * @return name it is a <code>java.lang.String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Set value to name attribute of Gallery class
     *
     * @param name it is a <code>java.lang.String</code>
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value from description attribute of Gallery class. <br>
     *
     * @return description it is a <code>java.lang.String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value to description attribute of Gallery class
     *
     * @param description it is a <code>java.lang.String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value from image attribute of Gallery class. <br>
     *
     * @return image it is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of Gallery class
     *
     * @param image it is a <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }
}
