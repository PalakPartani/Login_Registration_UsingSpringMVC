package com.demo.registration.controller;
/**
 * purpose:register user with valid details
 */

import com.demo.registration.repository.CustomerOperationImplementation;
import com.demo.registration.interfaces.ICustomerOperation;
import com.demo.registration.model.Customer;
import com.demo.registration.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class RegistrationController {
    @Autowired
    RegisterService service;

    @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
    public void showRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String userName = req.getParameter("name");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String emailId = req.getParameter("email");
        String submit = req.getParameter("submit");

        int result = service.setData(userName, address, password, emailId);

        System.out.println("values retrieved");
        if (submit.equals("Register")) {

            System.out.println("hi reg");

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
}