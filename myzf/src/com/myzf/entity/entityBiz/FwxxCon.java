package com.myzf.entity.entityBiz;

import com.myzf.entity.Fwxx;

/**
 * 搜索实体类
 */
public class FwxxCon {
    private Fwxx fwxx;//搜索房屋信息实体里的条件对象
    private  int zj1;//租金下限
    private int zj2;//租金上限
    private int[] lxids;//房屋类型搜索条件（可能多个类型）
    private int days;//最近今天条件

    public FwxxCon() {
    }

    public FwxxCon(Fwxx fwxx, int zj1, int zj2, int[] lxids, int days) {
        this.fwxx = fwxx;
        this.zj1 = zj1;
        this.zj2 = zj2;
        this.lxids = lxids;
        this.days = days;
    }

    public Fwxx getFwxx() {
        return fwxx;
    }

    public void setFwxx(Fwxx fwxx) {
        this.fwxx = fwxx;
    }

    public int getZj1() {
        return zj1;
    }

    public void setZj1(int zj1) {
        this.zj1 = zj1;
    }

    public int getZj2() {
        return zj2;
    }

    public void setZj2(int zj2) {
        this.zj2 = zj2;
    }

    public int[] getLxids() {
        return lxids;
    }

    public void setLxids(int[] lxids) {
        this.lxids = lxids;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
