package com.bawei.xm1130week01lx.model;

import com.bawei.xm1130week01lx.contract.IHomeContract;
import com.bawei.xm1130week01lx.model.bean.Bean;
import com.bawei.xm1130week01lx.util.NetUtil;
import com.google.gson.Gson;

/**
 * author: 斛万珺
 * data: 2019/12/30 13:13:39
 * function:
 */
public class HomeModel implements IHomeContract.IModel{
    @Override
    public void getHomeData(final IModelCallback iModelCallback) {

        NetUtil.getInstance().getJsonGet("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCallback() {
            @Override
            public void onSuccess(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                iModelCallback.onHomeSuccess(bean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallback.onHomeFailure(throwable);

            }
        });
    }
}
