package com.myzf.entity;

/**
 * 区县实体
 */
public class Qx {
    private int qxid;
    private String qx;

    public Qx(int qxid, String qx) {
        this.qxid = qxid;
        this.qx = qx;
    }

    public Qx() {
    }

    public int getQxid() {
        return qxid;
    }

    public void setQxid(int qxid) {
        this.qxid = qxid;
    }

    public String getQx() {
        return qx;
    }

    public void setQx(String qx) {
        this.qx = qx;
    }
}
