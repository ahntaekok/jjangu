package com.jjangu.board.service;

import com.jjangu.board.dto.boardDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface boardService {
    public ArrayList<boardDto> boardList();
    public void boardWrite(HashMap<String, String> param);
    public boardDto boardUpdate(HashMap<String, String> param);
    public void boardDelete(HashMap<String, String> param);
}
