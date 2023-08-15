package com.jjangu.board.controller;

import com.jjangu.board.dto.boardDto;
import com.jjangu.board.service.boardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RequestMapping("/board")
@Controller
public class board_con {
    private boardService service;

    @Autowired
    public board_con(boardService service){
        this.service = service;
    }

    @Autowired
    private HttpSession session;

    @ResponseBody
    @RequestMapping("/")
    public String main(){
        return "하이!";
    }
//    게시판 작성 페이지
    @RequestMapping("/write")
    public String boardWriteForm(){

        return "board/boardWrite";
    }

//    게시판 리스트 페이지
    @RequestMapping("/list")
    public String boardList(Model model){
        model.addAttribute("boardList", service.boardList());
        return "board/boardList";
    }

//    게시판 작성 메소드
    @RequestMapping("/writeOk")
    public String boardWriteOk(@RequestParam HashMap<String, String> param, @RequestParam(value = "b_id", defaultValue = "1") int b_id){

        service.boardWrite(param);

        return "redirect:list";
    }

//    게시판 수정 메소드
    @RequestMapping("/Modify")
    public String boardModify(HttpServletRequest request, @RequestParam HashMap<String, String> param, Model model) {
        if (request.getSession().getAttribute("u_id") != null) {
            paramPutU_id(request, param);
//			if (param.get("access_token") != null) {
//				ArrayList<KakaoDTO> dtos = usersService.kakaoUserSearch(param);
//				model.addAttribute("usersInfo", dtos);
//			} else {
            boardDto dtos = service.boardUpdate(param);

            model.addAttribute("boardModify", dtos);
//			}

        }
        return "board/boardModify";
    }

    /** u_id 넣는 메소드 **/
    private void paramPutU_id(HttpServletRequest request, HashMap<String, String> param) {
        HttpSession session = request.getSession();
        String u_id = String.valueOf(session.getAttribute("u_id"));
        param.put("u_id", u_id);
    }
}
