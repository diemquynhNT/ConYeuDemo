package com.example.conyeu.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.CaseMap;

import com.example.conyeu.object.BMI;
import com.example.conyeu.object.Baby;
import com.example.conyeu.object.Calendar;
import com.example.conyeu.object.Camnang;
import com.example.conyeu.object.Diary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper {
    Context context;
    String DB_NAME="CONYEU.db";
    String DB_CN="CamnangDB.db";
    public DBHelper(Context context) {
        this.context = context;
    }

    public SQLiteDatabase openDBOption(){
        return context.openOrCreateDatabase(DB_NAME,Context.MODE_PRIVATE, null);
    }


    public SQLiteDatabase openDBOption2(){
        return context.openOrCreateDatabase(DB_CN,Context.MODE_PRIVATE, null);
    }
    public void createTable(){
//        SQLiteDatabase db = openDBOption();
//        String query = "CREATE TABLE IF NOT EXISTS Camnang(" +
//                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                " titlecn TEXT," +
//                " contentcn TEXT," +
//                " detailcn TEXT )";
//        db.execSQL(query);
//        String cnInsert="INSERT INTO Camnang(titlecn,contentcn,detailcn) VALUES ('Gen','Di truyền và gen','Cấu trúc di truyền')";
//        db.execSQL(cnInsert);
//        String cnInsert1="INSERT INTO Camnang(titlecn,contentcn,detailcn) VALUES ('money','toww','five')";
//
//        db.execSQL(cnInsert1);

        SQLiteDatabase babydb = openDBOption();
        String baby = "CREATE TABLE IF NOT EXISTS Baby(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " namebaby TEXT," +
                " nickname TEXT," +
                " sexbaby TEXT," +
                " periodbaby TEXT," +
                " birthday TEXT )" ;

        babydb.execSQL(baby);

        SQLiteDatabase diarydb = openDBOption();
        String diary = "CREATE TABLE IF NOT EXISTS Diary(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " title TEXT," +
                " contentdiary TEXT," +
                " datediary TEXT )" ;

        diarydb.execSQL(diary);

        SQLiteDatabase calendardb = openDBOption();
        String calendar = "CREATE TABLE IF NOT EXISTS Calendar(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " title TEXT," +
                " address TEXT," +
                " note TEXT," +
                " time TEXT," +
                " date TEXT )" ;

        calendardb.execSQL(calendar);

        SQLiteDatabase bmidb = openDBOption();
        String bmi = "CREATE TABLE IF NOT EXISTS BMI(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " height INTEGER," +
                " weight INTEGER," +
                " bmi INTEGER," +
                " datebmi TEXT )" ;

        bmidb.execSQL(bmi);


    }

//    //Cach 2
//    public void copyDatabase(File dbFile)  {
//
//        try {
//            InputStream is = context.getAssets().open("CamnangDB.db");
//            OutputStream os = new FileOutputStream(dbFile);
//
//            byte[] buffer = new byte[1024];
//            while (is.read(buffer) > 0) {
//                os.write(buffer);
//            }
//
//            os.flush();
//            os.close();
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    void closeDB(SQLiteDatabase db){
        db.close();
    }

    //lay du lieu camnnag
    public ArrayList<Camnang> getCamnang_con()
    {
        ArrayList<Camnang> dsCamnang = new ArrayList<Camnang>();
        SQLiteDatabase db = openDBOption2();
        String sql = "SELECT * FROM Camnang_contbt ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Camnang cn=new Camnang();
            cn.setId(cursor.getInt(0)) ;
            cn.setTitlecn(cursor.getString(1));
            cn.setContentcn(cursor.getString(2));
            cn.setDetailcn(cursor.getString(3));
            cn.setImgcn(cursor.getBlob(4));
            dsCamnang.add(cn);

            cursor.moveToNext();
        }

        return dsCamnang;
    }

    public ArrayList<Camnang> getCamnang_me()
    {
        ArrayList<Camnang> dsCamnang = new ArrayList<Camnang>();
        SQLiteDatabase db = openDBOption2();
        String sql = "SELECT * FROM Camnang_metbt ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Camnang cn=new Camnang();
            cn.setId(cursor.getInt(0)) ;
            cn.setTitlecn(cursor.getString(1));
            cn.setContentcn(cursor.getString(2));
            cn.setDetailcn(cursor.getString(3));
            cn.setImgcn(cursor.getBlob(4));
            dsCamnang.add(cn);

            cursor.moveToNext();
        }

        return dsCamnang;
    }
