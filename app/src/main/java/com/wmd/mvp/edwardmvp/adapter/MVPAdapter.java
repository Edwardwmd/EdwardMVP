package com.wmd.mvp.edwardmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wmd.mvp.edwardmvp.R;
import com.wmd.mvp.edwardmvp.bean.GirlsClothsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017/11/18/16：12
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.MyViewHolder> {
    private LayoutInflater mLF;
    private List<GirlsClothsBean> girlsClothsBeans = new ArrayList<>();
    private Context mC;


    public MVPAdapter(Context context) {
        mLF = LayoutInflater.from(context);
        mC = context;
    }

    public void setData(List<GirlsClothsBean> girlsClothsBeans) {
        this.girlsClothsBeans.clear();
        this.girlsClothsBeans.addAll(girlsClothsBeans);
        notifyDataSetChanged();
    }

    @Override
    public MVPAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLF.inflate(R.layout.item_mvpshow, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MVPAdapter.MyViewHolder holder, int position) {
        Glide.with(mC).load(girlsClothsBeans.get(position).getImage()).into(holder.icon);
        holder.lebel.setText(girlsClothsBeans.get(position).getLeble());
    }

    @Override
    public int getItemCount() {
        return girlsClothsBeans == null ? 0 : girlsClothsBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView lebel;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            lebel = (TextView) itemView.findViewById(R.id.lebel);
        }
    }

}
