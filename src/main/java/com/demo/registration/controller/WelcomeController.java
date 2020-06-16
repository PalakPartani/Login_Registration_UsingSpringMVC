package com.demo.registration.controller;
/**
 * purpose:mapping different controllers
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String printHello() {
         return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        System.out.println("inside login");
        return "login";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register() {
        System.out.println("inside register");
        return "register";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        System.out.println("inside logout");
        return "Logout";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("inside index");
        return "index";
    }
}