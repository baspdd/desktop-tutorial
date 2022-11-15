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
 * This class represents the Share table in database
 *
 * @author nangnnhe130538
 */
public class Share {

    /**
     * Share icon
     */
    private String icon;
    /**
     * Share socialNetwork
     */
    private String socialNetwork;
    /**
     * Share url
     */
    private String url;

    /**
     * Constructor.<br>
     */
    public Share() {
    }

    /**
     * Constructor.<br>
     *
     * @param icon it is a <code>java.lang.String</code>
     * @param socialNetwork it is a <code>java.lang.String</code>
     * @param url it is a <code>java.lang.String</code>
     */
    public Share(String icon, String socialNetwork, String url) {
        this.icon = icon;
        this.socialNetwork = socialNetwork;
        this.url = url;
    }

    /**
     * Get value from icon attribute of Share class. <br>
     *
     * @return icon it is a <code>java.lang.String</code>
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Set value to icon attribute of Share class
     *
     * @param icon it is a <code>java.lang.String</code>
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Get value from socialNetwork attribute of Share class. <br>
     *
     * @return socialNetwork it is a <code>java.lang.String</code>
     */
    public String getSocialNetwork() {
        return socialNetwork;
    }

    /**
     * Set value to socialNetwork attribute of Share class
     *
     * @param socialNetwork it is a <code>java.lang.String</code>
     */
    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    /**
     * Get value from url attribute of Share class. <br>
     *
     * @return url it is a <code>java.lang.String</code>
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set value to url attribute of Share class
     *
     * @param url it is a <code>java.lang.String</code>
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
