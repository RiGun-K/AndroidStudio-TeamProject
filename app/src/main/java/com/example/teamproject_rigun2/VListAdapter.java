package com.example.teamproject_rigun2;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VListAdapter extends RecyclerView.Adapter<VListAdapter.CustomViewHolder>{
    private ArrayList<VListData> arrayList;
    private VListActivity vListActivity;

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        protected TextView kanji;
        protected TextView hatsuon;
        protected TextView imi;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.kanji = (TextView) itemView.findViewById(R.id.kanji);
            this.hatsuon = (TextView) itemView.findViewById(R.id.hatsuon);
            this.imi = (TextView) itemView.findViewById(R.id.imi);

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


                        AlertDialog.Builder builder = new AlertDialog.Builder(vListActivity);

                        // 다이얼로그를 보여주기 위해 edit_box.xml 파일을 사용합니다.

                        View view = LayoutInflater.from(vListActivity).inflate(R.layout.vactivity_edit_item, null, false);
                        builder.setView(view);
                        final Button btn_add = (Button) view.findViewById(R.id.btn_add);
                        final EditText edit_kanji = (EditText) view.findViewById(R.id.edit_kanji);
                        final EditText edit_hatsuon = (EditText) view.findViewById(R.id.edit_hatsuon);
                        final EditText edit_imi = (EditText) view.findViewById(R.id.edit_imi);



                        // 6. 해당 줄에 입력되어 있던 데이터를 불러와서 다이얼로그에 보여줍니다.
                        edit_kanji.setText(arrayList.get(getAdapterPosition()).getKanji());
                        edit_hatsuon.setText(arrayList.get(getAdapterPosition()).getHatsuon());
                        edit_imi.setText(arrayList.get(getAdapterPosition()).getImi());



                        final AlertDialog dialog = builder.create();
                        btn_add.setOnClickListener(new View.OnClickListener() {


                            // 7. 수정 버튼을 클릭하면 현재 UI에 입력되어 있는 내용으로

                            public void onClick(View v) {
                                String kanji = edit_kanji.getText().toString();
                                String hatsuon = edit_hatsuon.getText().toString();
                                String imi = edit_imi.getText().toString();

                                VListData vListData = new VListData(kanji, hatsuon, imi);


                                // 8. ListArray에 있는 데이터를 변경하고
                                arrayList.set(getAdapterPosition(), vListData);


                                // 9. 어댑터에서 RecyclerView에 반영하도록 합니다.

                                notifyItemChanged(getAdapterPosition());

                                dialog.dismiss();
                                vListActivity.save();
                            }
                        });

                        dialog.show();

                        break;

                    case 1002:

                        arrayList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), arrayList.size());
                        vListActivity.save();

                        break;

                }
                return true;
            }
        };
    }

    public VListAdapter(VListActivity vListActivity, ArrayList<VListData> arrayList) {
        this.arrayList = arrayList;
        this.vListActivity = vListActivity;
    }

    @Override
    public VListAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vlist_item_list,parent,false);
        VListAdapter.CustomViewHolder holder = new VListAdapter.CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.kanji.setText(arrayList.get(position).getKanji());
        holder.hatsuon.setText(arrayList.get(position).getHatsuon());
        holder.imi.setText(arrayList.get(position).getImi());


        holder.itemView.setTag(position);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
////
//                Intent intent = new Intent(v.getContext(), EditItem.class);
//                v.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }


}
