/**
 * Copyright (C) 2021, FPT University
 * J3.L.P0014
 * Maria Bagnarelli's Cafe.
 *
 * Record of change:
 * DATE         VERSION         Author
 * 2021-02-23   1.0             DungHT
 *
 */
package entity;

/**
 *
 * This class represents the NumberOfViews table in Database
 *
 * @author nangnnhe130538
 */
public class NumOfViews {

    /**
     * NumOfViews numberOfviews
     */
    private int numberOfviews;

    /**
     * Constructor
     */
    public NumOfViews() {
    }

    /**
     * Constructor
     *
     * @param numberOfviews
     */
    public NumOfViews(int numberOfviews) {
        this.numberOfviews = numberOfviews;
    }

    /**
     * Get value from numberOfviews attribute of Share class. <br>
     *
     * @return numberOfviews it is a <code>java.lang.String</code>
     */
    public int getNumberOfviews() {
        return numberOfviews;
    }

    /**
     * Set value to numberOfviews attribute of Share class
     *
     * @param numberOfviews it is a <code>java.lang.String</code>
     */
    public void setNumberOfviews(int numberOfviews) {
        this.numberOfviews = numberOfviews;
    }

}
