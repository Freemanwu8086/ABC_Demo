package com.freemanwu.abc_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @author searchingwu
 * @Description
 * @create 2022-02-15 15:14
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Announce {
    private String announce;
    private Date update_date;
    private Integer id;
}
