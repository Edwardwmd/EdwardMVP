package com.wmd.mvp.edwardmvp.mvp.view;

import com.wmd.mvp.edwardmvp.bean.GirlsClothsBean;

import java.util.List;

/**
 * 时间：2017/11/20/12：29
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public interface IgView {
    void showData(List<GirlsClothsBean>girlsClothsBeans);
    void showDialog();
    void showError(String errorMsg);
}
