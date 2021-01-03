package com.bdqn.entity;

import java.util.Date;

public class Users {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String identitys;
    private String phone;
    private String email;


    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", identitys='" + identitys + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Users(Integer id, String username, String password, String sex, String identitys, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.identitys = identitys;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentitys() {
        return identitys;
    }

    public void setIdentitys(String identitys) {
        this.identitys = identitys;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
