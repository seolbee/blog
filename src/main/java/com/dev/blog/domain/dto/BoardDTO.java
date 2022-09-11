package com.dev.blog.domain.dto;

public class BoardDTO {

    private int idx;
    private String title;
    private String content;
    private int category;

    public BoardDTO(String title, String content, int category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public BoardDTO() {
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
