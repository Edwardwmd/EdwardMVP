package com.wmd.mvp.edwardmvp;

import android.app.Application;
import android.content.Context;

/**
 * 时间：2017/11/18/15：06
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：
 * 声明：版权归作者所有
 */

public class EdwardMVPApplication extends Application {
    private static Context mC;

    @Override
    public void onCreate() {
        super.onCreate();
        mC = this.getApplicationContext();
    }

    public static Context getApplication() {
        return mC;
    }
}
