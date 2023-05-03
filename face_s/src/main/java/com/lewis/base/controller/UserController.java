package com.lewis.base.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lewis.base.entity.ComResult;
import com.lewis.base.entity.User;

import com.lewis.base.face.FaceAdd;
import com.lewis.base.mapper.UserMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    //所有的用户
    @RequestMapping(value = "/getAllUser",method = RequestMethod.POST)
    public ComResult<List<User>>  getAllUser(){

        List<User> list = userMapper.selectAll();
        ComResult<List<User>> result = new ComResult<>();
        result.setCode(0);
        result.setCount(list.size());
        result.setData(list);
        result.setMsg("success");
        return result;
    }
    //用户信息
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public ComResult<User>  getUserInfo(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        ComResult<User> result = new ComResult<>();
        result.setCode(0);

        result.setData(user);
        result.setMsg("success");
        return result;
    }  //用户信息
    @RequestMapping(value = "/getUserInfoByFace",method = RequestMethod.POST)
    public ComResult<User>  getUserInfoByFace(String faceid){
        User user = userMapper.getUserInfoByFace(faceid);
        ComResult<User> result = new ComResult<>();
        result.setCode(0);

        result.setData(user);
        result.setMsg("success");
        return result;
    }
    //更新用户信息
   @RequestMapping(value = "/upUser",method = RequestMethod.POST)
    public ComResult  upUser(Integer id,String name,String account,String banji,String img,String zhuanye){
       User user = new User();
       user.setId(id);
       user.setImg(img);
       user.setBanji(banji);
       user.setName(name);
       user.setZhuanye(zhuanye);
       user.setAccount(account);
       int i = userMapper.updateByPrimaryKey(user);

       ComResult result = new ComResult<>();
       if (i==1){
           result.setMsg("success");

       }else {
           result.setMsg("faile");
       }
        result.setCode(0);

        return result;
    }


    //注册
  @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ComResult  addUser(String name,String account,String banji,String img,String zhuanye,String fname) throws Exception {
      User user1 = userMapper.checkUser(account);
      ComResult result = new ComResult<>();

      if (user1!=null){

          result.setMsg("学号已存在");

          result.setCode(0);

          return result;
      }else {
          User user = new User();

          user.setImg(img);
          user.setBanji(banji);
          user.setName(name);
          user.setZhuanye(zhuanye);
          user.setAccount(account);
          String s = new Date().getTime() + "";
          user.setFaceid(s);




              String add = FaceAdd.add("C:\\Users\\Administrator\\Desktop\\res\\" + fname, s);
              JSONObject jsonObject = new JSONObject(add);
              int error_code = jsonObject.getInt("error_code");
              String error_msg = jsonObject.getString("error_msg");
              if (error_code==0){
                  int i = userMapper.insert(user);
                  result.setMsg("添加成功");
              }
          else {
              result.setMsg(error_msg);
          }
          result.setCode(0);

          return result;
      }


    }
    //删除用户
    @RequestMapping(value = "/delUser",method = RequestMethod.POST)
    public ComResult  delUser(Integer id,String faceid){
//
//        String del = FaceAdd.del(faceid);
//        JSONObject jsonObject = new JSONObject(del);
        ComResult result = new ComResult<>();
//        int error_code = jsonObject.getInt("error_code");
//        String error_msg = jsonObject.getString("error_msg");
//        if (error_code==0){
            int i = userMapper.deleteByPrimaryKey(id);
            if (i==1){
                result.setMsg("success");
            }else {
                result.setMsg("faile");
            }
//        }else {
//            result.setMsg(error_msg);
//        }





          result.setCode(0);

          return result;
      }




}
