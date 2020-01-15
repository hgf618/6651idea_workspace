package com.myzf.service.impl;

import com.myzf.dao.QxDao;
import com.myzf.dao.impl.QxDaoImpl;
import com.myzf.entity.Jd;
import com.myzf.entity.Qx;
import com.myzf.service.QxService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QxServiceImpl implements QxService {
    private QxDao qxDao=new QxDaoImpl();
    private JdServiceImpl jdService=new JdServiceImpl();

    @Override
    public List<Qx> findAll() {
        return qxDao.findAll();
    }

    @Override
    public Qx findById(int id) {
        return qxDao.findById(id);
    }


    @Override
    public Map<Integer, List<Jd>> findQxJdMap() {
        Map<Integer, List<Jd>> map=new HashMap<>();
        List<Qx> qxList=qxDao.findAll();//获取所有的区县集合
        for(Qx qx:qxList){//遍历区县集合
            List<Jd> jdList=jdService.findListByQxid(qx.getQxid());//根据区县id获取该区县下的所有街道集合
            map.put(qx.getQxid(),jdList);//把区县id作为key，该区县下的所有街道集合作为值，添加到map集合中
        }
        return map;
    }
}