//    public void insertCamnang(Camnang camnang){
//        SQLiteDatabase db = openDBOption();
//        String cnInsert="INSERT INTO Camnang(titlecn,contentcn,detailcn) VALUES ('Gen','Di truyền và gen','Cấu trúc di truyền')";
//        db.execSQL(cnInsert);
//        String cnInsert1="INSERT INTO Camnang(titlecn,contentcn,detailcn) VALUES ('money','toww','five')";
//        db.execSQL(cnInsert1);
//
//    }
    public void deleteCamnang(int id){
        SQLiteDatabase db = openDBOption();
        db.delete("Baby","id = "+id,null);
        closeDB(db);
    }

    public void insertBaby(Baby baby){

        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("namebaby", baby.getNamebaby());
        contentValues.put("nickname",baby.getNickname());
        contentValues.put("sexbaby",baby.getSexbaby());
        contentValues.put("periodbaby",baby.getPeriodbaby());
        contentValues.put("birthday",baby.getBirthday());

        db.insert("Baby",null,contentValues);
        closeDB(db);
    }

    public void updateBaby(Baby baby){
        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("namebaby", baby.getNamebaby());
        contentValues.put("nickname",baby.getNickname());
        contentValues.put("sexbaby",baby.getSexbaby());
        contentValues.put("periodbaby",baby.getPeriodbaby());
        contentValues.put("birthday",baby.getBirthday());

        db.update("Baby",contentValues,"id = "+baby.getId(),null);
        closeDB(db);

    }
    public void deleteBaby(int id){
        SQLiteDatabase db = openDBOption();
        db.delete("Baby","id = "+id,null);
        closeDB(db);
    }

    //lay du lieu camnnag
    public ArrayList<Baby> getBaby()
    {
        ArrayList<Baby> dsBaby = new ArrayList<Baby>();
        SQLiteDatabase db = openDBOption();
        String sql = "SELECT * FROM Baby ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            int id=cursor.getInt(0) ;
            String name=cursor.getString(1);
            String nickname=cursor.getString(2);
            String sexbb=cursor.getString(3);
            String period=cursor.getString(4);
            String birthday=cursor.getString(5);
            Baby bb=new Baby(id,name,nickname,sexbb,period,birthday);
            dsBaby.add(bb);

            cursor.moveToNext();
        }

        return dsBaby;
    }

    public void insertDiary(Diary diary){

        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", diary.getTitle());
        contentValues.put("contentdiary",diary.getContentdiary());
        contentValues.put("datediary",diary.getDatediary());

        db.insert("Diary",null,contentValues);
        closeDB(db);
    }

    public void updateDiary(Diary diary){
        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", diary.title);
        contentValues.put("contentdiary",diary.contentdiary);
        contentValues.put("datediary",diary.contentdiary);
        int a=diary.getId();
        db.update("Diary",contentValues,"id = "+diary.id,null);
        closeDB(db);

    }
    public void deleteDiary(int id){
        SQLiteDatabase db = openDBOption();
        db.delete("Diary","id = "+id,null);
        closeDB(db);
    }

    //lay du lieu diary
    public ArrayList<Diary> getDiary()
    {
        ArrayList<Diary> dsDiary = new ArrayList<Diary>();
        SQLiteDatabase db = openDBOption();
        String sql = "SELECT * FROM Diary ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            int id=cursor.getInt(0) ;
            String title=cursor.getString(1);
            String content=cursor.getString(2);
            String date=cursor.getString(3);
            Diary diary=new Diary(id,title,content,date);
            dsDiary.add(diary);

            cursor.moveToNext();
        }

        return dsDiary;
    }


    //CALENDAR
    public void insertCalendar(Calendar calendar){

        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", calendar.title);
        contentValues.put("address",calendar.address);
        contentValues.put("note",calendar.note);
        contentValues.put("time",calendar.time);
        contentValues.put("date",calendar.date);

        db.insert("Calendar",null,contentValues);
        closeDB(db);
    }

    public void updateCalendar(Calendar calendar){
        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", calendar.title);
        contentValues.put("address",calendar.address);
        contentValues.put("note",calendar.note);
        contentValues.put("time",calendar.time);
        contentValues.put("date",calendar.date);

        db.update("Calendar",contentValues,"id = "+calendar.id,null);
        closeDB(db);

    }
    public void deleteCalendar(int id){
        SQLiteDatabase db = openDBOption();
        db.delete("Calendar","id = "+id,null);
        closeDB(db);
    }

    //lay du lieu calendar
    public ArrayList<Calendar> getCalendar()
    {
        ArrayList<Calendar> dsCalendar = new ArrayList<Calendar>();
        SQLiteDatabase db = openDBOption();
        String sql = "SELECT * FROM Calendar ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            int id=cursor.getInt(0) ;
            String title=cursor.getString(1);
            String address=cursor.getString(2);
            String note=cursor.getString(3);
            String time=cursor.getString(4);
            String date=cursor.getString(5);
            Calendar c=new Calendar(id,title,address,note,time,date);
            dsCalendar.add(c);

            cursor.moveToNext();
        }

        return dsCalendar;
    }

    //BMI
    public void insertBMI(BMI bmi){

        SQLiteDatabase db = openDBOption();
        ContentValues contentValues = new ContentValues();
        contentValues.put("height",bmi.getHeight() );
        contentValues.put("weight",bmi.getWeight());
        contentValues.put("bmi",bmi.getBmi());
        contentValues.put("datebim",bmi.getDatebmi());

        db.insert("BMI",null,contentValues);
        closeDB(db);
    }

//    public void updateBaby(Baby baby){
//        SQLiteDatabase db = openDBOption();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("namebaby", baby.getNamebaby());
//        contentValues.put("nickname",baby.getNickname());
//        contentValues.put("sexbaby",baby.getSexbaby());
//        contentValues.put("periodbaby",baby.getPeriodbaby());
//        contentValues.put("birthday",baby.getBirthday());
//
//        db.update("Baby",contentValues,"id = "+baby.getId(),null);
//        closeDB(db);
//
//    }
    public void deleteBMI(int id){
        SQLiteDatabase db = openDBOption();
        db.delete("BMI","id = "+id,null);
        closeDB(db);
    }

    //lay du lieu camnnag
    public ArrayList<BMI> getBMI()
    {
        ArrayList<BMI> dsBMI = new ArrayList<BMI>();
        SQLiteDatabase db = openDBOption();
        String sql = "SELECT * FROM BMI ";
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            int id=cursor.getInt(0) ;
            int height=cursor.getInt(1);
            int weight=cursor.getInt(2);
            int bmi=cursor.getInt(3);
            String datebmi=cursor.getString(4);

            BMI bmis=new BMI(id,height,weight,bmi,datebmi);
            dsBMI.add(bmis);

            cursor.moveToNext();
        }

        return dsBMI;
    }


}
