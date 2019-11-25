package com.epsi.guez.debugme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @RequestMapping(value = {"", "/", "/login"})
    public String login() {
        System.out.println("bla bla");
        return "/login";
    }
}
