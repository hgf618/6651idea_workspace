package com.myzf.entity;

/**
 * 街道实体
 */
public class Jd {
    private int jdid;
    private String jd;
    private Qx qx;//区县外键对象

    public Jd() {
    }

    public Jd(int jdid, String jd, Qx qx) {
        this.jdid = jdid;
        this.jd = jd;
        this.qx = qx;
    }

    public int getJdid() {
        return jdid;
    }

    public void setJdid(int jdid) {
        this.jdid = jdid;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public Qx getQx() {
        return qx;
    }

    public void setQx(Qx qx) {
        this.qx = qx;
    }
}
