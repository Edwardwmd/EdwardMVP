package com.wmd.mvp.edwardmvp.mvp.model;

import com.wmd.mvp.edwardmvp.bean.PersonBean;
import com.wmd.mvp.edwardmvp.listener.LoadMutlDataListener;
import com.wmd.mvp.edwardmvp.listener.LoadOneDataListener;

import java.util.List;

/**
 * 时间：2017/11/21/14：14
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public interface SqlModel {

    void insertOneData( PersonBean personBean);

    void insertMultData( List<PersonBean> personBeans);

    void queryDataByOne( LoadOneDataListener loadGreenDaoListener);

    void queryDataByMult( LoadMutlDataListener loadMutlDataListener);

    void delAllData();


}
