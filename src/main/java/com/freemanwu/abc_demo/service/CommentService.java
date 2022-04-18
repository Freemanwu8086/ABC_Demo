package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.entity.Comment;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author searchingwu
 * @Description
 * @create 2022-04-14 15:13
 */
public interface CommentService {
    void saveComment(Comment comment);

    PageInfo<Comment> findAllComments(int pageNo, Integer music_id);

    void deleteOneComment(Integer id);
}
