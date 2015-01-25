package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.dao.jpa.JpaSupUserDao;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private SupUserDao supUserDao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long phoneNumber = null;
        try {
            phoneNumber = Long.parseLong(req.getParameter("username"));
        } catch (NumberFormatException ex) {
            doGet(req, resp);
        }
        String password = req.getParameter("password");
        
        if(supUserDao.getSupUser(phoneNumber).getPassword().equals(password)) {
            req.getSession().setAttribute("user", phoneNumber);
            resp.sendRedirect(getServletContext().getContextPath());
        } else {
            doGet(req, resp);
        }
    }

}
