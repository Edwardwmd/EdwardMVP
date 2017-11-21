package com.wmd.mvp.edwardmvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wmd.mvp.edwardmvp.mvp.presenter.base.BasePresenter;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * 时间：2017/11/19/21：11
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends SupportActivity {
    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        presenter = createPresenter();
        //关联View
        presenter.attachView((V) this);
        //初始化Activity
        initActtivity(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解除绑定View
        presenter.detachView();
    }

    /**
     * 获取Presenter
     *
     * @return
     */
    protected T getPresenter() {
        return presenter;
    }

    //Activity
    protected abstract void initActtivity(Bundle savedInstanceState);

    // 实例化presenter
    protected abstract T createPresenter();
}
