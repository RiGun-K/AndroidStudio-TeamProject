package com.example.teamproject_rigun2;

import org.json.JSONException;
import org.json.JSONObject;

public class VListData {
    private String kanji;
    private String hatsuon;
    private String imi;

    public VListData(String kanji, String hatsuon, String imi) {
        this.kanji = kanji;
        this.hatsuon = hatsuon;
        this.imi = imi;

    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("kanji",kanji);
        obj.put("hatsuon",hatsuon);
        obj.put("imi",imi);

        return obj;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getHatsuon() {
        return hatsuon;
    }

    public void setHatsuon(String hatsuon) {
        this.hatsuon = hatsuon;
    }

    public String getImi() {
        return imi;
    }

    public void setImi(String imi) {
        this.imi = imi;
    }

    public static VListData fromJSONObject(JSONObject obj) throws JSONException{
        String kanji = obj.getString("kanji");
        String hatsuon = obj.getString("hatsuon");
        String imi = obj.getString("imi");

        VListData vListData = new VListData(kanji, hatsuon, imi);

        return vListData;
    }

}
