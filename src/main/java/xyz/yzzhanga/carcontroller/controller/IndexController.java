package xyz.yzzhanga.carcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class IndexController {


    @RequestMapping("/index")
    public String init() {
        return "index";
    }
}
