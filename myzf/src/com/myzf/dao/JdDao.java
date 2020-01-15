package com.myzf.dao;

import com.myzf.entity.Jd;

import java.util.List;

public interface JdDao {

    /**
     * 获取所有街道集合
     * @return
     */
    public List<Jd> findAll();

    /**
     * 根据主键获取街道对象
     * @param id
     * @return
     */
    public Jd findById(int id);
}
