package com.dev.blog.domain.vo;

public class BoardVO {
    private int idx;
    private String title;
    private String category;
    private String content;
    private String reg_date;
    private String mode_date;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getMode_date() {
        return mode_date;
    }

    public void setMode_date(String mode_date) {
        this.mode_date = mode_date;
    }
}
