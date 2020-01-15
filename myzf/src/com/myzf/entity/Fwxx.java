package com.myzf.entity;

import java.sql.Timestamp;

/**
 * 房屋信息实体
 */
public class Fwxx {
    private int fwid;
    private User user;//用户外键对象
    private Jd jd;//街道外键的对象
    private Fwlx fwlx;//房屋类型外键对象
    private int shi;
    private int ting;
    private String fwxx;
    private int zj;
    private String title;
    private Timestamp date;
    private String telephone;
    private String lxr;

    public Fwxx() {
    }

    public Fwxx(int fwid, User user, Jd jd, Fwlx fwlx, int shi, int ting, String fwxx, int zj, String title, Timestamp date, String telephone, String lxr) {
        this.fwid = fwid;
        this.user = user;
        this.jd = jd;
        this.fwlx = fwlx;
        this.shi = shi;
        this.ting = ting;
        this.fwxx = fwxx;
        this.zj = zj;
        this.title = title;
        this.date = date;
        this.telephone = telephone;
        this.lxr = lxr;
    }

    public int getFwid() {
        return fwid;
    }

    public void setFwid(int fwid) {
        this.fwid = fwid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Jd getJd() {
        return jd;
    }

    public void setJd(Jd jd) {
        this.jd = jd;
    }

    public Fwlx getFwlx() {
        return fwlx;
    }

    public void setFwlx(Fwlx fwlx) {
        this.fwlx = fwlx;
    }

    public int getShi() {
        return shi;
    }

    public void setShi(int shi) {
        this.shi = shi;
    }

    public int getTing() {
        return ting;
    }

    public void setTing(int ting) {
        this.ting = ting;
    }

    public String getFwxx() {
        return fwxx;
    }

    public void setFwxx(String fwxx) {
        this.fwxx = fwxx;
    }

    public int getZj() {
        return zj;
    }

    public void setZj(int zj) {
        this.zj = zj;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }
}
