package com.example.teamproject_rigun2;

import android.media.Rating;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class RestaurantActivity extends AppCompatActivity {

    private ListView listView;
    private RestaurantAdapter adapter;

    private RatingBar ratingBar_Indicator;
    private RatingBar ratingBar;

    int[] ratingValues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 실행할 레이아웃 설정

        // Adapter 생성
//        adapter = new RestaurantAdapter();

//        // 리스트 뷰 참조 및 Adapter 달기
//        listView = (ListView) findViewById(R.id.listView);
//        listView.setAdapter(adapter);
//        // listview.setOnItemClickListener(listener);
//
//        // ( 제목 부분, 이미지 , 내용 )
//        adapter.addItem("제목1",R.drawable.burgerking, "내용1");
//        adapter.addItem("제목2",R.drawable.burgerking, "내용2");
//        adapter.addItem("제목3",R.drawable.burgerking, "내용3");
//        adapter.addItem("제목4",R.drawable.burgerking, "내용4");
//
//        adapter.notifyDataSetChanged();
//        // 어댑터의 변경을 알림.


        ratingBar_Indicator = findViewById(R.id.ratingBar);
        ratingBar_Indicator = findViewById(R.id.ratingBar3);
        ratingBar_Indicator = findViewById(R.id.ratingBar4);
        ratingBar_Indicator = findViewById(R.id.ratingBar5);
        ratingBar_Indicator = findViewById(R.id.ratingBar6);
        ratingBar_Indicator = findViewById(R.id.ratingBar7);
        ratingBar_Indicator = findViewById(R.id.ratingBar8);

        ratingBar_Indicator.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });


    }

}
