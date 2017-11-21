package com.wmd.mvp.edwardmvp.sql;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.wmd.mvp.edwardmvp.bean.PersonBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PERSON_BEAN".
*/
public class PersonBeanDao extends AbstractDao<PersonBean, Long> {

    public static final String TABLENAME = "PERSON_BEAN";

    /**
     * Properties of entity PersonBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Sex = new Property(2, String.class, "sex", false, "SEX");
        public final static Property Age = new Property(3, int.class, "age", false, "AGE");
    }


    public PersonBeanDao(DaoConfig config) {
        super(config);
    }
    
    public PersonBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PERSON_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"SEX\" TEXT," + // 2: sex
                "\"AGE\" INTEGER NOT NULL );"); // 3: age
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PERSON_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PersonBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(3, sex);
        }
        stmt.bindLong(4, entity.getAge());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PersonBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(3, sex);
        }
        stmt.bindLong(4, entity.getAge());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public PersonBean readEntity(Cursor cursor, int offset) {
        PersonBean entity = new PersonBean( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // sex
            cursor.getInt(offset + 3) // age
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PersonBean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSex(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAge(cursor.getInt(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PersonBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PersonBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PersonBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}