package com.myzf.dao;

import java.util.List;

import com.myzf.entity.User;


public interface UserDao {

	/**
	 * 获取所有用户列表
	 * @return
	 */
	public List<User> findAll();
	
	/**
	 * 根据主键获取用户对象
	 * @param id
	 * @return
	 */
	public User findById(int id);
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean save(User user);
	
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public boolean update(User user) ;
	
	/**
	 * 根据主键删除用户对象
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
}
