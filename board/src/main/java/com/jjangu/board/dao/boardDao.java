package com.jjangu.board.dao;

import com.jjangu.board.dto.boardDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public interface boardDao {
    public ArrayList<boardDto> boardSelect(HashMap<String, String> param);
    public void boardWrite(HashMap<String, String> param);
    public void boardUpdate(HashMap<String, String> param);
    public void boardDelete(HashMap<String, String> param);

}