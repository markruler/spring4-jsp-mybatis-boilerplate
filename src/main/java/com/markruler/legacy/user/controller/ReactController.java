package com.markruler.legacy.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReactController {

    private final Environment environment;

    @Autowired
    public ReactController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/a")
    public String goA() {
        return "a";
    }

    @GetMapping("/c")
    public String goB() {
        return "c";
    }

}
