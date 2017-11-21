package com.wmd.mvp.edwardmvp.listener;

import com.wmd.mvp.edwardmvp.bean.GirlsClothsBean;

import java.util.List;

/**
 * 时间：2017/11/19/21：00
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public interface LoadOnDataListemer {
    void onComplete(List<GirlsClothsBean> girlsClothsBeans);

    void onError();
}
