package com.myzf.dao;

import com.myzf.entity.Qx;

import java.util.List;

public interface QxDao {

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

}
