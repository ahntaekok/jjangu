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
    public String id_check(HashMap<String, String> param) {
        return dao.id_check(param);
    }

    @Override
    public String nick_check(HashMap<String, String> param) {
        return dao.nick_check(param);
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
