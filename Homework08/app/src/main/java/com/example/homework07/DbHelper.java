package com.example.homework07;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//数据库的创建
public class DbHelper extends SQLiteOpenHelper {
    private Context context;

    //参数1：上下文
    //参数2：数据库名称
    //参数3：游标工厂，null为默认
    //参数4：数据库版本号
    public DbHelper(Context context) {
        super(context, "sqlite.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT, age INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据库版本号升级时，这里做一些数据库升级的操作
    }
}
