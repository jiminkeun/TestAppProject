package mytest.syscore.daou.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by daou on 2017-11-18.
 */

public class CalculatorNumActivity extends AppCompatActivity implements Button.OnClickListener {

    String nowCalc = "";        // 현재 연산자
    String nowResult = "";      // 현재 계산결과
    String nowType = "";        // C: 기호(= 은 다음에 숫자가 더해져야하므로 숫자로 분류됨), N: 숫자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_number);

        Button num1 = (Button) findViewById(R.id.n1);
        num1.setOnClickListener(this);

        Button num2 = (Button) findViewById(R.id.n2);
        num2.setOnClickListener(this);

        Button num3 = (Button) findViewById(R.id.n3);
        num3.setOnClickListener(this);

        Button num4 = (Button) findViewById(R.id.n4);
        num4.setOnClickListener(this);

        Button num5 = (Button) findViewById(R.id.n5);
        num5.setOnClickListener(this);

        Button num6 = (Button) findViewById(R.id.n6);
        num6.setOnClickListener(this);

        Button num7 = (Button) findViewById(R.id.n7);
        num7.setOnClickListener(this);

        Button num8 = (Button) findViewById(R.id.n8);
        num8.setOnClickListener(this);

        Button num9 = (Button) findViewById(R.id.n9);
        num9.setOnClickListener(this);

        Button num0 = (Button) findViewById(R.id.n0);
        num0.setOnClickListener(this);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        Button btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);

        Button btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);

        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);

        Button btnEqual = (Button) findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);

        Button btnCancel = (Button) findViewById(R.id.btnCancle);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText resultText = null;

        switch (v.getId()) {
            case R.id.btnAdd:
            case R.id.btnSub:
            case R.id.btnMul:
            case R.id.btnDiv:
                resultText = (EditText) findViewById(R.id.textCalcResult);
                // 기존 결과 텍스트 비어있지 않으면 처리
                if(!resultText.getText().toString().isEmpty()) {
                    // 기존 수식이 존재하면 결과 보여주기
                    if (!nowCalc.isEmpty()) {
                        resultText.setText(nowResult);
                    }
                    nowCalc = v.getTag().toString();
                    nowType = "C";
                }
                //Toast.makeText(this, "현재 nowType:"+nowType, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnEqual:
                resultText = (EditText) findViewById(R.id.textCalcResult);
                //Toast.makeText(this, "현재 nowResult:"+nowResult, Toast.LENGTH_SHORT).show();
                if(!nowResult.isEmpty()) {
                    resultText.setText(nowResult.toString());
                    nowType = "N";
                }
                break;
            case R.id.btnCancle:
                resultText = (EditText) findViewById(R.id.textCalcResult);
                nowCalc = "";
                nowResult = "";
                nowType = "";
                resultText.setText("0");
                break;
            default:        // 숫자일때 append, 이전 버튼 타입이 없을경우(처음 버튼 클릭인 경우)
                resultText = (EditText) findViewById(R.id.textCalcResult);
                if(!resultText.getText().toString().isEmpty() && !nowType.toString().isEmpty()) {
                    //Toast.makeText(this, "현재 nowType:"+nowType+" // 현재 nowCalc:"+nowCalc, Toast.LENGTH_LONG).show();
                    if(nowType.toString().equals("N") ) {           // 숫자타입('=' 포함)

                        // 이전 타입 수식일 경우 현재 선택 숫자를 현재 수식 상태로 계산한다.
                        switch (nowCalc) {
                            case "add":
                                //Toast.makeText(this, "이전 nowResult:"+nowResult+" // 현재 클릭 수 :"+v.getTag().toString(), Toast.LENGTH_LONG).show();
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) - Integer.parseInt(resultText.getText().toString()) + Integer.parseInt(resultText.getText().toString() + v.getTag().toString()));
                                break;
                            case "sub":
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) + Integer.parseInt(resultText.getText().toString()) - Integer.parseInt(resultText.getText().toString() + v.getTag().toString()));
                                break;
                            case "mul":
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) / Integer.parseInt(resultText.getText().toString()) * Integer.parseInt(resultText.getText().toString() + v.getTag().toString()));
                                break;
                            case "div":
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) * Integer.parseInt(resultText.getText().toString()) / Integer.parseInt(resultText.getText().toString() + v.getTag().toString()));
                                break;
                        }
                        resultText.setText(resultText.getText().toString() + v.getTag().toString());
                        //Toast.makeText(this, "이후 nowResult:"+nowResult+" // 현재 클릭 수 :"+v.getTag().toString(), Toast.LENGTH_LONG).show();
                    }else {                                         // 이전 타입이 수식일 경우 현재 선택 숫자 보여줌.
                        //nowResult = resultText.getText().toString();

                        // 이전 타입 수식일 경우 현재 선택 숫자를 현재 수식 상태로 계산한다.
                        switch (nowCalc) {
                            case "add":
                                //Toast.makeText(this, "이전 nowResult:"+nowResult+" // 현재 클릭 수 :"+v.getTag().toString(), Toast.LENGTH_LONG).show();
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) + Integer.parseInt(v.getTag().toString()));
                                break;
                            case "sub":
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) - Integer.parseInt(v.getTag().toString()));
                                break;
                            case "mul":
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) * Integer.parseInt(v.getTag().toString()));
                                break;
                            case "div":
                                nowResult = Integer.toString(Integer.parseInt(nowResult.toString()) / Integer.parseInt(v.getTag().toString()));
                                break;
                        }
                        resultText.setText(v.getTag().toString());

                        //Toast.makeText(this, "현재 nowResult:"+nowResult, Toast.LENGTH_SHORT).show();
                    }

                }else{
                    resultText.setText(v.getTag().toString());

                    nowResult = resultText.getText().toString();
                }
                nowType = "N";
                break;
        }
    }
}
