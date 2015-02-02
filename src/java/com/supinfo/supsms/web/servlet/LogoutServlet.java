package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.utils.Constantes;
import com.supinfo.supsms.utils.Common;
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
        Common.nbUserLogged--;
        req.getSession().invalidate();
        resp.sendRedirect(getServletContext().getContextPath() + Constantes.HOME_PATH);
    }
    
}
