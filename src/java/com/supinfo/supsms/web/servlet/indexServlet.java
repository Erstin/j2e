/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SMSDao;
import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SupUser;
import com.supinfo.supsms.utils.Constantes;
import com.supinfo.supsms.utils.ServerCommonVar;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ___Cid___
 */
@WebServlet(name = "indexServlet", urlPatterns = {"/home"})
public class indexServlet extends HttpServlet {
    
    @EJB
    SupUserDao supUserDao;
    
    @EJB
    SMSDao smsDao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        Object userPhoneNumber = req.getSession().getAttribute(Constantes.SESSION_USER_ATTRIBUTE_NAME);
        if( userPhoneNumber != null) {
            SupUser supUser = supUserDao.getSupUser((Long)userPhoneNumber);
            req.setAttribute("nbContact", supUser.getContacts().size());
            req.setAttribute("nbSMS", smsDao.getUserSMS(supUser).size());
        }
        req.setAttribute("nbUser", ServerCommonVar.nbUserLogged);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
