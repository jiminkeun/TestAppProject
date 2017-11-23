package mytest.syscore.daou.mytest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mytest.syscore.daou.mytest.R;

public class MemberMgmtMainActivity extends AppCompatActivity implements Button.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_mgmt_main);

        Button btnMemberAdd = (Button)findViewById(R.id.btnMemberAdd);
        btnMemberAdd.setOnClickListener(this);

        Button btnMemberList = (Button)findViewById(R.id.btnMemberList);
        btnMemberList.setOnClickListener(this);

        Button btnMemberDel = (Button)findViewById(R.id.btnMemberDel);
        btnMemberDel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnMemberAdd:
                intent = new Intent(this, MemberJoinFormActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMemberList:
                intent = new Intent(this, MemberListActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMemberDel:
                /*intent = new Intent(this, MemberDelActivity.class);
                startActivity(intent);*/
                break;
        }
    }
}
