package com.bdqn.dao;

import com.bdqn.entity.Comment;
import com.bdqn.vo.CommentVo;

import java.util.List;

public interface CommentMapper {
    //根据页面查询评论
    List<Comment> findCommentByPage(CommentVo vo);

    //根据id删除评论
    int deleteById(Integer id);


}
