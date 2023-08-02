package com.jjangu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class home_con {

    @GetMapping("")
    public String main(){
        return "home";
    }
}
