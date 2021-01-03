package com.bdqn.service;

import com.bdqn.entity.RoomType;
import com.bdqn.vo.RoomTypeVo;

import java.util.List;

public interface RoomTypeService {

    List<RoomType> findRoomTypeByPage(RoomTypeVo vo);

    int updateRoomType(RoomType roomType);

    int deleteById(Integer id);
}
