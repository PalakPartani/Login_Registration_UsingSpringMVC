package com.demo.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping(path = "/logoutProcess", method = RequestMethod.GET)
    public String showLogout(HttpServletRequest req){
        HttpSession session= req.getSession(true);
        session.setAttribute("customer",null);
        session.invalidate();
        return "login";
    }


}
