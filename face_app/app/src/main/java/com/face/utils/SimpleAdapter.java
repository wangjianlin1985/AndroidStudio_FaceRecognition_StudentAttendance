package com.face.utils;


import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SimpleAdapter<T> extends BaseQuickAdapter<T,BaseViewHolder> {

    private final ConVert conVert;

    public SimpleAdapter(int layoutResId, @Nullable List data, ConVert<T> conVert) {

        super(layoutResId, data);
        this.conVert =conVert;

    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        conVert.convert(helper,item);
    }
    public interface ConVert<T>{
        void convert(BaseViewHolder helper, T t);
    }
}
