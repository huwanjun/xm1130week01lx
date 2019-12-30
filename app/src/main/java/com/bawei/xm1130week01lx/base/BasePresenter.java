package com.bawei.xm1130week01lx.base;

/**
 * author: 斛万珺
 * data: 2019/12/30 11:11:26
 * function:
 */
public abstract class BasePresenter<V> {

    protected V view;

    public BasePresenter() {

        initModel();
    }

    public void attach(V view){
        this.view=view;
    }

    public void detach(){
       view=null;
    }


    protected abstract void initModel();
}
