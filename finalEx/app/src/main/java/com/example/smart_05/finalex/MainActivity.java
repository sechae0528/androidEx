package com.example.smart_05.finalex;

import android.app.TabActivity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    //변수 선언
    ProgressBar mProgStatus;
    EditText text1, text2;
    Button btn2, btnDecrease1, btnIncrease1;
    Integer result;
    String sungjuk;
    TextView textview;
    ImageView img1,img2, img3, img4;
    TextView art1, art2;

    //Rating 추가
    Button btnDecrease2, btnIncrease2, btnResult;
    RatingBar mRatingVote;

    //seekboar 찾기
    SeekBar mSeekRed;
    View mViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("중간고사");

        //탭 정보 가져오기
        TabHost tabHost = getTabHost();

        //탭 위젯에 들어갈 메뉴명
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("Tab1").setIndicator("명화목록");
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("Tab2").setIndicator("성적계산");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("Tab3").setIndicator("위젯종류");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0);


        //id찾기
        mProgStatus = (ProgressBar) findViewById(R.id.progStatus);
        btnDecrease1 = (Button) findViewById(R.id.btnDecrease1);
        btnIncrease1 = (Button) findViewById(R.id.btnIncrease1);

        //Rationg에 대한 id 찾기
        mRatingVote = (RatingBar)findViewById(R.id.ratingVote);
        btnDecrease2 = (Button) findViewById(R.id.btnDecrease2);
        btnIncrease2 = (Button) findViewById(R.id.btnIncrease2);
        btnResult = (Button)findViewById(R.id.btnResult);

        //seekbar  id 찾기
        mSeekRed = (SeekBar)findViewById(R.id.seekRed);
        mViewColor = findViewById(R.id.viewColor);


        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        btn2 = (Button) findViewById(R.id.button1);
        textview = (TextView) findViewById(R.id.textView6);


        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        art1 = (TextView) findViewById(R.id.textView2);
        art2 = (TextView) findViewById(R.id.textView4);
        //img3.setImageResource(R.drawable.img2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3.setVisibility(view.VISIBLE);
                img4.setVisibility(view.INVISIBLE);
                Toast.makeText(getApplicationContext(),art1.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3.setVisibility(view.INVISIBLE);
                img4.setVisibility(view.VISIBLE);
                Toast.makeText(getApplicationContext(),art2.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        //버튼 기능 추가
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sungjuk = text2.getText().toString(); //사용자가 입력한 값
                result = Integer.parseInt(sungjuk);

                //조건 비교
                if(result>=90){
                    textview.setText(text1.getText().toString()+ "님의 성적은 A입니다.");
                }else if (result>=80){
                    textview.setText(text1.getText().toString()+ "님의 성적은 B입니다.");
                }else if (result>=70){
                    textview.setText(text1.getText().toString()+ "님의 성적은 C입니다.");
                }else if (result>=60){
                    textview.setText(text1.getText().toString()+ "님의 성적은 D입니다.");
                }else {
                    textview.setText(text1.getText().toString()+ "님의 성적은 F입니다.");
                }
            }
        });

        //기본 배경 색상
        mViewColor.setBackgroundColor(Color.argb(255, mSeekRed.getProgress(), 0,0));
        //mViewColor.setBackgroundColor(getResources().getColor(R.color.blue));

        //감소 증가하기 위한 버튼에 클릭
        btnDecrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgStatus.setProgress(mProgStatus.getProgress()-5);
            }
        });
        btnIncrease1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgStatus.setProgress(mProgStatus.getProgress()+5);
            }
        });

        btnDecrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(-1);
            }
        });

        btnIncrease2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingVote.incrementProgressBy(+1);
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"현재값=" +mRatingVote.getRating(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        //seekbar 이벤트
        mSeekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mViewColor.setBackgroundColor(Color.argb(255, progress, 0,0));

                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
