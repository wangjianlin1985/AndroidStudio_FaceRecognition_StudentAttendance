package com.face.ui.wuye.login;

import com.face.bean.ComResult;

import java.util.Map;

public class LoginModel  implements LoginDataSource {


    /**
     * model层主要用来进行数据存储操作，例如：数据读写和网络请求。
     * 这里进行下模拟耗时操作
     * @param listener
     */

    @Override
    public void load(final OnLoadFinishListener listener, Map<String, String> map) {
        String account = map.get("account");
        String pwd = map.get("pwd");
        ComResult comResult = new ComResult();
        if ("admin".equals(account)&&"123456".equals(pwd)){
            comResult.code=0;
            comResult.msg="登陆成功";
            listener.onSuccess(comResult);
        }else {
            listener.onError("账号或者密码不正确");
        }
    }


}