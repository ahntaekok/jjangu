package com.jjangu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class boardController {

    @ResponseBody
    @GetMapping("/")
    public String controller(){
        return "하이!";
    }
}
