package com.bdqn.service.impl;

import com.bdqn.dao.RoomMapper;
import com.bdqn.entity.Room;
import com.bdqn.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    public Room findFrontLogout(int room_state) {
        return roomMapper.findFrontLogout(room_state);
    }

    public int clearFrontLogout(int room_state) {
        return roomMapper.clearFrontLogout(room_state);
    }
}
