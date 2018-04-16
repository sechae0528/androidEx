package com.example.smart_05.project1_7_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //사용할 변수선언
    Button btnGo, btnBack;
    EditText edtUrl;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id찾기
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        edtUrl = (EditText) findViewById(R.id.edtUrl);
        web = (WebView) findViewById(R.id.webView1);




        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(edtUrl.getText().toString());
                //web.loadUrl("http://www.daum.net");
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.goBack();
            }
        });

    }
}
