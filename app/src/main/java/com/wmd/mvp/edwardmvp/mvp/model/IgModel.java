package com.wmd.mvp.edwardmvp.mvp.model;

import com.wmd.mvp.edwardmvp.listener.LoadOnDataListemer;

/**
 * 时间：2017/11/20/12：20
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public interface IgModel {
    /**
     * 加载数据的监听
     *
     * @param loadOnDataListener
     */
    void loadGirlClothesData(LoadOnDataListemer loadOnDataListener);
}
