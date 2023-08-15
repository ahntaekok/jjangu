package com.jjangu.board.dao;

import com.jjangu.board.dto.boardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface boardDao {
    public ArrayList<boardDto> boardList();
    public void boardWrite(HashMap<String, String> param);
    public void boardUpdate(HashMap<String, String> param);
    public void boardDelete(HashMap<String, String> param);

}