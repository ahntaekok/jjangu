package com.jjangu.board.service;


import com.jjangu.board.dao.boardDao;
import com.jjangu.board.dto.boardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@Slf4j
public class boardServiceImpl implements boardService {
    private boardDao dao;
    @Autowired
    public boardServiceImpl(boardDao dao){
        this.dao = dao;
    }

    @Override
    public ArrayList<boardDto> boardList() {
        return dao.boardList();
    }

    @Override
    public void boardWrite(HashMap<String, String> param) {
        dao.boardWrite(param);
    }

    @Override
    public boardDto boardUpdate(HashMap<String, String> param) {
        dao.boardUpdate(param);
        return null;
    }

    @Override
    public void boardDelete(HashMap<String, String> param) {
        dao.boardDelete(param);
    }
}
