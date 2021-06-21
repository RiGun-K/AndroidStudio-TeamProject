package com.example.teamproject_rigun2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;




public class VMainActivity extends AppCompatActivity {

    // 메인 화면 리스트
    private ArrayList<String> arrayList;
    private VNoteAdapter vNoteAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    // 인텐트
    private Button mbtn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vocabularynote);


        //메인화면 리스트
        recyclerView = (RecyclerView)findViewById(R.id.mrv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        loadList();
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));

        vNoteAdapter = new VNoteAdapter(this, arrayList);
        recyclerView.setAdapter(vNoteAdapter);

        mbtn_add = (Button)findViewById(R.id.mbtn_add);
        mbtn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VMainActivity.this);

                View view = LayoutInflater.from(VMainActivity.this)
                        .inflate(R.layout.vedit_title, null, false);
                builder.setView(view);

                final Button btn_tadd = (Button) view.findViewById(R.id.btn_tadd);
                final EditText edit_title = (EditText) view.findViewById(R.id.edit_title);
                btn_tadd.setText("삽입");

                final AlertDialog dialog = builder.create();

// 3. 다이얼로그에 있는 삽입 버튼을 클릭하면

                btn_tadd.setOnClickListener(new View.OnClickListener() {


                    public void onClick(View v) {


                        // 4. 사용자가 입력한 내용을 가져와서
                        String title = edit_title.getText().toString();

                        // 5. ArrayList에 추가하고


//                        arrayList.add(title); //마지막 줄에 삽입됨
                        //mArrayList.add(dict);


                        // 6. 어댑터에서 RecyclerView에 반영하도록 합니다.

//                        vNoteAdapter.notifyItemInserted(0);
//                        vNoteAdapter.notifyDataSetChanged();


                        Intent intent = new Intent(v.getContext(), VListActivity.class);
                        intent.putExtra("noteName", title);
                        v.getContext().startActivity(intent);

                        dialog.dismiss();
                    }
                });

                dialog.show();






//                VNoteData vNoteData = new VNoteData("hi");
//                arrayList.add(vNoteData);
//                vNoteAdapter.notifyDataSetChanged();

                //인텐트
//                Intent intent = new Intent(MainActivity.this, VListActivity.class);
//                startActivity(intent); // 액티비티 이동


            }
        });






    }

    private void loadList() {
        arrayList = new ArrayList<>();
        File dir = getFilesDir();
        File[] list = dir.listFiles();
        for(File file : list) {
            String name = file.getName();
            String[] split = name.split("\\.");
            String notename = split[0];
            arrayList.add(notename);
        }
    }


}