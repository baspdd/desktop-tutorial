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

import entity.Introduction;

/**
 * This class contains methods to help us manipulate Introduction objects in the
 * database.
 *
 * @author nangnnhe130538
 */
public interface IIntroductionDAO {

    /**
     * Get all Introduction options according in the database.
     *
     * @return a list <code>Introduction</code> object
     * @throws Exception
     */
    public Introduction getIntroduction() throws Exception;
}
