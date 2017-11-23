package mytest.syscore.daou.mytest.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mytest.syscore.daou.mytest.R;
import mytest.syscore.daou.mytest.common.DBManager;
import mytest.syscore.daou.mytest.item.MemberInfo;
import mytest.syscore.daou.mytest.sqlmap.MemberDBSqlData;

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

        if(memberInsert() != 1) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();       // 닫기
                }
            });
            alert.setMessage("회원등록이 실패하였습니다.");
            alert.show();
            return;
        }else {
            // 조회 페이지 연결
            intent = new Intent(this, MemberListActivity.class);
            startActivity(intent);
        }
    }

    // 회원 등록 처리
    private int memberInsert() {

        int result = 0;

        EditText etNo = (EditText) findViewById(R.id.editMemberNo);
        EditText etName = (EditText) findViewById(R.id.editMemberName);
        EditText etAge = (EditText) findViewById(R.id.editMemberAge);
        EditText etSex = (EditText) findViewById(R.id.editMemberSex);
        EditText etBirthday = (EditText) findViewById(R.id.editMemberBirthday);
        EditText etJob = (EditText) findViewById(R.id.editMemberJob);
        EditText etAddr = (EditText) findViewById(R.id.editMemberAddr);

        MemberInfo infoData = new MemberInfo(Integer.parseInt(etNo.toString()), etName.toString(), Integer.parseInt(etAge.toString()), etSex.toString(), etBirthday.toString(), etJob.toString(), etAddr.toString());

        DBManager dbMng = new DBManager(this);
        dbMng.dbOpen();
        dbMng.insertData(MemberDBSqlData.SQL_DB_INSERT_DATA, infoData);
        dbMng.dbClose();

        return result;
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
