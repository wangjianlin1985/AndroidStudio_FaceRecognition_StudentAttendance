package com.face.ui.wuye.login;

import com.face.bean.ComResult;

import java.util.Map;

public interface LoginDataSource {

    interface OnLoadFinishListener{


        void onSuccess(ComResult result);
        void onError(String e);
    }

    void load(OnLoadFinishListener listener, Map<String, String> map);
}