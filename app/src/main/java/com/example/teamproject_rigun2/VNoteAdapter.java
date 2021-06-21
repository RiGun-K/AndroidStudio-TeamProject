package com.example.teamproject_rigun2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class VNoteAdapter extends RecyclerView.Adapter<VNoteAdapter.CustomViewHolder> {

    // 메인 화면 리스트
    private ArrayList<String> arrayList;
    private Context context;

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        protected TextView list_title;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.list_title = (TextView) itemView.findViewById(R.id.list_title);

            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {  // 3. 컨텍스트 메뉴를 생성하고 메뉴 항목 선택시 호출되는 리스너를 등록해줍니다. ID 1001, 1002로 어떤 메뉴를 선택했는지 리스너에서 구분하게 됩니다.

            MenuItem Edit = menu.add(Menu.NONE, 1001, 1, "편집");
            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);

        }

        // 4. 컨텍스트 메뉴에서 항목 클릭시 동작을 설정합니다.
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {



            @Override
            public boolean onMenuItemClick(MenuItem item) {


                switch (item.getItemId()) {
                    case 1001:  // 5. 편집 항목을 선택시


                        AlertDialog.Builder builder = new AlertDialog.Builder(context);

                        // 다이얼로그를 보여주기 위해 edit_box.xml 파일을 사용합니다.

                        View view = LayoutInflater.from(context).inflate(R.layout.vedit_title, null, false);
                        builder.setView(view);
                        final Button btn_tadd = (Button) view.findViewById(R.id.btn_tadd);
                        final EditText edit_title = (EditText) view.findViewById(R.id.edit_title);



                        // 6. 해당 줄에 입력되어 있던 데이터를 불러와서 다이얼로그에 보여줍니다.
                        edit_title.setText(arrayList.get(getAdapterPosition()));


                        final AlertDialog dialog = builder.create();
                        btn_tadd.setOnClickListener(new View.OnClickListener() {


                            // 7. 수정 버튼을 클릭하면 현재 UI에 입력되어 있는 내용으로

                            public void onClick(View v) {
                                String title = edit_title.getText().toString();

                                boolean result = rename(arrayList.get(getAdapterPosition()), title);
                                if (result == false) {
                                    Toast.makeText(context, "단어장 이름을 확인해주세요", Toast.LENGTH_SHORT).show();
                                }else{
                                    // 8. ListArray에 있는 데이터를 변경하고
                                    arrayList.set(getAdapterPosition(),title);


                                    // 9. 어댑터에서 RecyclerView에 반영하도록 합니다.

                                    notifyItemChanged(getAdapterPosition());

                                    dialog.dismiss();
                                }




                            }
                        });

                        dialog.show();

                        break;

                    case 1002:

                        delete(arrayList.get(getAdapterPosition()));
                        arrayList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), arrayList.size());

                        break;

                }
                return true;
            }
        };

    }



    public VNoteAdapter(Context context, ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VNoteAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vnote_item_list,parent,false);
        VNoteAdapter.CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull VNoteAdapter.CustomViewHolder holder, int position) {
        String noteName = arrayList.get(position);
        holder.list_title.setText(noteName);


        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), VListActivity.class);
                intent.putExtra("noteName", noteName);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    void delete(String name) {
        File file  = new File(context.getFilesDir(),name + ".json");
        file.delete();
    }

    boolean rename(String name, String newname) {
        File file  = new File(context.getFilesDir(),name + ".json");
        File newfile  = new File(context.getFilesDir(),newname + ".json");

        if (newfile.exists()) return false;
        file.renameTo(newfile);

        return true;
    }


}
