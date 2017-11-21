package com.wmd.mvp.edwardmvp.mvp.presenter;

import android.os.Handler;

import com.wmd.mvp.edwardmvp.bean.GirlsClothsBean;
import com.wmd.mvp.edwardmvp.listener.LoadOnDataListemer;
import com.wmd.mvp.edwardmvp.mvp.view.IgView;
import com.wmd.mvp.edwardmvp.mvp.model.IgModel;
import com.wmd.mvp.edwardmvp.mvp.model.IgModelImpl;
import com.wmd.mvp.edwardmvp.mvp.presenter.base.BasePresenter;

import java.util.List;

/**
 * 时间：2017/11/20/13：05
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class IgPresenter<T> extends BasePresenter<T> {
    private Handler mH = new Handler();
    IgModel igModel = new IgModelImpl();
    IgView igView;

    public IgPresenter(IgView igView) {
        super();
        this.igView = igView;
    }

    public void bindData() {
        igView.showDialog();
        mH.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (igModel != null) {
                    igModel.loadGirlClothesData(new LoadOnDataListemer() {
                        @Override
                        public void onComplete(List<GirlsClothsBean> girlsClothsBeans) {
                            igView.showData(girlsClothsBeans);

                        }

                        @Override
                        public void onError() {
                            igView.showError("No Data");
                        }
                    });
                }
            }
        }, 1500);
    }
}


