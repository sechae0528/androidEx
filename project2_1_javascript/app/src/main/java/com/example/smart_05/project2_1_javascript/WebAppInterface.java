package com.example.smart_05.project2_1_javascript;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by SMART-05 on 2018-04-16.
 */

public class WebAppInterface {
    Context mContext;

    WebAppInterface(Context c){
        mContext = c;
    }
    //메서드 정의 ==> 자바스크립트에서 안드로이드 메서드 호출
    @JavascriptInterface
    public void showToast (String toast) {
        Toast.makeText(mContext,toast, Toast.LENGTH_SHORT).show();
    }

}
