package com.bawei.xm1130week01lx.contract;

import com.bawei.xm1130week01lx.model.bean.Bean;

/**
 * author: 斛万珺
 * data: 2019/12/30 13:13:37
 * function:
 */
public interface IHomeContract {

    interface IView{
        void onHomeSuccess(Bean bean);
        void onHomeFailure(Throwable throwable);

    }

    interface IPresenter{
        void getHomeData();

    }

    interface IModel{
        void getHomeData(IModelCallback iModelCallback);

        interface IModelCallback{
            void onHomeSuccess(Bean bean);
            void onHomeFailure(Throwable throwable);

        }

    }
}
