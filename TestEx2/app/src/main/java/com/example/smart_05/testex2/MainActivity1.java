package com.example.smart_05.testex2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {

    EditText text3, text4, text5, text6;
    Button btn2;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("전송하기");

        text3 = (EditText) findViewById(R.id.text3);
        text4 = (EditText) findViewById(R.id.text4);
        text5 = (EditText) findViewById(R.id.text5);
        btn2 = (Button) findViewById(R.id.btn2);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), text3.getText().toString()
                        +text4.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });





    }
}
