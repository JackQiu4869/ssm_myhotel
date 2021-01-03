package com.bdqn.entity;

public class RoomType {
    private Integer id;//房型编号
    private String name;//房型名称
    private Integer price;//房型价格
    private String picture;//房型照片
    private String my_states;//房型有无空闲

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", my_states='" + my_states + '\'' +
                '}';
    }

    public RoomType(Integer id, String name, Integer price, String picture, String my_states) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.my_states = my_states;
    }

    public RoomType() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMy_states() {
        return my_states;
    }

    public void setMy_states(String my_states) {
        this.my_states = my_states;
    }
}

