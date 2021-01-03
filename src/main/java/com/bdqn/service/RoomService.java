package com.bdqn.service;

import com.bdqn.entity.Room;

public interface RoomService {

    //根据用户id找到对应房间的用户
    Room findFrontLogout(int room_state);

    //清空房间住户
    int clearFrontLogout(int room_state);
}
