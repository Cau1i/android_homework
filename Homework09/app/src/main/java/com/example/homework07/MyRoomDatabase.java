package com.example.homework07;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Database(entities = {User.class}, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {
    private static MyRoomDatabase instance;

    public abstract UserDao userDao();

    static MyRoomDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyRoomDatabase.class, "room")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
