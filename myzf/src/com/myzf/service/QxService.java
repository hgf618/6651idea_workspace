package com.myzf.service;

import com.myzf.entity.Jd;
import com.myzf.entity.Qx;

import java.util.List;
import java.util.Map;

public interface QxService {

    /**
     * 获取所有区县集合
     * @return
     */
    public List<Qx> findAll();

    /**
     * 根据主键获取区县对象
     * @param id
     * @return
     */
    public Qx findById(int id);

    /**
     * 获取区县街道Map集合
     * @return
     */
    public Map<Integer,List<Jd>> findQxJdMap();

}
