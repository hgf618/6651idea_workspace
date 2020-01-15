package com.myzf.service.impl;
import java.util.List;

import com.myzf.dao.UserDao;
import com.myzf.dao.UserDao;
import com.myzf.dao.impl.UserDaoImpl;
import com.myzf.entity.User;
import com.myzf.service.UserService;

/**
 * 用户业务层
 * @author hgf
 *s
 * 2019年8月7日
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao=new UserDaoImpl();
	
	/**
	 * 验证登录，如果成功返回全信息用户对象，否则返回null
	 * @param user
	 * @return
	 */
	public User checkLogin(User user) {
		User targetUser=null;
		List<User> allList=findAll();
		for (User userItem : allList) {
			if(userItem.getUname().equals(user.getUname()) && userItem.getUpass().equals(user.getUpass())) {
				targetUser=userItem;
				break;
			}
		}
		return targetUser;
	}
	
	
	
	
	/**
	 * 获取所有用户列表
	 * @return
	 */
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	/**
	 * 根据主键获取用户对象
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean save(User user) {
		return userDao.save(user);
	}
	
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public boolean update(User user) {
		return userDao.update(user);
	}
	
	/**
	 * 根据主键删除用户对象
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		return userDao.delete(id);
	}
	
	
}
