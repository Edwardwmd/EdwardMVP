package com.wmd.mvp.edwardmvp.mvp.model;

import com.wmd.mvp.edwardmvp.R;
import com.wmd.mvp.edwardmvp.bean.GirlsClothsBean;
import com.wmd.mvp.edwardmvp.listener.LoadOnDataListemer;
import com.wmd.mvp.edwardmvp.utils.Contants;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017/11/20/12：25
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class IgModelImpl implements IgModel {
    @Override
    public void loadGirlClothesData(LoadOnDataListemer loadOnDataListener) {
        List<GirlsClothsBean> clothsBeans = new ArrayList<>();
        clothsBeans.add(new GirlsClothsBean(R.drawable.a1, Contants.getString(R.string.l1)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a2, Contants.getString(R.string.l2)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a3, Contants.getString(R.string.l3)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a4, Contants.getString(R.string.l4)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a5, Contants.getString(R.string.l5)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a6, Contants.getString(R.string.l6)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a7, Contants.getString(R.string.l7)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a8, Contants.getString(R.string.l8)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a9, Contants.getString(R.string.l9)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a10, Contants.getString(R.string.l10)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a11, Contants.getString(R.string.l11)));
        clothsBeans.add(new GirlsClothsBean(R.drawable.a12, Contants.getString(R.string.l12)));
        if (clothsBeans != null && clothsBeans.size() > 0) {
            loadOnDataListener.onComplete(clothsBeans);
        } else {
            loadOnDataListener.onError();
        }
    }
}
