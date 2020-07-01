package com.demo.registration.service;

import com.demo.registration.interfaces.ICustomerOperation;
import com.demo.registration.model.Customer;
import com.demo.registration.repository.CustomerOperationImplementation;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginService {
    ICustomerOperation cd = new CustomerOperationImplementation();

    public Customer setSession(String userName, String password) {
        System.out.println("In service");
        Customer customer = cd.getCustomer(userName, password);
        System.out.println(customer.getUserName());
        if (customer.getUserName() != null) {
            return customer;
        }
        return null;
    }

    public Customer setSession(HttpServletRequest req) {
        ICustomerOperation cd = new CustomerOperationImplementation();
        System.out.println("In service");
        Customer customer = cd.getCustomer(req.getParameter("name"), req.getParameter("password"));
        System.out.println(customer.getUserName());
        if (customer.getUserName() != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("name", customer.getUserName());
            session.setAttribute("address", customer.getAddress());
            session.setAttribute("email", customer.getEmailId());
            return customer;
        }
        return null;
    }
}