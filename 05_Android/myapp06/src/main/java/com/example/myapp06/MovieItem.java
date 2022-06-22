package com.example.myapp06;

public class MovieItem {
    private int posterId;
    private String movidName;

    public MovieItem(int posterId, String movidName) {
        this.posterId = posterId;
        this.movidName = movidName;
    }

    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    public String getMovidName() {
        return movidName;
    }

    public void setMovidName(String movidName) {
        this.movidName = movidName;
    }
}
