package com.wmd.mvp.edwardmvp.sql;

import android.content.Context;

import com.wmd.mvp.edwardmvp.bean.PersonBean;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：2017/11/21/14：32
 * 作者：MingDe_Wu
 * 网站：https://github.com/Edwardwmd
 * 作用：数据库增删改查操作类
 * 声明：版权归作者所有
 */

public class GreenDaoOptions {
    private static String TAG = GreenDaoOptions.class.getSimpleName();

    private DaoManager manager;

    /**
     * 初始化数据表操作类
     *
     * @param context
     */
    public GreenDaoOptions(Context context) {
        manager = DaoManager.getInstance();
        manager.init(context);
    }

    /**
     * 插入单条数据
     *
     * @param personBean
     * @return
     */


    public boolean insertPerson(PersonBean personBean) {
        boolean flag = false;
        flag = manager.getDaoSession().insert(personBean) == -1 ? false : true;
        manager.closeConnection();
        return flag;
    }

    /**
     * 插入多条数据，在子线程操作--
     *
     * @param mPbList
     * @return
     */
    public boolean insertMultPerson(final List<PersonBean> mPbList) {
        boolean flag = false;

        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    //遍历插入数据
                    for (PersonBean personBean : mPbList) {
                        manager.getDaoSession().insertOrReplace(personBean);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.closeConnection();
        return flag;
    }

    /**
     * 修改一条数据
     *
     * @param personBean
     * @return
     */
    public boolean updataPerson(PersonBean personBean) {
        boolean flag = false;
        try {
            manager.getDaoSession().update(personBean);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.closeConnection();
        return flag;
    }

    /**
     * 更新（修改多条数据），子线程操作
     *
     * @param mPbList
     * @return
     */
    public boolean updataMultPerson(final List<PersonBean> mPbList) {
        boolean flag = false;
        try {
            manager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (PersonBean personBean : mPbList) {
                        manager.getDaoSession().update(personBean);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.closeConnection();
        return flag;
    }

    /**
     * 删除单条数据
     *
     * @param personBean
     * @return
     */
    public boolean delPerson(PersonBean personBean) {
        boolean flag = false;
        try {
            manager.getDaoSession().delete(personBean);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.closeConnection();
        return flag;
    }


    /**
     * 删除所有数据
     *
     * @return
     */
    public boolean delAllPerson() {
        boolean flag = false;
        try {
            manager.getDaoSession().deleteAll(PersonBean.class);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        manager.closeConnection();
        return flag;
    }

    /**
     * 查询所有记录
     *
     * @return
     */
    public List<PersonBean> queryAlPerson() {
        final List<PersonBean> personBeanList = manager.getDaoSession().loadAll(PersonBean.class);
        manager.closeConnection();
        return personBeanList;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public PersonBean queryById(long id) {
        final PersonBean personBean = manager.getDaoSession().load(PersonBean.class, id);
        manager.closeConnection();
        return personBean;
    }

    /**
     * 根据姓名查询
     *
     * @param name
     * @return
     */
    public List<PersonBean> queryByName(String name) {
        List<PersonBean> mPbList = new ArrayList<>();
        PersonBean personBean = manager.getDaoSession().load(PersonBean.class, name);
        mPbList.add(personBean);
        manager.closeConnection();
        return mPbList;
    }

    /**
     * 根据年龄查询
     *
     * @param age
     * @return
     */
    public List<PersonBean> queryByAge(String age) {
        List<PersonBean> mPbList = new ArrayList<>();
        PersonBean personBean = manager.getDaoSession().load(PersonBean.class, age);
        mPbList.add(personBean);
        manager.closeConnection();
        return mPbList;
    }

    /**
     * 使用queryBuilder进行查询
     *
     * @return
     */
    public List<PersonBean> queryMeiziByQueryBuilder(long id) {
        QueryBuilder<PersonBean> queryBuilder = manager.getDaoSession().queryBuilder(PersonBean.class);
        final List<PersonBean> personBeanList = queryBuilder.where(PersonBeanDao.Properties.Id.eq(id)).list();
        manager.closeConnection();
        return personBeanList;
    }


}
