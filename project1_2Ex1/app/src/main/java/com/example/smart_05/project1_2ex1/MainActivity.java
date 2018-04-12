package com.example.smart_05.project1_2ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    TextView textResult1,textResult2;
    Button bmi;
    String num1, num2;
    Double num3, result, result2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BMI지수 계산기");

        height = (EditText) findViewById(R.id.Height);
        weight = (EditText) findViewById(R.id.Weight);
        textResult1 = (TextView) findViewById(R.id.Result1);
        textResult2 = (TextView) findViewById(R.id.Result2);
        bmi = (Button) findViewById(R.id.BMI);

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = height.getText().toString();
                num2 = weight.getText().toString();
                num3 = Double.parseDouble(num1)*0.01;

                result = Double.parseDouble(num2)/(num3*num3);
                result2 = Math.round(result*100)/100.0;

                if(result<18.5){
                    textResult1.setText(result2.toString());
                    textResult2.setText("저체중입니다.");

                }else if(result>=18.5 && result <=22.9){
                    textResult1.setText(result2.toString());
                    textResult2.setText("정상입니다.");
                }else {
                    textResult1.setText(result2.toString());
                    textResult2.setText("비만입니다.");
                }


            }
        });
    }
}
