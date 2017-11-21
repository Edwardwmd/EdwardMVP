package com.wmd.mvp.edwardmvp.mvp.model;

import android.content.Context;

import com.wmd.mvp.edwardmvp.bean.PersonBean;
import com.wmd.mvp.edwardmvp.listener.LoadMutlDataListener;
import com.wmd.mvp.edwardmvp.listener.LoadOneDataListener;
import com.wmd.mvp.edwardmvp.sql.GreenDaoOptions;

import java.util.List;

/**
 * 时间：2017/11/21/15：03
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class SqlModelImpl implements SqlModel {
    private Context mC;
    private final GreenDaoOptions greenDaoOptions;

    public SqlModelImpl(Context mC) {
        this.mC = mC;
        greenDaoOptions = new GreenDaoOptions(mC);
    }


    
    @Override
    public void insertOneData( PersonBean personBean) {
        greenDaoOptions.insertPerson(personBean);
        
    }

    @Override
    public void insertMultData( List<PersonBean> personBeans) {
        greenDaoOptions.insertMultPerson(personBeans);
    }

    @Override
    public void queryDataByOne( LoadOneDataListener loadGreenDaoListener) {
        loadGreenDaoListener.onCompleteForOne(greenDaoOptions.queryById(1));
    }

    @Override
    public void queryDataByMult( LoadMutlDataListener loadMutlDataListener) {
        loadMutlDataListener.onCompleteForMult(greenDaoOptions.queryAlPerson());
    }

    @Override
    public void delAllData() {
        greenDaoOptions.delAllPerson();
    }


}
