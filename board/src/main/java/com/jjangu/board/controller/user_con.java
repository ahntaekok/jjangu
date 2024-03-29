package com.jjangu.board.controller;

import com.jjangu.board.dto.boardDto;
import com.jjangu.board.service.boardService;
import com.jjangu.board.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Slf4j
@RequestMapping("/user")
@Controller
public class user_con {

    private userService service;

    @Autowired
    public user_con(userService service){
        this.service = service;
    }

    @Autowired
    private HttpSession session;

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

        System.out.println("아이디 : "+ param.get("u_id"));
        session.setAttribute("u_id", param.get("u_id"));

        return "board/boardList";
    }

    @RequestMapping("/signUp")
    public String signUp(@RequestParam HashMap<String, String> param){
        param.get("u_nickname");

        service.userSignUp(param);

        return "user/login";
    }
    @RequestMapping("/id_check")
    public ResponseEntity<Integer> id_check(@RequestParam HashMap<String, String> param){

        if (service.id_check(param)!=null){
            return ResponseEntity.status(HttpStatus.OK).body(404);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(202);
        }
    }
    @RequestMapping("/nick_check")
    public ResponseEntity<Integer> nick_check(@RequestParam HashMap<String, String> param){

        if (service.nick_check(param)!=null){
            return ResponseEntity.status(HttpStatus.OK).body(404);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(202);
        }
    }
}
