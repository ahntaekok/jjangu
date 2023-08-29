package com.jjangu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/company")
@Controller
public class com_con {

    @RequestMapping("")
    public String company() {
        return "company/company";
    }
}
