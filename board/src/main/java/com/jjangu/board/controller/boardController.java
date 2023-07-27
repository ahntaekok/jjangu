package com.jjangu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class boardController {

    @GetMapping("/")
    public String controller(){
        return "하이!";
    }
}
