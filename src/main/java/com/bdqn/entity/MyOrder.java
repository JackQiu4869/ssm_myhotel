package com.bdqn.entity;

import java.util.Date;

public class MyOrder {
    private Integer id;
    private String username;
    private String room_number;
    private String type;
    private Date time_in;
    private Integer time_number;
    private String phone;
    private Integer price;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", room_number='" + room_number + '\'' +
                ", type='" + type + '\'' +
                ", time_in=" + time_in +
                ", time_number=" + time_number +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime_in() {
        return time_in;
    }

    public void setTime_in(Date time_in) {
        this.time_in = time_in;
    }

    public Integer getTime_number() {
        return time_number;
    }

    public void setTime_number(Integer time_number) {
        this.time_number = time_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public MyOrder() {
    }

    public MyOrder(Integer id, String username, String room_number, String type, Date time_in, Integer time_number, String phone, Integer price) {
        this.id = id;
        this.username = username;
        this.room_number = room_number;
        this.type = type;
        this.time_in = time_in;
        this.time_number = time_number;
        this.phone = phone;
        this.price = price;
    }
}
