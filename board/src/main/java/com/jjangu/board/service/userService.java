package com.jjangu.board.service;

import com.jjangu.board.dto.userDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface userService {
    public String id_check(HashMap<String, String> param);
    public String nick_check(HashMap<String, String> param);
    public void userSignUp(HashMap<String, String> param);
    public userDto userUpdate(HashMap<String, String> param);
    public void userDelete(HashMap<String, String> param);
}
