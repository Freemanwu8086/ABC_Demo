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
public class User  {
    private String username;
    private String password;
    private String phoneNumber;
    private Date birthday;

}
