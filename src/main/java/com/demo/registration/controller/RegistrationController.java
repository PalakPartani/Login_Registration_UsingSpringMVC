package com.demo.registration.controller;
/**
 * purpose:register user with valid details
 */

import com.demo.registration.repository.CustomerOperationImplementation;
import com.demo.registration.interfaces.ICustomerOperation;
import com.demo.registration.model.Customer;
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
    static String NAME_PATTERN = "^[A-Z][a-z]{2,}$";
    static String ADDRESS_PATTERN = "^[A-Z][a-z]{1,}$";
    static String REGEX_PASSWORD = "^((?=[^\\W\\_]*[\\W\\_][^\\W\\_]*$)(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9\\W\\_]{8,})$";
    static String EMAIL_ID = "^\\w{3,}([-._+]\\w+)?@\\w+.[a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$";

    @RequestMapping(value = "/registerProcess", method = RequestMethod.GET)
    public void showRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ICustomerOperation cd = new CustomerOperationImplementation();

        String userName = req.getParameter("name");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String emailId = req.getParameter("email");
        String submit=req.getParameter("submit");
        Customer customer = new Customer();
        customer.setUserName(userName);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setEmailId(emailId);

        System.out.println("values retrieved");
        if (submit.equals("Register")) {

            System.out.println("hi reg");
            boolean nameMatch = userName.matches(NAME_PATTERN);
            boolean passwordMatch = password.matches(REGEX_PASSWORD);
            boolean addressMatch = address.matches(ADDRESS_PATTERN);
            boolean emailMatch = emailId.matches(EMAIL_ID);

            if (nameMatch && passwordMatch && addressMatch && emailMatch) {
                System.out.println("req " + req);
                System.out.println("res " + res);

                int result = cd.insertCustomer(customer);
                if (result != 0) {
                    PrintWriter out = res.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.alert('Registration successfull...!!!! ');");
                    out.println("</script>");
                    req.getRequestDispatcher("/login").include(req,res);
                }

            } else {
                PrintWriter out = res.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Invalid details!!! ');");
                out.println("</script>");
                req.getRequestDispatcher("/register").include(req,res);
            }
            System.out.println("terminate");
        }

    }
}