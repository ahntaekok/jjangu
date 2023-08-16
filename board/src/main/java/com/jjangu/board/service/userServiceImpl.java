package com.jjangu.board.service;


import com.jjangu.board.dao.boardDao;
import com.jjangu.board.dao.userDao;
import com.jjangu.board.dto.boardDto;
import com.jjangu.board.dto.userDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@Slf4j
public class userServiceImpl implements userService {
    private userDao dao;
    @Autowired
    public userServiceImpl(userDao dao){
        this.dao = dao;
    }

    @Override
    public ArrayList<userDto> userList() {
        return null;
    }

    @Override
    public void userSignUp(HashMap<String, String> param) {
        dao.userSignUp(param);
    }

    @Override
    public userDto userUpdate(HashMap<String, String> param) {
        return null;
    }

    @Override
    public void userDelete(HashMap<String, String> param) {
        dao.userDelete(param);
    }
}
