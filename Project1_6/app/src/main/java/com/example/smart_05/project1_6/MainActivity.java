package com.example.smart_05.project1_6;


import android.app.TabActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;


@SuppressWarnings("deprecation") //예전버전일 때 나오는 경고문 없애줌
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1> TabHost 사용하기 위한 준비 ==> 정보를 가져옴

        TabHost tabHost = getTabHost();

        //탭 위젯에 들어갈 내용
        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecSong.setContent(R.id.tabSong); //탭에 들어갈 내용과 ID값 연결
        tabHost.addTab(tabSpecSong); //탭에 들어갈 내용을 탭호스트에 연결

        TabHost.TabSpec tabSpecAltist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecAltist.setContent(R.id.tabArtist); //탭에 들어갈 내용과 ID값 연결
        tabHost.addTab(tabSpecAltist); //탭에 들어갈 내용을 탭호스트에 연결

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        tabSpecAlbum.setContent(R.id.tabAlbum); //탭에 들어갈 내용과 ID값 연결
        tabHost.addTab(tabSpecAlbum); //탭에 들어갈 내용을 탭호스트에 연결

        tabHost.setCurrentTab(0); //기본 탭 설정






    }
}
