package com.myzf.action;

import com.myzf.entity.Fwlx;
import com.myzf.service.FwlxService;
import com.myzf.service.impl.FwlxServiceImpl;

import java.util.List;

public class FwlxAction {
    private List<Fwlx> fwlxList;
    private FwlxService fwlxService=new FwlxServiceImpl();

    public String execute(){
        fwlxList=fwlxService.findAll();
        return "fwlxlist";
    }

    public List<Fwlx> getFwlxList() {
        return fwlxList;
    }

    public void setFwlxList(List<Fwlx> fwlxList) {
        this.fwlxList = fwlxList;
    }
}
