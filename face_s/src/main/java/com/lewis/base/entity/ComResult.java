package com.lewis.base.entity;

public class ComResult<T> {
    private int code;
    private String msg;
    private int count;

//    private int count;  如果是layui列表必须返回   code应为0和1
    private T data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
