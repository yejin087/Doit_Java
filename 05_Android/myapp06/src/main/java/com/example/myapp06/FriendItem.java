package com.example.myapp06;

public class FriendItem {

    private String name;
    private String msg;
    private int resourceId;

    public FriendItem(String name, String msg, int resourceId) {
        this.name = name;
        this.msg = msg;
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
