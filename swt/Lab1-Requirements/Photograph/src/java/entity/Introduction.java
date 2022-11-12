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
 * This class represents the Introduction table in database
 *
 * @author nangnnhe130538
 */
public class Introduction {

    /**
     * Introduction address
     */
    private String image;
    /**
     * Introduction description
     */
    private String description;
    /**
     * Introduction aboutMe
     */
    private String aboutMe;

    /**
     * Constructor.<br>
     */
    public Introduction() {
    }

    /**
     * Constructor.<br>
     *
     * @param image it is a <code>java.lang.String</code>
     * @param descript it is a <code>java.lang.String</code>
     * @param aboutme it is a <code>java.lang.String</code>
     */
    public Introduction(String image, String descript, String aboutme) {
        this.image = image;
        this.description = descript;
        this.aboutMe = aboutme;
    }

    /**
     * Get value from image attribute of Introduction class. <br>
     *
     * @return image it is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of Introduction class
     *
     * @param image it is a <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value from description attribute of Introduction class. <br>
     *
     * @return description it is a <code>java.lang.String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value to description attribute of Introduction class
     *
     * @param description it is a <code>java.lang.String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value from aboutMe attribute of Introduction class. <br>
     *
     * @return aboutMe it is a <code>java.lang.String</code>
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * Set value to aboutMe attribute of Introduction class
     *
     * @param aboutMe it is a <code>java.lang.String</code>
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

}
