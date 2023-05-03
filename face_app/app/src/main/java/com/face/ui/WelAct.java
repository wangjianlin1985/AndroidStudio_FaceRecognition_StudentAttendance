package com.face.ui;


import android.os.Handler;

import com.face.R;
import com.face.base.BaseMvpActivity;
import com.face.base.BasePresenter;
import com.face.ui.wuye.login.LoginAct;

/**
 * Created by Administrator on 2021/2/11.
 */

public class WelAct extends BaseMvpActivity {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpAct(LoginAct.class);
                finish();
            }
        },2000);
    }

    @Override
    protected int intiLayout() {
        return R.layout.act_wel;
    }

    @Override
    public BasePresenter createPresenter() {
        return new BasePresenter() {
            @Override
            public Object createModel() {
                return null;
            }
        };
    }



}
