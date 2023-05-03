package com.face.base;

public abstract class BasePresenter<M,V> {

    public M mIModle;
    public V mIView;

    public void attachV(V v){
        this.mIView = v;
        if (mIModle == null) {
            mIModle = createModel();
        }
    }

    //当View被销毁掉时删除Presenter层对View层的引用
    public void detachV(){
        mIView = null;
    }

    public abstract M createModel();
}