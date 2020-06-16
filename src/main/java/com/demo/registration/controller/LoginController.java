package com.demo.registration.controller;

import com.demo.registration.repository.CustomerOperationImplementation;
import com.demo.registration.interfaces.ICustomerOperation;
import com.demo.registration.model.Customer;
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

    /**
     *
     * @param req get input details
     * @param res gives response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(path = "/loginProcess", method = RequestMethod.GET)
    public void showLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("hi");
    /*    Customer custSession=req.getSession().setAttribute("custSession",customer);*/

        ICustomerOperation cd = new CustomerOperationImplementation();

        String userName = req.getParameter("name");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        String submit = req.getParameter("submit");

        if (submit.equals("Login")) {
            Customer customer = cd.getCustomer(userName, password);
            System.out.println(customer.getUserName());
            if (customer.getUserName() != null) {
                req.getRequestDispatcher("/logout").forward(req,res);

            } else {
                session.setAttribute("Error","Error");
                req.getRequestDispatcher("/login").include(req, res);
                System.out.println("dispatch");
            }
        }
    }
}
