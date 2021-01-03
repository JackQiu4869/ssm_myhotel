package com.bdqn.service.impl;

import com.bdqn.dao.CommentMapper;
import com.bdqn.dao.UsersMapper;
import com.bdqn.entity.Comment;
import com.bdqn.service.CommentService;
import com.bdqn.vo.CommentVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    public List<Comment> findCommentByPage(CommentVo vo) {
        return commentMapper.findCommentByPage(vo);
    }

    public int deleteById(Integer id) {
        return commentMapper.deleteById(id);
    }


}
