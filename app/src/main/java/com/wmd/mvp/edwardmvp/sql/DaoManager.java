package com.wmd.mvp.edwardmvp.sql;

import android.content.Context;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * 时间：2017/11/21/14：32
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：数据库操作管理类
 * 声明：版权归作者所有
 */

public class DaoManager {
    private static final String TAG = DaoManager.class.getSimpleName();
    private static final String DB_NAME = "persondao.db";
    private Context mC;


    private volatile static DaoManager manager;  //多线程中要被共享的使用volatile关键字修饰
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    /**
     * 单例模式操作数据库
     *
     * @return
     */
    public static DaoManager getInstance() {
        if (manager == null) {
            manager = new DaoManager();
        }
        return manager;
    }

    public void init(Context context) {
        this.mC = context;
    }

    /**
     * 判断是否有存在数据库，如果没有则创建
     *
     * @return
     */
    public DaoMaster getDaoMaster() {
        if (mDaoMaster == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mC, DB_NAME, null);
            mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return mDaoMaster;
    }

    /**
     * 完成对数据库的添加、删除、修改、查询操作，仅仅是一个接口
     *
     * @return
     */
    public DaoSession getDaoSession() {
        if (mDaoSession == null) {
            if (mDaoMaster == null) {
                mDaoMaster = getDaoMaster();
            }
            mDaoSession = mDaoMaster.newSession();
        }
        return mDaoSession;
    }


    /**
     * 打开输出日志，默认关闭
     */
    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }


    /**
     * 关闭所有的操作，数据库开启后，使用完毕要关闭
     */
    public void closeConnection() {
        closeHelper();
        closeDaoSession();
        Log.e(TAG, "数据库关闭操作--------->");
    }


    public void closeDaoSession() {
        if (mDaoSession != null) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    public void closeHelper() {
        if (mDevOpenHelper != null) {
            mDevOpenHelper.close();
            mDevOpenHelper = null;
        }
    }

}
