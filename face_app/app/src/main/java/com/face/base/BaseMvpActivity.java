package com.face.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;



import butterknife.ButterKnife;

@SuppressLint("Registered")
public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{

    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(intiLayout());
        ButterKnife.bind(this);

        if (mPresenter == null) {
            mPresenter = createPresenter();
        }

        mPresenter.attachV(this);
        initView();
        //设置数据
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();


    protected abstract int intiLayout();


    //当View被销毁掉时删除Presenter层对View层的引用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachV();
    }

    public abstract P createPresenter();

    public void jumpAct(Class s){
        Intent intent = new Intent(this, s);
        startActivity(intent);
    } public void jumpAct(Class s,int res){
        Intent intent = new Intent(this, s);
        startActivityForResult(intent,res);
    }
    public void jumpAct(Class s,Bundle bundle){
        Intent intent = new Intent(this, s);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void toast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

}