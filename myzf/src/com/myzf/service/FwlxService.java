package com.myzf.service;

import com.myzf.entity.Fwlx;

import java.util.List;

public interface FwlxService {

    /**
     * 获取所有房屋类型集合
     * @return
     */
    public List<Fwlx> findAll();

    /**
     * 根据主键获取房屋类型对象
     * @param id
     * @return
     */
    public Fwlx findById(int id);

}
