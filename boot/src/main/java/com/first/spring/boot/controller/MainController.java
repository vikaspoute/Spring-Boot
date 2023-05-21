package com.first.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(Model model) {
        System.out.println("This is Home page controller");
        model.addAttribute("message", "Welcome to the home page!");
        return "home";
    }

    @RequestMapping("/contact")
    public String contact() {
        System.out.println("This is Contact page controller");
        return "contact";
    }
}
