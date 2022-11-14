package com.example.conyeu.SQLite;

import android.app.Application;

import java.io.File;

public class App extends Application {
    DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new DBHelper(this);
        dbHelper.createTable();
//        File file = new File(dbHelper.openDBOption().getPath());
//        dbHelper.copyDatabase(file);
    }
}
