package com.jjangu.board.service;

import com.jjangu.board.dto.userDto;

import java.util.ArrayList;
import java.util.HashMap;

public interface userService {
    public ArrayList<userDto> userList();
    public void userSignUp(HashMap<String, String> param);
    public userDto userUpdate(HashMap<String, String> param);
    public void userDelete(HashMap<String, String> param);
}
