package com.demo.registration.controller;

import com.demo.registration.repository.CustomerOperationImplementation;
import com.demo.registration.interfaces.ICustomerOperation;
import com.demo.registration.model.Customer;
import com.demo.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * purpose:login user with valid details
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    LoginService service;

    /**
     * @param req get input details
     * @param res gives response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(path = "/loginProcess", method = RequestMethod.GET)
    public void showLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        if (req.getParameter("submit").equals("Login")) {
            Customer customer = service.setSession(req);
            req.getRequestDispatcher("/index").forward(req, res);
        } else {
            req.getRequestDispatcher("/login").include(req, res);
            System.out.println("dispatch");
        }
    }
}
