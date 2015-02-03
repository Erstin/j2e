package com.supinfo.supsms.utils;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SupUser;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ___Cid___
 */
public class Common {
    
    public static Integer nbUserLogged = 0;
    
    public SupUser getUserFromSession(HttpServletRequest req, SupUserDao supUserDao) {
        Object userPhoneNumber = req.getSession().getAttribute(Constantes.SESSION_USER_ATTRIBUTE_NAME);
        
        if( userPhoneNumber == null) {
            return null;
        }
        
        return  supUserDao.getSupUser((Long)userPhoneNumber);
    }
            
}
