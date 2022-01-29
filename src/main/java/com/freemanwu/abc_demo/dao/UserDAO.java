package com.freemanwu.abc_demo.dao;

import com.freemanwu.abc_demo.entity.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@CacheNamespace
@Mapper
public interface UserDAO {
    void register(User user);
    User findByNameAndPassword(User user);

    void update(User user);
}
