package com.bawei.xm1130week01lx.presenter;

import com.bawei.xm1130week01lx.base.BasePresenter;
import com.bawei.xm1130week01lx.contract.IHomeContract;
import com.bawei.xm1130week01lx.model.HomeModel;
import com.bawei.xm1130week01lx.model.bean.Bean;

/**
 * author: 斛万珺
 * data: 2019/12/30 13:13:41
 * function:
 */
public class HomePresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
        homeModel.getHomeData(new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onHomeSuccess(Bean bean) {
                view.onHomeSuccess(bean);
            }

            @Override
            public void onHomeFailure(Throwable throwable) {

                view.onHomeFailure(throwable);
            }
        });

    }
}
