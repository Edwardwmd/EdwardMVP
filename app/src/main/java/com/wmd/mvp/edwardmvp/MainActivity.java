package com.wmd.mvp.edwardmvp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.wmd.mvp.edwardmvp.adapter.MVPAdapter;
import com.wmd.mvp.edwardmvp.bean.GirlsClothsBean;
import com.wmd.mvp.edwardmvp.mvp.BaseActivity;
import com.wmd.mvp.edwardmvp.mvp.view.IgView;
import com.wmd.mvp.edwardmvp.mvp.presenter.IgPresenter;

import java.util.List;

public class MainActivity extends BaseActivity<IgView, IgPresenter<IgView>> implements IgView {

    private RecyclerView recy;
    private MVPAdapter adapter;


    @Override
    protected void initActtivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        recy = findViewById(R.id.recy);
        adapter = new MVPAdapter(this);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(adapter);

        getPresenter().bindData();
    }

    @Override
    protected IgPresenter<IgView> createPresenter() {
        return new IgPresenter(this);
    }


    @Override
    public void showData(List<GirlsClothsBean> girlsClothsBeans) {
        adapter.setData(girlsClothsBeans);
    }

    @Override
    public void showDialog() {
        Toast.makeText(MainActivity.this, "努力加载中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String errorMsg) {
        Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
