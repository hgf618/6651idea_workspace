package com.myzf.entity;

/**
 * 房屋类型
 */
public class Fwlx {
    private int lxid;
    private String fwlx;

    public int getLxid() {
        return lxid;
    }

    public void setLxid(int lxid) {
        this.lxid = lxid;
    }

    public String getFwlx() {
        return fwlx;
    }

    public void setFwlx(String fwlx) {
        this.fwlx = fwlx;
    }

    public Fwlx(int lxid, String fwlx) {
        this.lxid = lxid;
        this.fwlx = fwlx;
    }

    public Fwlx() {
    }
}
