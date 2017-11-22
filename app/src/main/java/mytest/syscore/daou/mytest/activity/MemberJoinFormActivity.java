package mytest.syscore.daou.mytest.activity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mytest.syscore.daou.mytest.R;

public class MemberJoinFormActivity extends AppCompatActivity implements Button.OnClickListener {

    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join_form);

        Button btnSave = (Button) findViewById(R.id.btnMemberInputSave);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        EditText etNo = (EditText) findViewById(R.id.editMemberNo);
        EditText etName = (EditText) findViewById(R.id.editMemberName);
        EditText etAge = (EditText) findViewById(R.id.editMemberAge);
        EditText etSex = (EditText) findViewById(R.id.editMemberSex);
        EditText etBirthday = (EditText) findViewById(R.id.editMemberBirthday);
        EditText etJob = (EditText) findViewById(R.id.editMemberJob);
        EditText etAddr = (EditText) findViewById(R.id.editMemberAddr);



        try {
            // Database 접속
            db = db_init();

            // 테이블 생성
            StringBuffer sqlCreateTbl = null;
            sqlCreateTbl.append(
                    "CREATE TABLE IF NOT EXIST MEMBER " +
                            "(NO INTEGER, NAME TEXT, AGE INTEGER, SEX TEXT, BIRTHDAY TEXT, JOB TEXT, ADDR TEXT)"
            );
            db_exec(sqlCreateTbl.toString());

            // 데이터 SAVE
            StringBuffer sqlInsertData = null;
            sqlInsertData.append(
                    "INSERT INTO MEMBER (" +
                            "NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADD" +
                            ") VALUES (" +
                            "" + Integer.parseInt(etNo.toString()) + "," +
                            "'" + etName.toString() + "'," +
                            "" + Integer.parseInt(etAge.toString()) + "," +
                            "'" + etSex.toString() + "'," +
                            "'" + etBirthday.toString() + "'," +
                            "'" + etJob.toString() + "'," +
                            "'" + etAddr.toString() + "'" +
                            ")"
            );
            db_exec(sqlInsertData.toString());

        }catch(SQLException e) {
            e.printStackTrace();
        }

        // 조회 페이지 연결
        intent = new Intent(this, MemberListActivity.class);
        startActivity(intent);
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
