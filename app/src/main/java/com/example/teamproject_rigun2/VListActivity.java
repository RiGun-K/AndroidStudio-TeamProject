package com.example.teamproject_rigun2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class VListActivity extends AppCompatActivity {

    private String noteName;
    private VNoteData vNoteData;
    private VListAdapter vListAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vactivity_vlist);

        noteName = getIntent().getStringExtra("noteName");
        load(noteName);


        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));

        vListAdapter = new VListAdapter(this, vNoteData.getvListDataArrayList());
        recyclerView.setAdapter(vListAdapter);

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
//                linearLayoutManager.getOrientation());
//        recyclerView.addItemDecoration(dividerItemDecoration);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(VListActivity.this, EditItem.class);
//                startActivity(intent);
//                VListData vListData = new VListData("kanji","hatsuon","imi");
//                arrayList.add(vListData);
//                vListAdapter.notifyDataSetChanged();

                AlertDialog.Builder builder = new AlertDialog.Builder(VListActivity.this);
                View view = LayoutInflater.from(VListActivity.this).inflate(R.layout.vactivity_edit_item, null, false);
                builder.setView(view);
                final Button btn_add = (Button) view.findViewById(R.id.btn_add);
                final EditText edit_kanji = (EditText) view.findViewById(R.id.edit_kanji);
                final EditText edit_hatsuon = (EditText) view.findViewById(R.id.edit_hatsuon);
                final EditText edit_imi = (EditText) view.findViewById(R.id.edit_imi);

                btn_add.setText("삽입");


                final AlertDialog dialog = builder.create();
                btn_add.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String kanji = edit_kanji.getText().toString();
                        String hatsuon = edit_hatsuon.getText().toString();
                        String imi = edit_imi.getText().toString();

                        VListData vListData = new VListData(kanji, hatsuon, imi);

                        vNoteData.getvListDataArrayList().add(vListData);//마지막 줄에 삽입
                        vListAdapter.notifyDataSetChanged();

                        dialog.dismiss();
                        save(noteName);
                    }
                });
                dialog.show();
            }

//    @Override
//    public void onBackPressed() {
//
//        Intent intent = new Intent(VListActivity.this,MainActivity.class);
//        setResult(RESULT_OK, intent);
//        finish();
//        super.onBackPressed();
//    }
        });
    }
    public void save() {
        this.save(noteName);
    }


    private void save(String name){
        File file  = new File(getFilesDir(),name + ".json");
        try {
            JSONObject obj = vNoteData.toJSONObject();
            String json = obj.toString(2);
            byte[] bytes = json.getBytes();
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
        } catch (FileNotFoundException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void load(String name) {
        File file  = new File(getFilesDir(),name + ".json");
        try {
            byte[] bytes = new byte[(int)file.length()];
            InputStream is = new FileInputStream(file);
            is.read(bytes);

            String str = new String(bytes);
            JSONObject obj = new JSONObject(str);

            vNoteData = VNoteData.fromJSONObject(obj);


        } catch (FileNotFoundException e) {
            vNoteData = new VNoteData(name);
            save(name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}