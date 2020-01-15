package com.myzf.service.impl;

import com.myzf.dao.FwlxDao;
import com.myzf.dao.impl.FwlxDaoImpl;
import com.myzf.entity.Fwlx;
import com.myzf.service.FwlxService;

import java.util.List;

public class FwlxServiceImpl implements FwlxService {
    private FwlxDao fwlxDao=new FwlxDaoImpl();

    @Override
    public List<Fwlx> findAll() {
        return fwlxDao.findAll();
    }

    @Override
    public Fwlx findById(int id) {
        return fwlxDao.findById(id);
    }
}
