package com.myzf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.myzf.dao.UserDao;
import com.myzf.entity.User;

/**
 * 用户连接数据库类
 * @author hgf
 *
 * 2019年8月2日
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 获取所有用户列表
	 * @return
	 */
	public List<User> findAll(){
		String sql="select * from tbl_user";
		return findList(sql);
	}
	
	/**
	 * 根据主键获取用户对象
	 * @param id
	 * @return
	 */
	public User findById(int id) {
		String sql="select * from tbl_user where uid="+id;
		List<User> list=findList(sql);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	
	/**
	 * 根据sql语句获取用户集合
	 * @param sql
	 * @return
	 */
	private  List<User> findList(String sql){
		List<User> list=new ArrayList<>();
		ResultSet resultSet=ConnectionManager.executeQuery(sql);
		try {
			 int uid;
			 String uname;
			 String upass;
			 Timestamp regTime;
			while(resultSet.next()) {
				uid=resultSet.getInt("uid");
				uname=resultSet.getString("uname");
				upass=resultSet.getString("upass");
				User user=new User(uid, uname, upass);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectionManager.closeAll(resultSet, resultSet.getStatement(), resultSet.getStatement().getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean save(User user) {
		String sql="insert tbl_user(uname,upass) values(?,?)";
		List<Object> paramList=new ArrayList<>();
		paramList.add(user.getUname());
		paramList.add(user.getUpass());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public boolean update(User user) {
		String sql="update tbl_user set uname=?,upass=? where uid=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(user.getUname());
		paramList.add(user.getUpass());
		paramList.add(user.getUid());
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	/**
	 * 根据主键删除用户对象
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		String sql="delete from  tbl_users where uid=?";
		List<Object> paramList=new ArrayList<>();
		paramList.add(id);
		return ConnectionManager.executeUpdate(sql,paramList);
	}
	
	
	
}
