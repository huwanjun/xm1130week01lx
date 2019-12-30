package com.bawei.xm1130week01lx.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.xm1130week01lx.R;
import com.bawei.xm1130week01lx.base.BaseActivity;
import com.bawei.xm1130week01lx.base.BaseFragment;
import com.bawei.xm1130week01lx.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ViewPager vp;
    private RadioGroup rg;
    private List<Fragment> list=new ArrayList<>();


    @Override
    protected void initData() {


        OthersFragment flFragment = OthersFragment.getInstance("首页");
        OthersFragment gwFragment = OthersFragment.getInstance("分类");
        OthersFragment fxFragment = OthersFragment.getInstance("发现");
        HomeFragment homeFragment = new HomeFragment();
        OthersFragment myFragment = OthersFragment.getInstance("我的");


        list.add(flFragment);
        list.add(gwFragment);
        list.add(fxFragment);
        list.add(homeFragment);
        list.add(myFragment);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

    }

    @Override
    protected void initView() {
        vp=findViewById(R.id.vp);
        rg=findViewById(R.id.rg);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.btn1:
                        vp.setCurrentItem(0);
                        break;

                    case R.id.btn2:
                        vp.setCurrentItem(1);
                        break;

                    case R.id.btn3:
                        vp.setCurrentItem(2);
                        break;

                    case R.id.btn4:
                        vp.setCurrentItem(3);
                        break;

                    case R.id.btn5:
                        vp.setCurrentItem(4);
                        break;

                }


            }
        });

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    public void tiao(){
        vp.setCurrentItem(0);
    }
}
