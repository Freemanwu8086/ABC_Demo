package com.freemanwu.abc_demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.sql.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Sheet_Music {
    private String music_name;
    private String beat;
    private String tone;
    private String username;
    private String location;
    private Date insert_date;
    private Date last_update_date;
    private String state;
    private String abc;
    private String introduction;
    private Integer id;
}
