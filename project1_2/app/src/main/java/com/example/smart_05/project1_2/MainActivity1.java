package com.example.smart_05.project1_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
    //위젯에 따른 사용할 변수 선언
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClear;
    TextView textResult, btnRes, textRes;
    String num1, num2;
    Integer result;
    //Double result2;
    Float result3; //parseFloat

    //추가한 10개의 버튼을 사용하기 위한 배열 선언
    //배열선언 : 타입[] 배열명 = new 타입 [크기]
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
            R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i; //인덱스 번호 체크할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("초간단 계산기");

        //xml에 있는 id값 찾기
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnClear = (Button) findViewById(R.id.BtnClear);
        textResult = (TextView) findViewById(R.id.TextResult);
        btnRes = (TextView) findViewById(R.id.BtnRes);
        textRes = (TextView) findViewById(R.id.TextRes);

        //배열에 있는 id값 찾기
        for (int i=0; i<numBtnIDs.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }


        //기능부여 ==> 이벤트 ==> onTouchListener
        btnAdd.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                //getText() : 입력된 값을 얻기
                //toString() : 문자열화 하기
                num2 = edit2.getText().toString();
                //result = Integer.parseInt(num1) + Integer.parseInt(num2);
                result3 = Float.parseFloat(num1) + Float.parseFloat(num2);
                textRes.setText(num1+" + "+num2);
                //textResult.setText("계산 결과: " + result.toString());
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
               // result = Integer.parseInt(num1) - Integer.parseInt(num2);
                result3 = Float.parseFloat(num1) - Float.parseFloat(num2);
                textRes.setText(num1+" - "+num2);
               // textResult.setText("계산 결과: " + result.toString());
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result3 = Float.parseFloat(num1) * Float.parseFloat(num2);
                textRes.setText(num1+" * "+num2);
              //  textResult.setText("계산 결과: " + result.toString());
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                //result2 = Double.parseDouble(num1) / Double.parseDouble(num2);
                result3 = Float.parseFloat(num1) / Float.parseFloat(num2);
                textRes.setText(num1+" / "+num2);
              //  textResult.setText("계산 결과: " + result3.toString());
                return false;
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit1.setText(null);
                edit2.setText(null);
                textResult.setText("계산 결과: ");
                textRes.setText(" ");
            }
        });

        //0-9 각 버튼에 기능 부여
        for (i=0; i < numBtnIDs.length; i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        //클릭한 버튼을 계속 추가해서 보여주기
                        edit1.setText(num1); //setText:새롭게 값 설정
                        textRes.setText(num1);

                    } else if (edit2.isFocused() == true){
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                        textRes.setText(num2);

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResult.setText("계산 결과: " + result3.toString());


            }
        });



    }
}
