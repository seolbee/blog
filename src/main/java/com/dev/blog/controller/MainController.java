package com.dev.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class MainController {
    @RequestMapping(value = {"/", "main"}, method = RequestMethod.GET)
    public String main(){
        return "/pages/main/landing";
    }
}
