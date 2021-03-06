package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.SupUser;
import com.supinfo.supsms.utils.Constantes;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private SupUserDao supUserDao;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ongletTitle", "Login");
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
        
        SupUser supUser = supUserDao.getSupUser(phoneNumber);
        if(supUser != null && supUser.getPassword().equals(password)) {
            Common.nbUserLogged++;
            req.getSession().setAttribute(Constantes.SESSION_USER_ATTRIBUTE_NAME, phoneNumber);
            resp.sendRedirect(getServletContext().getContextPath() + Constantes.HOME_PATH);
        } else {
            doGet(req, resp);
        }
    }

}
