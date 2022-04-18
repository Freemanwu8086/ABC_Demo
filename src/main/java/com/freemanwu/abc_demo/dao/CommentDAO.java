package com.freemanwu.abc_demo.dao;

import com.freemanwu.abc_demo.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author searchingwu
 * @Description
 * @create 2022-04-14 15:12
 */
@Mapper
public interface CommentDAO {
    void saveComment(Comment comment);

    List<Comment> findAllComments(Integer music_id);

    void deleteOneComment(Integer id);
}
