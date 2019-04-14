package com.fan.pojo;

public class Result {
    private String message;
    private int code;
    private User data;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public User getData() {
        return data;
    }
    public void setData(User data) {
        this.data = data;
    }
}
