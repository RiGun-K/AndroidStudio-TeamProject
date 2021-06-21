package com.example.teamproject_rigun2;

public class ListViewItem {

    private int iconDrawable;
    private String contentStr;
    private String titleStr;

    public String getTitle() {
        return this.titleStr;
    }

    public int getIcon() {
        return this.iconDrawable;
    }

    public String getContent() {
        return this.contentStr;
    }


    public void setTitle(String title) {
        titleStr = title;
    }

    public void setIcon(int icon) {
        iconDrawable = icon;
    }

    public void setContent(String content) {
        contentStr = content;
    }
}
