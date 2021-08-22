package com.phinzin.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularRouteHandler {
    @GetMapping(value="{path:home}/**")
    public String forward(){
        return "forward:/index.html";
    }

    @GetMapping(value="")
    public String handleEmpty(){
        return "forward:/index.html";
    }
}
