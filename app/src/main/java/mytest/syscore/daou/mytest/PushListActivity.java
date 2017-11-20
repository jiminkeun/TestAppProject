package mytest.syscore.daou.mytest;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PushListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_list);

        SQLiteDatabase sqliteDB = null;

        try {
            sqliteDB = SQLiteDatabase.openOrCreateDatabase("mySample.db", null);

            String sqlCreateTbl = "CREATE TABLE IF NOT EXIST MEMBER (NO INTEGER, NAME TEXT, AGE INTEGER, SEX TEXT, BIRTHDAY TEXT, JOB TEXT, ADDR TEXT)";
            sqliteDB.execSQL(sqlCreateTbl);

            String sqlInsert = "INSERT INTO MEMBER (NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADDR) VALUES(1, '지민근', 34, 'M', '19861021', 'DEVELOPER', '경기도 부천시')";
            sqliteDB.execSQL(sqlInsert);

            Cursor cursor = sqliteDB.rawQuery("SELECT NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADDR FROM MEMBER", null);

            while (cursor.moveToNext()) {
                int dataMemberNo = cursor.getInt(0);
                String dataMemberName = cursor.getString(1);
                int dataMemberAge = cursor.getInt(2);
                String dataMemberSex = cursor.getString(3);
                String dataMemberBirthday = cursor.getString(4);
                String dataMemberJob = cursor.getString(5);
                String dataMemberAddr = cursor.getString(6);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
