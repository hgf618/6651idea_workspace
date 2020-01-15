package com.myzf.service.impl;

import com.myzf.dao.JdDao;
import com.myzf.dao.impl.JdDaoImpl;
import com.myzf.entity.Jd;

import java.util.ArrayList;
import java.util.List;

public class JdServiceImpl {
    private JdDao jdDao=new JdDaoImpl();

    /**
     * 获取所有街道集合
     * @return
     */
    public List<Jd> findAll(){
        return jdDao.findAll();
    }

    /**
     * 根据主键获取街道对象
     * @param id
     * @return
     */
    public Jd findById(int id){
       return jdDao.findById(id);
    }

    /**
     * 根据区县id获取到街道集合
     * @param qxid
     * @return
     */
    public List<Jd> findListByQxid(int qxid){
        List<Jd> allList=jdDao.findAll();
        List<Jd> targetList=new ArrayList<>();
        for(Jd jd:allList){
            if(jd.getQx().getQxid()==qxid){
                targetList.add(jd);
            }
        }
        return targetList;
    }
}
