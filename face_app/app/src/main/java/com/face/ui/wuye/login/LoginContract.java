package com.face.ui.wuye.login;

import java.util.Map;

import com.face.base.IBaseView;
import com.face.bean.ComResult;

public interface LoginContract extends IBaseView {

    interface LoginPresent {
        void load(Map<String,String> map);
    }

    interface LoginView {
        void onSuccess(ComResult result);
        void onError(String s);
    }

}