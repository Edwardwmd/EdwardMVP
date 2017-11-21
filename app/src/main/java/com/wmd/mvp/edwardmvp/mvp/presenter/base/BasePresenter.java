package com.wmd.mvp.edwardmvp.mvp.presenter.base;

import java.lang.ref.WeakReference;

/**
 * 时间：2017/11/20/14：17
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：Presenter的基类，主要是实现在presenter绑定和解绑过程中防止内存泄漏
 * 声明：版权归作者所有
 */

public abstract class BasePresenter<T> {

    //使用弱引用绑定和解绑View
    protected WeakReference<T> mWeakR;

    /**
     * 绑定View
     *
     * @param view
     */
    public void attachView(T view) {
        mWeakR = new WeakReference<T>(view);

    }

    /**
     * 解除绑定View
     */
    public void detachView() {
        if (mWeakR != null) {
            mWeakR.clear();
            mWeakR = null;
        }
    }

    protected T getView() {
        return mWeakR.get();
    }
}
