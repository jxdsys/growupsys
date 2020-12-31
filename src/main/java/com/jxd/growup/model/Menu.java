package com.jxd.growup.model;

import java.util.List;

public class Menu {
    private int id;
    private String title;
    private String path;
    private int mid;
    //当前下拉的子菜单
    private List<Menu> sList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public List<Menu> getSList() {
        return sList;
    }

    public void setSList(List<Menu> sList) {
        this.sList = sList;
    }
}
