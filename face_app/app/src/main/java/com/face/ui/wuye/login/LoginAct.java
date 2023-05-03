package com.face.ui.wuye.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.face.bean.ComResult;


import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import com.face.R;
import com.face.base.BaseMvpActivity;
import com.face.ui.yezhu.ScanFaceAct;

/**
 * Created by Administrator on 2021/1/27.
 */

public class LoginAct extends BaseMvpActivity<LoginPresenter> implements LoginContract.LoginView {


    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_pwd)
    EditText etPwd;



    @Override
    public void onSuccess(ComResult result) {
        if (result!=null){
            toast(result.msg);
            jumpAct(ScanFaceAct.class);
            finish();
        }

    }

    @Override
    public void onError(String s) {
        toast(s);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int intiLayout() {
        return R.layout.act_login;
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @OnClick({R.id.bt_Login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_Login:
                // validate
                String account = etAccount.getText().toString().trim();
                if (TextUtils.isEmpty(account)) {
                    Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }

                String pwd = etPwd.getText().toString().trim();
                if (TextUtils.isEmpty(pwd)) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                Map<String,String> map=new HashMap<>();
                map.put("account",account);
                map.put("pwd",pwd);
                mPresenter.load(map);
                break;

        }
    }
}
