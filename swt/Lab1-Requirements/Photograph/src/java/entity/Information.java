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
 * This class represents the Information table in database
 *
 * @author nangnnhe130538
 */
public class Information {

    /**
     * Information address
     */
    private String address;
    /**
     * Information city
     */
    private String city;
    /**
     * Information country
     */
    private String country;
    /**
     * Information tel
     */
    private String tel;
    /**
     * Information email
     */
    private String email;
    /**
     * Information image
     */
    private String image;

    /**
     * Constructor.<br>
     */
    public Information() {
    }

    /**
     * Constructor.<br>
     *
     * @param address it is a <code>java.lang.String</code>
     * @param city it is a <code>java.lang.String</code>
     * @param country it is a <code>java.lang.String</code>
     * @param tel it is a <code>java.lang.String</code>
     * @param email it is a <code>java.lang.String</code>
     * @param image it is a <code>java.lang.String</code>
     */
    public Information(String address, String city, String country, String tel, String email, String image) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.tel = tel;
        this.email = email;
        this.image = image;
    }

    /**
     * Get value from address attribute of Information class. <br>
     *
     * @return address it is a <code>java.lang.String</code>
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set value to address attribute of Information class
     *
     * @param address it is a <code>java.lang.String</code>
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get value from city attribute of Information class. <br>
     *
     * @return city it is a <code>java.lang.String</code>
     */
    public String getCity() {
        return city;
    }

    /**
     * Set value to city attribute of Information class
     *
     * @param city it is a <code>java.lang.String</code>
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get value from country attribute of Information class. <br>
     *
     * @return country it is a <code>java.lang.String</code>
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set value to country attribute of Information class
     *
     * @param country it is a <code>java.lang.String</code>
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Get value from tel attribute of Information class. <br>
     *
     * @return tel it is a <code>java.lang.String</code>
     */
    public String getTel() {
        return tel;
    }

    /**
     * Set value to tel attribute of Information class
     *
     * @param tel it is a <code>java.lang.String</code>
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Get value from email attribute of Information class. <br>
     *
     * @return email it is a <code>java.lang.String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set value to email attribute of Information class
     *
     * @param email it is a <code>java.lang.String</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value from image attribute of Information class. <br>
     *
     * @return image it is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of Information class
     *
     * @param image it is a <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }
}
