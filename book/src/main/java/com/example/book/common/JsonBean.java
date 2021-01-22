package com.example.book.common;

public class JsonBean {

    private int code;//-1代表失败，0代表成功；-999系统异常

    private String msg;//返回消息

    private Object data;//返回系统数据

    public JsonBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public JsonBean(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
