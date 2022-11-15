/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-13    1.0        NangNN           First Version<br>
 */
package sessionListenner;

import dao.INumberOfViewsDao;
import dao.impl.NumberOfViewsDaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application life cycle session listener.
 *
 * @author Nangnnhe130538
 */
public class ViewCountListener implements HttpSessionListener {

    /**
     *Update and Get count number of view page from table NumberOfViews in database when begin access to web site
     *
     * @param se it is a <code>javax.servlet.http.HttpSessionEvent</code>
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        INumberOfViewsDao numberOfViewsDao = new NumberOfViewsDaoImpl();
        try {
            numberOfViewsDao.updateNumber();
            String s = String.format("%06d", numberOfViewsDao.getNumber());
            se.getSession().setAttribute("s", s);
        } catch (Exception e) {
            Logger.getLogger(ViewCountListener.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
