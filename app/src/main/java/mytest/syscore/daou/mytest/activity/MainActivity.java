package mytest.syscore.daou.mytest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mytest.syscore.daou.mytest.R;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculatorButton = (Button) findViewById(R.id.goCalculator);
        calculatorButton.setOnClickListener(this);

        Button calculatorButton2 = (Button) findViewById(R.id.goCalculator2);
        calculatorButton2.setOnClickListener(this);

        Button memberListButton = (Button) findViewById(R.id.goMemberList);
        memberListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent intent = null;
        switch (view.getId()){
            case R.id.goCalculator:
                intent = new Intent(this, CalCulatorActivity.class);
                startActivity(intent);
                break;
            case R.id.goCalculator2:
                intent = new Intent(this, CalculatorNumActivity.class);
                startActivity(intent);
                break;
            case R.id.goMemberList:
                intent = new Intent(this, MemberListActivity.class);
                startActivity(intent);
                break;
        }
    }


}
