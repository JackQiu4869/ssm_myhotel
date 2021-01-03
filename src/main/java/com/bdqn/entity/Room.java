package com.bdqn.entity;

public class Room {
    private Integer room_id;//房间id
    private String name;//住户姓名
    private String identitys;//住户身份证
    private Integer room_type;//房间类型
    private int room_state;//对应住户id

    public Room() {
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                ", identitys='" + identitys + '\'' +
                ", room_type=" + room_type +
                ", room_state=" + room_state +
                '}';
    }

    public Room(Integer room_id, String name, String identitys, Integer room_type, int room_state) {
        this.room_id = room_id;
        this.name = name;
        this.identitys = identitys;
        this.room_type = room_type;
        this.room_state = room_state;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentitys() {
        return identitys;
    }

    public void setIdentitys(String identitys) {
        this.identitys = identitys;
    }

    public Integer getRoom_type() {
        return room_type;
    }

    public void setRoom_type(Integer room_type) {
        this.room_type = room_type;
    }

    public int getRoom_state() {
        return room_state;
    }

    public void setRoom_state(int room_state) {
        this.room_state = room_state;
    }
}
