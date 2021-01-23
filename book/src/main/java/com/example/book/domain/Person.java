package com.example.book.domain;

public class Person {
    private Integer id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 登录学号/工号
    */
    private String loginnumber;

    /**
    * 密码
    */
    private String password;

    /**
    * 角色
    */
    private String role;

    /**
    * 状态
    */
    private String state;

    /**
    * 备注
    */
    private String note;

    public Integer getId() {
        return id;
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

    public String getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}