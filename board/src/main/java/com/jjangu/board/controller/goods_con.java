package com.jjangu.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/goods")
@Controller
public class goods_con {

    @ResponseBody
    @GetMapping("/")
    public String main(){
        return "상품페이지";
    }

    @RequestMapping("/list")
    public String userLogin() {
        return "goods/goodsList";
    }
}
