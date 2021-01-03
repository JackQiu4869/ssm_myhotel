package com.bdqn.dao;

import com.bdqn.entity.Room;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    //根据前台用户id查找对应房间
    Room findFrontLogout(int room_state);

    //清空房间住户
    int clearFrontLogout(int room_state);
}
