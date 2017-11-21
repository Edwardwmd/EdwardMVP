package com.wmd.mvp.edwardmvp.listener;

import com.wmd.mvp.edwardmvp.bean.PersonBean;

/**
 * 时间：2017/11/21/15：12
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public  interface LoadOneDataListener {
    void onCompleteForOne(PersonBean personBean);

    void onError();
}
