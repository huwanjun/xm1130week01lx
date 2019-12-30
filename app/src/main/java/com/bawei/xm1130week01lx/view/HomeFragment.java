package com.bawei.xm1130week01lx.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.xm1130week01lx.R;
import com.bawei.xm1130week01lx.base.BaseFragment;
import com.bawei.xm1130week01lx.base.BasePresenter;
import com.bawei.xm1130week01lx.contract.IHomeContract;
import com.bawei.xm1130week01lx.model.bean.Bean;
import com.bawei.xm1130week01lx.presenter.HomePresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {
    private Button btn_dian;
    private RecyclerView recy;


    @Override
    protected void initView(View inflate) {
        btn_dian=inflate.findViewById(R.id.btn_dian);
        recy=inflate.findViewById(R.id.recy);

        btn_dian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               MainActivity activity=(MainActivity) getActivity();
               activity.tiao();
            }
        });

    }

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {

        mPresenter.getHomeData();
    }

    @Override
    public void onHomeSuccess(Bean bean) {

        List<Bean.ShopGridDataBean> shopGridData = bean.getShopGridData();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recy.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(shopGridData);
        recy.setAdapter(myAdapter);



    }

    @Override
    public void onHomeFailure(Throwable throwable) {

        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();

    }
}
