package com.bawei.xm1130week01lx.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.xm1130week01lx.R;
import com.bawei.xm1130week01lx.base.BaseFragment;
import com.bawei.xm1130week01lx.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends BaseFragment {
    private TextView tv;


    @Override
    protected void initView(View inflate) {
        tv=inflate.findViewById(R.id.tv);

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_others;
    }

    @Override
    protected void initData() {

        Bundle arguments = getArguments();
        if (arguments != null) {
            String key = arguments.getString("key");
            tv.setText(key);
        }

    }

    public static OthersFragment getInstance(String values) {
        OthersFragment othersFragment = new OthersFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",values);
        othersFragment.setArguments(bundle);

        return  othersFragment;
    }
}
