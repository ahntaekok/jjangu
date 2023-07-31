package com.jjangu.board.controller;

import com.jjangu.board.dto.bDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/user")
@Controller
public class user_con {

    @ResponseBody
    @GetMapping("/")
    public String main(){
        return "유저";
    }

    @RequestMapping("/login")
    public String userLogin() {
        return "user/login";
    }

    @RequestMapping("/loginOk")
    public String loginOk(@RequestParam HashMap<String, String> param){

        bDto dto = new bDto();
        System.out.println("아이디 : "+ param.get("u_id"));
        System.out.println("비밀번호 : "+ param.get("u_pw"));

        return "board/boardWrite";
    }

    @RequestMapping("/signUp")
    public String signUp(){
        return "user/signUp";
    }

    @RequestMapping("/signUpOk")
    public String signUpOk(@RequestParam HashMap<String, String> param){

        System.out.println("아이디 : "+ param.get("u_id"));
        System.out.println("비밀번호 : "+ param.get("u_pw"));
        System.out.println("이메일 : "+ param.get("u_email"));

        return "user/login";
    }
}
