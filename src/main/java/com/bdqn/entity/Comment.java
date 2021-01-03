package com.bdqn.entity;

public class Comment {
    private Integer id;
    private String room_type;
    private String name;
    private String comment_contain;

    public Comment() {
    }

    public Comment(Integer id, String room_type, String name, String comment_contain) {
        this.id = id;
        this.room_type = room_type;
        this.name = name;
        this.comment_contain = comment_contain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment_contain() {
        return comment_contain;
    }

    public void setComment_contain(String comment_contain) {
        this.comment_contain = comment_contain;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", room_type='" + room_type + '\'' +
                ", name='" + name + '\'' +
                ", comment_contain='" + comment_contain + '\'' +
                '}';
    }
}
