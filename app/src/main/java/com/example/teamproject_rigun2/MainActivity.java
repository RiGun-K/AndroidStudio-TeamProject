package com.example.teamproject_rigun2;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity  {

    Fragment RestaurantFragement;



    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    // 동훈소스
    // 메인 화면 리스트
    private ArrayList<String> arrayList;
    private VNoteAdapter vNoteAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    // 인텐트
    private Button mbtn_add;

    // 구글맵









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //
//        gogoMap(35.900424, 128.615257); // 버거킹

        ImageView icon = (ImageView) findViewById(R.id.icon);
        ImageView icon1 = (ImageView) findViewById(R.id.icon1);
        ImageView icon2 = (ImageView) findViewById(R.id.icon2);
        ImageView icon3 = (ImageView) findViewById(R.id.icon3);
        ImageView icon4 = (ImageView) findViewById(R.id.icon4);
        ImageView icon5 = (ImageView) findViewById(R.id.icon5);
        ImageView icon9 = (ImageView) findViewById(R.id.icon9);


    





        // 공지사항 작성란
        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("JLPT 시험", " 7월4일(일)", ""));
        noticeList.add(new Notice("일본어 특강", " 6월 17일 ~ 개강전", ""));
        noticeList.add(new Notice("청해진 예비자과정 전공 특강", " 6월28일 ~ 7월 14일 14시~17시 (월~금)", "14시~17시 (월~금)"));
        noticeList.add(new Notice("청해진 예비자과정 전공 특강", " 7월 15일 ~ 23일", "3시간"));
        noticeList.add(new Notice("방 학", " 7월 26일 ~ 30일", ""));
        noticeList.add(new Notice("청해진 예비자과정 전공 특강", " 8월 2일 ~ 6일", "(월) 3시간 (화)~(금) 4시간"));
        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);


        final Button courseButton = (Button) findViewById(R.id.courseButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final Button vocabularynoteButton = (Button) findViewById(R.id.vocabularynoteButton);

        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

        mbtn_add = (Button)findViewById(R.id.mbtn_add);
        final Button mbtn_add = (Button) findViewById(R.id.mbtn_add);
        final Button Aclass = (Button) findViewById(R.id.Aclass);




        courseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.logo));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.good));
                vocabularynoteButton.setBackgroundColor(getResources().getColor(R.color.good));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new RestaurantFragment());
                fragmentTransaction.commit();


            }
        });


        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);
                courseButton.setBackgroundColor(getResources().getColor(R.color.good));
                scheduleButton.setBackgroundColor(getResources().getColor(R.color.logo));
                vocabularynoteButton.setBackgroundColor(getResources().getColor(R.color.good));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
                fragmentTransaction.commit();


            }
        });


        vocabularynoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VMainActivity.class);
                v.getContext().startActivity(intent);


            }
        });



/////////////////////////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////////////////////////

//        mbtn_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                JapanNoteFragment fragment = new JapanNoteFragment();
//                transaction.replace(R.id.frame, fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
//        });
    }




    // Toast 메세지
    //  Toast.makeText(getApplicationContext(), "버튼이 눌렀습니다!",Toast.LENGTH_SHORT).show();

    public void onButtonClicked1(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yel.yjc.ac.kr"));
        startActivity(intent);
    }

    public void onButtonClicked2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yjp.ac.kr/portal/main/index_noie.jsp"));
        startActivity(intent);
    }

    private long lastTimeBackPressed;

    // 05-29 메인화면에서 뒤로가기 누르는 설정
    // https://www.youtube.com/watch?v=4hVFvrAVU_M&list=PLRx0vPvlEmdD862e43ADbvDeGPUZKDuqL&index=9  홍드로이드 9강 14분
    // 프래그먼트에서 수정을 해야 동작됨 !!!

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();

    }



    // 구글맵 호출
//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        LatLng location = new LatLng(35.900424, 128.615257);    // 버거킹 경로
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.title("버거킹");
//        markerOptions.snippet("맛집");   // 세부적 내용
//        markerOptions.position(location);
//        googleMap.addMarker(markerOptions);
//
//        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,16));
//    }




    // 시간표 'A반' 버튼
//    public void AclassButton(View view) {
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.daum.net"));
//        startActivity(intent);
//    }



//     일본어단어장 처음 '추가' 버튼
//    public void JapanButton(View view) {
//        Intent intent = new Intent( MainActivity.this, MainActivity.class);
//        startActivity(intent);
//    }

//    // 회원가입 버튼 클릭시 수행
//        JapanButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//            startActivity(intent);
//        }
//    });

}