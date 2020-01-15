package com.myzf.service.impl;

import com.myzf.dao.FwxxDao;
import com.myzf.dao.impl.FwxxDaoImpl;
import com.myzf.entity.Fwxx;
import com.myzf.entity.Jd;
import com.myzf.entity.Qx;
import com.myzf.entity.entityBiz.FwxxCon;
import com.myzf.service.FwxxService;
import com.myzf.util.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FwxxServiceImpl implements FwxxService {
    private FwxxDao fwxxDao=new FwxxDaoImpl();
    @Override
    public List<Fwxx> findAll() {
        return fwxxDao.findAll();
    }

    @Override
    public Fwxx findById(int id) {
        return fwxxDao.findById(id);
    }

    @Override
    public boolean save(Fwxx fwxx) {
        return fwxxDao.save(fwxx);
    }

    @Override
    public boolean update(Fwxx fwxx) {
        return fwxxDao.update(fwxx);
    }

    @Override
    public boolean delete(int id) {
        return fwxxDao.delete(id);
    }


    /**
     * 搜索某个用户发布的房源信息
     * @param uid
     * @return
     */
    public List<Fwxx> findByUser(int uid){
        List<Fwxx> allList=fwxxDao.findAll();
        List<Fwxx> targetList=new ArrayList<>();
        for (Fwxx fwxx:allList) {
            if(fwxx.getUser().getUid()==uid){
                targetList.add(fwxx);
            }
        }
        return targetList;
    }


    /**
     * 查询满足条件的记录数
     * @param fwxxCon
     * @return
     */
    public int findCountByCon(FwxxCon fwxxCon){
        return fwxxDao.findCountByCon(fwxxCon);
    }

    /**
     * 查询满足条件的集合并分页
     * @param fwxxCon
     * @param page
     * @return
     */
    public List<Fwxx> findListByCon(FwxxCon fwxxCon, Page page){
        return fwxxDao.findListByCon(fwxxCon, page);
    }

}
