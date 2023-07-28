package com.jjangu.board.controller;

import com.jjangu.board.dto.bDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@RequestMapping("/board")
@Controller
public class bController {

    @ResponseBody
    @GetMapping("/")
    public String main(){
        return "하이!";
    }
    @GetMapping("/write")
    public String boardWriteForm(){
        return "boardWrite";
    }

    @GetMapping("/writeOk")
    public String boardWriteOk(@RequestParam HashMap<String, String> param, @RequestParam(value = "b_id", defaultValue = "1") int b_id){

        bDto dto = new bDto();
        dto.setB_id(param.get("b_id"));
        System.out.println("제목 : "+ param.get("b_title"));
        System.out.println("내용 : "+ param.get("b_content"));
        System.out.println("b_id : "+ dto.getB_id());

        return "boardWrite";
    }
}