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
import com.supinfo.supsms.service.SMSService;
import com.supinfo.supsms.utils.Common;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jms.JMSException;
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

    @EJB
    private SMSService sendSMSService;

    private Map<SupUser, SMS> buildSMS(List<String> messages) {
        Map<SupUser, SMS> ret = new LinkedHashMap<>();

        for (String str : messages) {
            String[] messagePart = str.split(sendSMSService.separatorMessage);
            if (messagePart.length > 2) {
                SMS sms = new SMS();
                sms.setSender(supUserDao.getSupUser(Long.parseLong(messagePart[0])));
                sms.setReceiver(supUserDao.getSupUser(
                        Long.parseLong(messagePart[messagePart.length - 1])
                ));

                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < messagePart.length - 1; ++i) {
                    builder.append(messagePart[i])
                            .append("<br />");
                }
                sms.setMessage(builder.toString());
                
                ret.put(sms.getSender(), sms);
            }
        }

        return ret;
    }

    private Map<SupUser, SMS> getMessages() throws JMSException {
        String message;
        List<String> messages = new LinkedList<>();
        while ((message = sendSMSService.receive()) != "") {
            messages.add(message);
        }

        return buildSMS(messages);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SupUser me = new Common().getUserFromSession(req, supUserDao);

        String method = req.getParameter("_method");
        if (method != null) {
            switch (method) {
                case "PUT":
                    doPut(req, resp);
                    break;
                case "DELETE":
                    // doDelete(req, resp);
                    break;
            }
        }

        try {
            req.setAttribute("senders", getMessages());
        } catch (JMSException ex) {
            Logger.getLogger(smsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        goToSmsPage(me, req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SMS sms = new SMS();
        SupUser me = new Common().getUserFromSession(req, supUserDao);
        sms.setSender(me);

        String phoneArg = req.getParameter("phoneNumber");
        if (phoneArg != null) {
            Long phoneNumberReceiver = Long.parseLong(phoneArg);
            sms.setReceiver(supUserDao.getSupUser(phoneNumberReceiver));

            String message = req.getParameter("message");
            sms.setMessage(message);

            try {
                sendSMSService.send(sms);
                // smsDao.addSMS(sms);
            } catch (JMSException ex) {
                Logger.getLogger(smsServlet.class.getName()).log(Level.SEVERE, null, ex);
                goToSmsPage(me, req, resp);
            }

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SupUser me = new Common().getUserFromSession(req, supUserDao);

        String phoneNumber = req.getParameter("phoneNumber");
        if (phoneNumber != null) {
            SupUser him = supUserDao.getSupUser(Long.parseLong(phoneNumber));

            smsDao.delUserSMS(me, him);
        }

    }

    private void goToSmsPage(SupUser me, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // req.setAttribute("senders", smsDao.getConversations(me));
        req.getRequestDispatcher("/jsp/sms.jsp").forward(req, resp);
    }
}
