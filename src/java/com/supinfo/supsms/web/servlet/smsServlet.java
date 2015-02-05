/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SMSDao;
import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SMS;
import com.supinfo.supsms.entity.SupUser;
import com.supinfo.supsms.utils.Common;
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
@WebServlet(name = "smsServlet", urlPatterns = {"/smsManager"})
public class smsServlet extends HttpServlet {

    @EJB
    private SupUserDao supUserDao;

    @EJB
    private SMSDao smsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SupUser me = new Common().getUserFromSession(req, supUserDao);

        String method = req.getParameter("_method");
        if (method != null) {
            switch (method) {
                case "PUT":
                    doPut(req, resp);
                    break;
                case "DELETE":
                    doDelete(req, resp);
                    break;
            }
        }

        goToSmsPage(me, req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SMS sms = new SMS();
        SupUser me = new Common().getUserFromSession(req, supUserDao);
        sms.setSender(me);

        String phoneArg = req.getParameter("phoneNumber");
        if (phoneArg != null) {
            Long phoneNumberReceiver = Long.parseLong(phoneArg);
            sms.setReceiver(supUserDao.getSupUser(phoneNumberReceiver));

            String message = req.getParameter("message");
            sms.setMessage(message);

            smsDao.addSMS(sms);

        }

        goToSmsPage(me, req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        SupUser me = new Common().getUserFromSession(req, supUserDao);
        
        String phoneNumber = req.getParameter("phoneNumber");
        if(phoneNumber != null) {
            SupUser him = supUserDao.getSupUser(Long.parseLong(phoneNumber));
            
            smsDao.delUserSMS(me, him);
        }
        
    }

    private void goToSmsPage(SupUser me, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("senders", smsDao.getConversations(me));
        req.getRequestDispatcher("/jsp/sms.jsp").forward(req, resp);
    }
}
