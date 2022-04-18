package com.freemanwu.abc_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author searchingwu
 * @Description
 * @create 2022-04-13 17:05
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Favorite {
    private String username;
    private Integer music_id;
    private Date collect_date;
}
