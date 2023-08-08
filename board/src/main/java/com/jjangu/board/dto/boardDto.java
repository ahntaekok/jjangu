package com.jjangu.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class boardDto {
    private int b_id;
    private String b_title;
    private String b_content;
    private int b_good;
    private int b_bad;
    private int user_u_id;
}
