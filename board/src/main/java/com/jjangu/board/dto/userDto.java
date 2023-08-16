package com.jjangu.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDto {
    private int u_id;
    private String u_name;
    private String u_pw;
    private String u_nickname;
    private int u_postcode;
    private String u_address;
    private String u_extraAddress;
    private String u_detailAddress;
    private Date u_created;
}
