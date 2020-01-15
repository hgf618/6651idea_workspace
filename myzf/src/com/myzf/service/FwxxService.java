package com.myzf.service;

import com.myzf.entity.Fwxx;
import com.myzf.entity.Jd;
import com.myzf.entity.entityBiz.FwxxCon;
import com.myzf.util.Page;

import java.time.chrono.JapaneseDate;
import java.util.List;
import java.util.Map;

/**
 * 房屋信息业务接口
 */
public interface FwxxService {

	
	/**
	 * 获取所有房屋信息列表
	 * @return
	 */
	public List<Fwxx> findAll();
	
	/**
	 * 根据主键获取房屋信息对象
	 * @param id
	 * @return
	 */
	public Fwxx findById(int id);
	
	/**
	 * 添加房屋信息
	 * @param fwxx
	 * @return
	 */
	public boolean save(Fwxx fwxx);
	
	
	/**
	 * 修改房屋信息
	 * @param fwxx
	 * @return
	 */
	public boolean update(Fwxx fwxx);
	
	/**
	 * 根据主键删除房屋信息对象
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * 搜索某个用户发布的房源信息
	 * @param uid
	 * @return
	 */
	public List<Fwxx> findByUser(int uid);

	/**
	 * 查询满足条件的记录数
	 * @param fwxxCon
	 * @return
	 */
	public int findCountByCon(FwxxCon fwxxCon);

	/**
	 * 查询满足条件的集合并分页
	 * @param fwxxCon
	 * @param page
	 * @return
	 */
	public List<Fwxx> findListByCon(FwxxCon fwxxCon, Page page);

}
