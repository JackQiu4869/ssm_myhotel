package com.bdqn.service.impl;

import com.bdqn.dao.RoomTypeMapper;
import com.bdqn.entity.RoomType;
import com.bdqn.service.RoomTypeService;
import com.bdqn.vo.RoomTypeVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService {

    @Resource
    private RoomTypeMapper roomTypeMapper;

    public List<RoomType> findRoomTypeByPage(RoomTypeVo vo) {
        return roomTypeMapper.findRoomTypeByPage(vo);
    }

    public int updateRoomType(RoomType roomType) {
        return roomTypeMapper.updateRoomType(roomType);
    }

    public int deleteById(Integer id) {
        return roomTypeMapper.deleteById(id);
    }
}
