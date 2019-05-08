package com.example.testgreendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import ccom.example.testgreendao.greendao.DaoMaster;
import ccom.example.testgreendao.greendao.DaoSession;

public class MyApplication extends Application {

    private static DaoSession daoSession;
    public static DaoSession getDaoSession() {
        return daoSession;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
}
