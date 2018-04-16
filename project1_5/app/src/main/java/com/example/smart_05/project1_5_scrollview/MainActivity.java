package com.example.smart_05.project1_5_scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    //버튼 2개, 뷰플리퍼 1개 변수 선언
    Button btnPrev, btnNext, btnStart, btnStop;
    ViewFlipper vFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //id찾기
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper1);


        vFlipper.setFlipInterval(1000);
        //각 버튼에 클릭 이벤트 부여
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();

            }
        });

        //next 버튼에 기능 부여 ==> showNext()
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();

            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFlipper.startFlipping();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vFlipper.stopFlipping();
            }
        });


    }
}
