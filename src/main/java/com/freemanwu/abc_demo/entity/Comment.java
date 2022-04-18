package com.freemanwu.abc_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author searchingwu
 * @Description
 * @create 2022-04-14 15:09
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Comment {
    private String username;
    private Integer music_id;
    private String comment;
    private Date comment_date;
    private Integer id;
}
