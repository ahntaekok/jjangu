package com.jjangu.board.dao;
import com.jjangu.board.dto.boardDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public interface boardDao {
    public ArrayList<boardDto> boardSelect(HashMap<String, String> param);
    public void boardWrite(HashMap<String, String> param);
    public void boardUpdate(HashMap<String, String> param);
    public void boardDelete(HashMap<String, String> param);

}