package com.jjangu.board.dao;

import com.jjangu.board.dto.boardDto;
import com.jjangu.board.dto.userDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface userDao {
    public String id_check(HashMap<String, String> param);
    public void userSignUp(HashMap<String, String> param);
    public userDto userUpdate(HashMap<String, String> param);
    public void userDelete(HashMap<String, String> param);

}