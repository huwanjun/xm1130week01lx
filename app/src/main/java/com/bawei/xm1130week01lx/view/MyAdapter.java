package com.bawei.xm1130week01lx.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.xm1130week01lx.R;
import com.bawei.xm1130week01lx.model.bean.Bean;
import com.bawei.xm1130week01lx.util.NetUtil;

import java.util.List;

/**
 * author: 斛万珺
 * data: 2019/12/30 13:13:52
 * function:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Bean.ShopGridDataBean> shopGridData;

    public MyAdapter(List<Bean.ShopGridDataBean> shopGridData) {

        this.shopGridData = shopGridData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.item_layout, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

      myViewHolder.text_name.setText(shopGridData.get(i).getTitle());
        String imageurl = shopGridData.get(i).getImageurl();
        NetUtil.getInstance().getPhoto(imageurl,myViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return shopGridData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView text_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            text_name=itemView.findViewById(R.id.text_name);
        }
    }
}
