package com.jjangu.board.controller;

import com.jjangu.board.dto.bDto;
import com.jjangu.board.service.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/board")
@Controller
public class board_con {
/*
    @Autowired
    private boardService service;
*/
    @Autowired
    private HttpSession session;

    @ResponseBody
    @RequestMapping("/")
    public String main(){
        return "하이!";
    }
    @RequestMapping("/write")
    public String boardWriteForm(){
        return "board/boardWrite";
    }

    @RequestMapping("/list")
    public String boardList(){
        return "board/boardList";
    }

    @RequestMapping("/writeOk")
    public String boardWriteOk(@RequestParam HashMap<String, String> param, @RequestParam(value = "b_id", defaultValue = "1") int b_id){

        bDto dto = new bDto();
        System.out.println("제목 : "+ param.get("b_title"));
        System.out.println("내용 : "+ param.get("b_content"));
        System.out.println("b_id : "+ dto.getB_id());

        return "board/boardList";
    }
}
