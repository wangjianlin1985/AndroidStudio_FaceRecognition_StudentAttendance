package com.face.ui.wuye.login;

import java.util.Map;

import com.face.base.BasePresenter;
import com.face.bean.ComResult;

public class LoginPresenter extends BasePresenter<LoginModel,LoginContract.LoginView> implements LoginContract.LoginPresent,LoginDataSource.OnLoadFinishListener{


    @Override
    public void onSuccess(ComResult result) {
            mIView.onSuccess(result);
    }

    @Override
    public void onError(String e) {
            mIView.onError(e);
    }



    @Override
    public LoginModel createModel() {
        return new LoginModel();
    }

    @Override
    public void load(Map<String, String> map) {
        mIModle.load(this,map);
    }
}