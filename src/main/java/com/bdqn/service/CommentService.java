package com.bdqn.service;

import com.bdqn.entity.Comment;
import com.bdqn.vo.CommentVo;

import java.util.List;

public interface CommentService {
    //管理员查看评论
    List<Comment> findCommentByPage(CommentVo vo);

    int deleteById(Integer id);


}
