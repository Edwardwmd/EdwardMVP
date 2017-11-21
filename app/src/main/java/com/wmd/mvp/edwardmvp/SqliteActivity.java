package com.wmd.mvp.edwardmvp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wmd.mvp.edwardmvp.adapter.SqlAdapter;
import com.wmd.mvp.edwardmvp.bean.PersonBean;
import com.wmd.mvp.edwardmvp.mvp.BaseActivity;
import com.wmd.mvp.edwardmvp.mvp.presenter.SqlPresenter;
import com.wmd.mvp.edwardmvp.mvp.view.SqlView;
import com.wmd.mvp.edwardmvp.utils.Contants;

import java.util.ArrayList;
import java.util.List;

public class SqliteActivity extends BaseActivity<SqlView, SqlPresenter<SqlView>> implements SqlView, View.OnClickListener {
    private EditText id, name, sex, age;
    private Button add, query, del;
    private RecyclerView recy;
    private SqlAdapter adapter;

    private void findViews() {
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        sex = findViewById(R.id.sex);
        age = findViewById(R.id.age);
        add = findViewById(R.id.add);
        query = findViewById(R.id.query);
        del = findViewById(R.id.del);
        recy = findViewById(R.id.recy);
        adapter = new SqlAdapter(this);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(adapter);
        add.setOnClickListener(this);
        query.setOnClickListener(this);
        del.setOnClickListener(this);
    }

    @Override
    protected void initActtivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sqlite);
        findViews();
    }

    @Override
    protected SqlPresenter createPresenter() {
        return new SqlPresenter(SqliteActivity.this, this);
    }

    @Override
    public void showOneData(PersonBean personBean) {
        List<PersonBean> personBeans = new ArrayList<>();
        personBeans.add(personBean);
        adapter.setData(personBeans);
    }

    @Override
    public void showMultData(List<PersonBean> personBeans) {
        adapter.setData(personBeans);
    }

    @Override
    public void onClick(View v) {
        if (v == add) {
            if (Contants.isNumByKeyBorad(age)) {
                getPresenter().addData(Long.parseLong(id.getText().toString()), name.getText().toString(), sex.getText().toString(), Integer.parseInt(age.getText().toString()));
            } else {
                Toast.makeText(SqliteActivity.this, "输入格式有误！年龄输入只能键入数字！", Toast.LENGTH_SHORT).show();

            }
        } else if (v == query) {
            getPresenter().BindMultData();
        } else if (v == del) {
            getPresenter().delAllData();
            getPresenter().BindMultData();
        }
    }
}
