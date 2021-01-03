package com.bdqn.controller.admin;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.RoomType;
import com.bdqn.entity.Users;
import com.bdqn.service.RoomTypeService;
import com.bdqn.utils.DataGridViewResult;
import com.bdqn.utils.HashMapUtil;
import com.bdqn.utils.SystemConstant;
import com.bdqn.vo.RoomTypeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/room")
public class RoomTypeController {

    @Resource
    private RoomTypeService roomTypeService;


    //查询房型
    @RequestMapping("/list")
    public DataGridViewResult list(RoomTypeVo vo){
        //设置分页信息
        PageHelper.startPage(vo.getPage(),vo.getLimit());

        //调用分页查询方法
        List<RoomType> roomTypeList= roomTypeService.findRoomTypeByPage(vo);
        //创建分页对象
        PageInfo<RoomType> pageInfo =new PageInfo<RoomType>(roomTypeList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());

    }

    //修改房型信息
    @RequestMapping("/updateRoomType")
    public String updateRoomType(RoomType roomType){
        Map<String,Object> map=new HashMap<String, Object>();
        if (roomTypeService.updateRoomType(roomType)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }


    //删除房型
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        /*Map<String,Object> map=new HashMap<String, Object>();
        if (roomTypeService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);*/

        HashMapUtil hashMapUtil=new HashMapUtil();
        return hashMapUtil.checkDelete(roomTypeService.deleteById(id));

    }


}
