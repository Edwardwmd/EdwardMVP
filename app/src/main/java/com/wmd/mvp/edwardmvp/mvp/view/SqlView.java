package com.wmd.mvp.edwardmvp.mvp.view;

import com.wmd.mvp.edwardmvp.bean.PersonBean;

import java.util.List;

/**
 * 时间：2017/11/21/14：59
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public interface SqlView {

    void showOneData(PersonBean personBean);

    void showMultData(List<PersonBean> personBeans);



}
