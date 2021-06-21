package com.example.teamproject_rigun2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private ListView listView;
    private RestaurantAdapter adapter;



    public RestaurantFragment() {
        // Required empty public constructor
    }


     // Fragment 는 특정한 화면 안에 있는 세부적인 화면 등을 구성할떄 사용하는 레이아웃

   /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestaurantFragment newInstance(String param1, String param2) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

//
//        adapter = new RestaurantAdapter();
//
//        //        listView = (ListView) findViewById(R.id.listView);
//        // 리스트 뷰 참조 및 Adapter 달기
//        listView = (ListView) listView.findViewById(R.id.listView);
//        listView.setAdapter(adapter);
//        listview.setOnItemClickListener(listener);
//
//        // ( 제목 부분, 이미지 , 내용 )
//        adapter.addItem("제목1",R.drawable.burgerking, "내용1");
//        adapter.addItem("제목2",R.drawable.burgerking, "내용2");
//        adapter.addItem("제목3",R.drawable.burgerking, "내용3");
//        adapter.addItem("제목4",R.drawable.burgerking, "내용4");
//
//        adapter.notifyDataSetChanged();
//        // 어댑터의 변경을 알림.

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant, container, false);
    }



    

}