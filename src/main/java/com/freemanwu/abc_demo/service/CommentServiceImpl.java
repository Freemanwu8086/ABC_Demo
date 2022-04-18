package com.freemanwu.abc_demo.service;

import com.freemanwu.abc_demo.dao.CommentDAO;
import com.freemanwu.abc_demo.entity.Comment;
import com.freemanwu.abc_demo.entity.Sheet_Music;
import com.freemanwu.abc_demo.utils.ConstantUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author searchingwu
 * @Description
 * @create 2022-04-14 15:15
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;
    @Override
    public void saveComment(Comment comment) {
        commentDAO.saveComment(comment);
    }

    @Override
    public PageInfo<Comment> findAllComments(int pageNo, Integer music_id) {
        PageHelper.startPage(pageNo, ConstantUtils.PAGE_SIZE);
        List<Comment> list = commentDAO.findAllComments(music_id);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void deleteOneComment(Integer id) {
        commentDAO.deleteOneComment(id);
    }
}
