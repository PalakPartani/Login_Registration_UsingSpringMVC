package com.demo.registration.controller;

import com.demo.registration.model.Customer;
//import com.demo.registration.service.LoginService;
import com.demo.registration.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * purpose:login user with valid details
 */
@SessionAttributes("name")
@Controller
//@SessionAttributes("userObject")
public class LoginController {

    @Autowired
    UserServiceImpl service;
    //  LoginService service;

    /**
     * @param req get input details
     * @param res gives response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(path = "/loginProcess", method = RequestMethod.GET)
    public void showLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String password = req.getParameter("password");
        Customer customer = service.setSession(userName, password);

        if (req.getParameter("submit").equals("Login")) {

            if (customer != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("name",customer);
                // session.setAttribute("name",customer.getUserName()+customer.getEmailId());
                /*session.setAttribute("name", customer.getUserName());
                session.setAttribute("address", customer.getAddress());
                session.setAttribute("email", customer.getEmailId());*/
                req.getRequestDispatcher("/index").forward(req, res);
            }
            //  req.getRequestDispatcher("/index").forward(req, res);
        } else {
            req.getRequestDispatcher("/login").include(req, res);
            System.out.println("dispatch");
        }
    }

    //registration controller
    @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
    public void showRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String userName = req.getParameter("name");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String emailId = req.getParameter("email");
        String submit = req.getParameter("submit");

        int result = service.setData(userName, address, password, emailId);
        if (submit.equals("Register")) {

            System.out.println("req " + req);
            System.out.println("res " + res);

            if (result != 0) {
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Registration successfull...!!!! ');");
                out.println("</script>");
                req.getRequestDispatcher("/login").include(req, res);
            } else {
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Invalid details!!! ');");
                out.println("</script>");
                req.getRequestDispatcher("/register").include(req, res);
            }
            System.out.println("terminate");
        }
    }

    @RequestMapping(path = "/logoutProcess", method = RequestMethod.GET)
    public String showLogout(HttpServletRequest req){
        HttpSession session= req.getSession(true);
        session.setAttribute("customer",null);
        session.invalidate();
        return "login";
    }

}

//req param send
//extra var submit
//session in service
//else in reg