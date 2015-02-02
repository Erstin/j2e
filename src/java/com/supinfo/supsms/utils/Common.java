package com.supinfo.supsms.utils;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SupUser;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ___Cid___
 */
public class Common {
    
    public static Integer nbUserLogged = 0;
    
    public SupUser getUserFromSession(HttpServletRequest req, SupUserDao supUserDao) {
        Object userPhoneNumber = req.getSession().getAttribute(Constantes.SESSION_USER_ATTRIBUTE_NAME);
        return  supUserDao.getSupUser((Long)userPhoneNumber);
    }
            
}
