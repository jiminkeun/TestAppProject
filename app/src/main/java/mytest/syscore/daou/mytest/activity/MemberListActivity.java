package mytest.syscore.daou.mytest.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import mytest.syscore.daou.mytest.R;
import mytest.syscore.daou.mytest.adapter.MemberInfoAdapter;
import mytest.syscore.daou.mytest.item.MemberInfo;

public class MemberListActivity extends AppCompatActivity implements Button.OnClickListener {

    SQLiteDatabase db = null;
    private ListView memberListView = null;
    private MemberInfoAdapter memAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        ArrayList<MemberInfo> memberList = new ArrayList<MemberInfo>();
        getMemberDbData(memberList);

        memAdapter = new MemberInfoAdapter(this, R.id.list, memberList);
        memberListView = (ListView) this.findViewById(R.id.listMember);


        getMemberDbData


        memAdapter = new MemberInfoAdapter();
        memberListView = (ListView) findViewById(R.id.listMember) ;
        memberListView.setAdapter(memAdapter);

        db = db_init();

        // 리스트 조회
        StringBuffer sqlSel = null;
        sqlSel.append(
          "SELECT NO, NAME, AGE, SEX, BIRTHDAY, JOB, ADDR " +
          "FROM MEMBER"
        );
        Cursor rows = db.rawQuery(sqlSel.toString(), null);

        Button btnMemberInputSaveByList = (Button) findViewById(R.id.btnMemberInputSaveByList);
        btnMemberInputSaveByList.setOnClickListener(this);

        // 초기화
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

            // 아답터를 이용하여 view 추가
            memAdapter.addItem(rNo, rName, rAge, rSex, rBirthday, rJob, rAddr);

        }

        memberListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MemberInfo info = (MemberInfo) parent.getItemAtPosition(position);

                int no = info.getNo();
                String name = info.getName();
                int age = info.getAge();
                String sex = info.getSex();
                String birthday = info.getBirthday();
                String job = info.getJob();
                String addr = info.getAddr();
            }
        });
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        // 저장버튼
        if(v.getId() == R.id.btnMemberInputSaveByList) {
            intent = new Intent(this, MemberListActivity.class);
            startActivity(intent);
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



