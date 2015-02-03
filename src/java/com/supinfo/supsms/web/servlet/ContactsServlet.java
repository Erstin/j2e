package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SupUser;
import com.supinfo.supsms.utils.Common;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ContactsServlet", urlPatterns = {"/contacts"})
public class ContactsServlet extends HttpServlet {

    @EJB
    SupUserDao supUserDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

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

        goToContactPage(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        SupUser me = new Common().getUserFromSession(req, supUserDao);

        String phoneStr = req.getParameter("phoneNumber");

        if (phoneStr != null) {
            Long phoneNumber = Long.parseLong(phoneStr);

            SupUser friend = supUserDao.getSupUser(phoneNumber);
            if (friend != null) {
                me.getContacts().add(friend);
                supUserDao.mergeSupUser(me);
                goToContactPage(req, resp);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SupUser me = new Common().getUserFromSession(req, supUserDao);

        String phoneStr = req.getParameter("phoneNumber");

        if (phoneStr != null) {
            Long phoneNumber = Long.parseLong(phoneStr);

            SupUser friend = supUserDao.getSupUser(phoneNumber);
            if (friend != null) {
                me.getContacts().remove(friend);
                supUserDao.mergeSupUser(me);
                goToContactPage(req, resp);
            }
        }
    }

    private void goToContactPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("contacts",
                new Common().getUserFromSession(req, supUserDao).getContacts());
        req.setAttribute("ongletTitle", "Vos contacts");
        req.getRequestDispatcher("/jsp/contacts.jsp").forward(req, resp);
    }
}
