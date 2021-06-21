package com.example.teamproject_rigun2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class VNoteData {

    // 메인 화면 리스트
    private String listTitle;
    private ArrayList<VListData> vListDataArrayList = new ArrayList<>();


    public VNoteData(String list_title) {
        this.listTitle = list_title;
    }


    public String getListTitle() {
        return listTitle;
    }

    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    public ArrayList<VListData> getvListDataArrayList() {
        return vListDataArrayList;
    }

    public void setvListDataArrayList(ArrayList<VListData> vListDataArrayList) {
        this.vListDataArrayList = vListDataArrayList;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("listTitle",listTitle);

        JSONArray arr = new JSONArray();
        for(VListData data : vListDataArrayList) {
            arr.put(data.toJSONObject());
        }
        obj.put("words", arr);
        return obj;
    }

    public static VNoteData fromJSONObject(JSONObject obj) throws JSONException {
        String listTitle = obj.getString("listTitle");
        VNoteData vNoteData = new VNoteData(listTitle);
        JSONArray arr = obj.getJSONArray("words");
        for (int i = 0; i < arr.length() ; i++) {
            JSONObject item = arr.getJSONObject(i);
            VListData data = VListData.fromJSONObject(item);
            vNoteData.getvListDataArrayList().add(data);
        }


        return vNoteData;
    }


}
