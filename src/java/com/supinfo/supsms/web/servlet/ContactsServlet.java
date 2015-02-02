package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SupUserDao;
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
@WebServlet(name = "ContactsServlet", urlPatterns = {"/contacts"})
public class ContactsServlet extends HttpServlet {
    
    @EJB
    SupUserDao supUserDao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("contacts",
                new Common().getUserFromSession(req, supUserDao).getContacts());
        req.setAttribute("ongletTitle", "Vos contacts");
        req.getRequestDispatcher("/jsp/contacts.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
