package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.utils.ServerCommonVar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ___Cid___
 */
@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServerCommonVar.nbUserLogged--;
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath());
    }
    
}
