package com.wmd.mvp.edwardmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wmd.mvp.edwardmvp.R;
import com.wmd.mvp.edwardmvp.bean.PersonBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017/11/21/16：31
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class SqlAdapter extends RecyclerView.Adapter<SqlAdapter.MyViewHolder> {
    private LayoutInflater mFL;
    private List<PersonBean> personBeans = new ArrayList<>();

    public SqlAdapter(Context context) {
        mFL = LayoutInflater.from(context);
    }

    public void setData(List<PersonBean> personBeans) {
        this.personBeans.clear();
        this.personBeans = personBeans;
        notifyDataSetChanged();
    }

    @Override
    public SqlAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mFL.inflate(R.layout.item_sqlit, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SqlAdapter.MyViewHolder holder, int position) {
        holder.name.setText(personBeans.get(position).getName());
        holder.sex.setText(personBeans.get(position).getSex());
        holder.age.setText(String.valueOf(personBeans.get(position).getAge()));

    }

    @Override
    public int getItemCount() {
        return personBeans == null ? 0 : personBeans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, sex, age;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            sex = (TextView) itemView.findViewById(R.id.sex);
            age = (TextView) itemView.findViewById(R.id.age);
        }
    }


}
