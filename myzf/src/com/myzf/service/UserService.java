package com.myzf.service;

import java.util.List;

import com.myzf.entity.User;

public interface UserService {


	/**
	 * 验证登录，如果成功返回全信息用户对象，否则返回null
	 * @param user
	 * @return
	 */
	public User checkLogin(User user);
	
	
	
	
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
	public boolean update(User user);
	
	/**
	 * 根据主键删除用户对象
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
	
}
