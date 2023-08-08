package com.jjangu.board.service;


import com.jjangu.board.dao.boardDao;
import com.jjangu.board.dto.boardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("boardService")
@Slf4j
public class boardServiceImpl implements boardService {
    @Autowired
    private boardDao dao;

    @Override
    public ArrayList<boardDto> boardSelect(HashMap<String, String> param) {
        return dao.boardSelect(param);
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
