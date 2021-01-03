package com.bdqn.dao;

import com.bdqn.entity.RoomType;
import com.bdqn.vo.RoomTypeVo;
import java.util.List;

public interface RoomTypeMapper {

    //根据页面查询房型
    List<RoomType> findRoomTypeByPage(RoomTypeVo vo);

    //修改房型
    int updateRoomType(RoomType roomType);

    //删除房型
    int deleteById(Integer id);
}
