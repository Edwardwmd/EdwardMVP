package com.wmd.mvp.edwardmvp.mvp.presenter;

import android.content.Context;
import android.os.Handler;

import com.wmd.mvp.edwardmvp.bean.PersonBean;
import com.wmd.mvp.edwardmvp.listener.LoadMutlDataListener;
import com.wmd.mvp.edwardmvp.listener.LoadOneDataListener;
import com.wmd.mvp.edwardmvp.mvp.model.SqlModel;
import com.wmd.mvp.edwardmvp.mvp.model.SqlModelImpl;
import com.wmd.mvp.edwardmvp.mvp.presenter.base.BasePresenter;
import com.wmd.mvp.edwardmvp.mvp.view.SqlView;

import java.util.List;

/**
 * 时间：2017/11/21/15：01
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class SqlPresenter<T> extends BasePresenter<T> {
    private static String TAG = SqlPresenter.class.getSimpleName();
    private Handler mH = new Handler();
    SqlModel sqlModel;
    SqlView sqlView;
    Context mC;

    public SqlPresenter(Context context, SqlView sqlView) {
        this.mC = context;
        this.sqlView = sqlView;
        sqlModel = new SqlModelImpl(mC);
    }


    /**
     * 查询单个数据
     */
    public void bindOneData() {
//        sqlView.showDialog();
        mH.post(new Runnable() {
            @Override
            public void run() {
                if (sqlModel != null) {
                    sqlModel.queryDataByOne(new LoadOneDataListener() {
                        @Override
                        public void onCompleteForOne(PersonBean personBean) {
                            sqlView.showOneData(personBean);
                        }

                        @Override
                        public void onError() {

                        }
                    });
                }
            }
        });
    }

    /**
     * 查询多个数据
     */
    public void BindMultData() {
        mH.post(new Runnable() {
            @Override
            public void run() {
                if (sqlModel != null) {
                    sqlModel.queryDataByMult(new LoadMutlDataListener() {


                        @Override
                        public void onCompleteForMult(List<PersonBean> personBeans) {
                            sqlView.showMultData(personBeans);
                        }

                        @Override
                        public void onError() {

                        }
                    });
                }
            }
        });
    }

    public void addData(long id, String name, String sex, int age) {
        if (sqlModel != null) {
            PersonBean personBean = new PersonBean(id, name, sex, age);
            sqlModel.insertOneData(personBean);
        }
    }

    public void delAllData() {
        if (sqlModel != null) {
            sqlModel.delAllData();

        }

    }

    @Override
    public void detachView() {
        super.detachView();
        mH.removeCallbacksAndMessages(null);
    }
}
