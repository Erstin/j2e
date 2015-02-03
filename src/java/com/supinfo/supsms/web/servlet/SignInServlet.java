package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.dao.SupUserDao;
import com.supinfo.supsms.entity.Addr;
import com.supinfo.supsms.entity.Street;
import com.supinfo.supsms.entity.SupUser;
import com.supinfo.supsms.utils.Constantes;
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
@WebServlet(name = "SignInServlet", urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {

    @EJB
    private SupUserDao supUserDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("ongletTitle", "Sign In");
        req.getRequestDispatcher("/jsp/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SupUser supUser = new SupUser();
        if (req.getParameter("username") != null) {
            supUser.setUsername(req.getParameter("username"));
        }

        if (req.getParameter("password") != null) {
            supUser.setPassword(req.getParameter("password"));
        }

        if (req.getParameter("phonenumber") != null) {
            supUser.setPhoneNumber(Long.parseLong(req.getParameter("phonenumber")));
        }

        if (req.getParameter("lastname") != null) {
            supUser.setLastName(req.getParameter("lastname"));
        }

        if (req.getParameter("firstname") != null) {
            supUser.setFirstName(req.getParameter("firstname"));
        }

        if (req.getParameter("email") != null) {
            supUser.setEmail(req.getParameter("email"));
        }

        Addr address = new Addr();
        if (req.getParameter("streetnumber") != null) {
            address.setStreetNumber(Short.parseShort(req.getParameter("streetnumber")));
        }

        Street street = new Street();
        if (req.getParameter("streetname") != null) {
            street.setStreetName(req.getParameter("streetname"));
        }

        if (req.getParameter("cityname") != null) {
            street.setCityName(req.getParameter("cityname"));
        }

        if (req.getParameter("zipcode") != null) {
            street.setZipCode(req.getParameter("zipcode"));
        }

        address.setStreet(street);
        supUser.setAddress(address);

        try {
            supUserDao.addUser(supUser);
        } catch (Exception ex) {
            doGet(req, resp);
        }

        req.getSession().setAttribute("user", supUser.getPhoneNumber());
        resp.sendRedirect(getServletContext().getContextPath()+ Constantes.HOME_PATH);
    }

}
