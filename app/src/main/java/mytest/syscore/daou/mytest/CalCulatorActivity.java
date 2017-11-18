package mytest.syscore.daou.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by daou on 2017-11-18.
 */

public class CalCulatorActivity extends AppCompatActivity implements Button.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button addBtn = (Button) findViewById(R.id.addButton);
        addBtn.setOnClickListener(this);

        Button subBtn = (Button) findViewById(R.id.subButton);
        subBtn.setOnClickListener(this);

        Button multipleBtn = (Button) findViewById(R.id.mulButton);
        multipleBtn.setOnClickListener(this);

        Button divBtn = (Button) findViewById(R.id.divButton);
        divBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TextView resultView = (TextView) findViewById(R.id.resultCal);
        EditText number1 = (EditText) findViewById(R.id.number1);
        EditText number2 = (EditText) findViewById(R.id.number2);

        int number1Int = Integer.parseInt(number1.getText().toString());
        int number2Int = Integer.parseInt(number2.getText().toString());

        int result = 0;

        switch (v.getId()) {
            case R.id.addButton:
                result = number1Int + number2Int;
                break;
            case R.id.subButton:
                result = number1Int - number2Int;
                break;
            case R.id.mulButton:
                result = number1Int * number2Int;
                break;
            case R.id.divButton:
                result = number1Int / number2Int;
                break;
            default:
                break;
        }

        resultView.setText(Integer.toString(result));
    }
}
