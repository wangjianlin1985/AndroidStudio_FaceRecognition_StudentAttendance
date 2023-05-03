package com.face.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2021/2/11.
 */

public class UserBean implements Serializable{
    public int code;
    public String msg;
    public DataBean data;



    public  static class DataBean implements Serializable{

        public int id;
        public String name;
        public String account;
        public String faceid;
        public String zhuanye;
        public String banji;



    }

}
