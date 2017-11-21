package mytest.syscore.daou.mytest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MemberListActivity extends AppCompatActivity {

    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        db = db_init();

        // 리스트 조회
        StringBuffer sqlSel = null;
        sqlSel.append(
          "SELECT NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADDR " +
          "FROM MEMBER"
        );
        Cursor rows = db.rawQuery(sqlSel.toString(), null);

        int rNo = 0;
        String rName = "";
        int rAge = 0;
        String rSex = "";
        String rBirthday = "";
        String rJob = "";
        String rAddr = "";

        while (rows.moveToNext()) {
            rNo = rows.getInt(0);
            rName = rows.getString(1);
            rAge = rows.getInt(2);
            rSex = rows.getString(3);
            rBirthday = rows.getString(4);
            rJob = rows.getString(5);
            rAddr = rows.getString(6);


        }
    }

    // DB 초기화
    private SQLiteDatabase db_init() {
        SQLiteDatabase dbConnect = SQLiteDatabase.openOrCreateDatabase("myTest.db", null);
        return dbConnect;
    }

    // DB 실행
    private void db_exec(String sql) {
        db.execSQL(sql);
    }
}



