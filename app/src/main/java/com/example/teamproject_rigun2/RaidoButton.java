package com.example.teamproject_rigun2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

public class RaidoButton extends AppCompatActivity {

    TableLayout tableLayout;
    TableLayout tableLayout1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.removeView(tableLayout);
        frame.removeView(tableLayout1);


        // Schedule 라디오 그룹 객체 생성
        RadioGroup courseUniversityGroup = findViewById(R.id.courseUniversityGroup);
        // 5/22 스케쥴 에있는 A반 , B반 버튼에 대한 객체 생성
//        RadioButton Aclass = (RadioButton) findViewById(R.id.Aclass);
//        RadioButton Bclass = (RadioButton) findViewById(R.id.Bclass);

        Button Aclass = (Button) findViewById(R.id.Aclass);
        Button Bclass = (Button) findViewById(R.id.Bclass);


        tableLayout = (TableLayout) findViewById(R.id.Aschedule);
//        tableLayout1 = (TableLayout) findViewById(R.id.Bschedule);



    }


}
