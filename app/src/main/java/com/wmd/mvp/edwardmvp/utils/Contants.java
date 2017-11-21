package com.wmd.mvp.edwardmvp.utils;

import android.content.Context;
import android.widget.EditText;

import com.wmd.mvp.edwardmvp.EdwardMVPApplication;

import java.util.regex.Pattern;

/**
 * 时间：2017/11/18/13：26
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：获取图片，leble的工具
 * 声明：版权归作者所有
 */

public class Contants {
    public static Context getContext() {
        return EdwardMVPApplication.getApplication();
    }

    public static String getString(int resId) {
        return getContext().getString(resId);
    }

    public static boolean isNumByKeyBorad(EditText input) {
        Pattern p = Pattern.compile("[0-9]*");
        return p.matcher(input.getText().toString()).matches();

    }
}
