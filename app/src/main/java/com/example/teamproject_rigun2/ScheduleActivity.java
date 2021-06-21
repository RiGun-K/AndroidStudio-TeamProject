package com.example.teamproject_rigun2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.acl.Acl;

public class ScheduleActivity extends AppCompatActivity {

    TableLayout tableLayout;
    TableLayout tableLayout1;

    private RadioGroup courseUniversityGroup;
    private RadioButton Aclass, Bclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Schedule 라디오 그룹 객체 생성
       courseUniversityGroup = findViewById(R.id.courseUniversityGroup);


        // 5/22 스케쥴 에있는 A반 , B반 버튼에 대한 객체 생성
        Aclass = findViewById(R.id.Aclass);
        Bclass = findViewById(R.id.Bclass);

//        // 회원가입 버튼 클릭시 수행
//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });


        courseUniversityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.Aclass) {
                    Toast.makeText(ScheduleActivity.this,"A반 시간표",Toast.LENGTH_SHORT).show();

                } else if (checkedId == R.id.Bclass) {
                    Toast.makeText(ScheduleActivity.this,"B반 시간표",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ScheduleActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }

            }
        });


//
//
//
//        // B반 버튼 클릭시 수행
//        Bclass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ScheduleActivity.this, RadioButton.class);
//                startActivity(intent);
//            }
//        });
//


//
//        Aclass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeView(0);
//            }
//        });


    }
//
//    //         라디오그룹 클릭 이벤트
//    RadioGroup.OnCheckedChangeListener courseUniversityGroup = new RaidoGroup. {
//        @Override
//        public void onCheckedChanged(RadioGroup group, int checkedId) {
//            if (checkedId == R.id.Bclass) {
//                Intent intent = new Intent(ScheduleActivity.this, RadioButton.class);
//                startActivity(intent);
//            } else if (checkedId == R.id.Aclass) {
//                Toast.makeText(getApplicationContext(),"A반 입니다,",Toast.LENGTH_SHORT).show();
//            }
//
//
//
//        }
//    });






}
