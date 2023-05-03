package com.face.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2021/1/27.
 */

public abstract class BaseMvpFragment<P extends BasePresenter>  extends Fragment implements IBaseView{

    private Unbinder bind;
    protected FragmentActivity mActivity;
    public P mPresenter;
    // Fragment被创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();// 获取所在的activity对象

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(intiLayout(), container, false);
        bind = ButterKnife.bind(this, inflate);

        if (mPresenter == null) {
            mPresenter = createPresenter();
        }

        mPresenter.attachV(this);
        initView();
        initData();
        return inflate;
    }
    protected abstract void initData();

    protected abstract void initView();


    protected abstract int intiLayout();

    public void jumpAct(Class s){
        Intent intent = new Intent(mActivity, s);
        startActivity(intent);
    } public void jumpAct(Class s,int res){
        Intent intent = new Intent(mActivity, s);
        startActivityForResult(intent,res);
    }
    public void jumpAct(Class s,Bundle bundle){
        Intent intent = new Intent(mActivity, s);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void toast(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onDestroyView() {
        if (bind != null) {
            bind.unbind();
        }
        mPresenter.detachV();
        super.onDestroyView();
    }
    public abstract P createPresenter();
}
