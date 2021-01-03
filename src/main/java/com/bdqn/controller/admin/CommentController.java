package com.bdqn.controller.admin;

import com.bdqn.entity.Comment;
import com.bdqn.service.CommentService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.utils.HashMapUtil;
import com.bdqn.vo.CommentVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/admin/comment")
public class CommentController {

    @Resource
    private CommentService commentService;


    //查询评论
    @RequestMapping("/list")
    public DataGridViewResult list(CommentVo vo){
        //设置分页信息
        PageHelper.startPage(vo.getPage(),vo.getLimit());

        //调用分页查询方法
        List<Comment> commentList= commentService.findCommentByPage(vo);
        //创建分页对象
        PageInfo<Comment> pageInfo =new PageInfo<Comment>(commentList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());

    }

    //删除评论
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){

        /*Map<String,Object> map=new HashMap<String, Object>();
        if (commentService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);*/

        HashMapUtil hashMapUtil=new HashMapUtil();
        return hashMapUtil.checkDelete(commentService.deleteById(id));
    }
}
