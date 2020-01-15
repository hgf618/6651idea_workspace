package com.myzf.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class ConnectionManager {
	private static String DRIVER;
	private static String URL;
	private static String UNAME;
	private static String UPASS;

	/**
	 * SqlServer创建连接类
	 * @return
	 */
	/*
	private static Connection createConnection() {
		Connection connection=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//加载并注册驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:sqlserver://localhost:1433;DataBaseName=studb2";
		try {
			connection=DriverManager.getConnection(url, "sa", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	*/
	
	/**
	 * 本地MySql连接类
	 * @return
	 */
	/*
	private static Connection createConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载并注册驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/photoelectricdb?characterEncoding=utf-8";
		try {
			connection=DriverManager.getConnection(url, "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	*/
	
	
	/**
	 * 远程MySql连接类
	 * @return
	 */
	/*
	private static Connection createConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载并注册驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://61.164.246.80:3306/sq_wx1369?characterEncoding=utf-8";
		try {
			connection=DriverManager.getConnection(url, "sq_wx1369", "wx1369db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	*/
	
	/**
	 * 初始化链接参数
	 */

	private static void initConfig() {
		InputStream inputStream = ConnectionManager.class.getResourceAsStream("dbconfig.properties");//读取属性文件
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			DRIVER = properties.getProperty("driver");//获取属性文件中属性值
			URL = properties.getProperty("url");
			UNAME = properties.getProperty("uname");
			UPASS = properties.getProperty("upass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	/**
	 * 远程MySql连接类，使用属性文件
	 * @return
	 */

	private static Connection createConnection() {
		initConfig();//初始化參數
		
		Connection connection=null;
		try {
			Class.forName(DRIVER);//加载并注册驱动
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(URL, UNAME, UPASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	
	/**
	 * 执行增删改操作
	 * @param sql
	 * @return
	 */
	public static boolean executeUpdate(String sql) {
		Connection connection=null;
		Statement statement=null;
		int n=0;
		try {
			connection=createConnection();//调用方法创建连接
			statement=connection.createStatement();
			n=statement.executeUpdate(sql);//执行sql语句，返回受影响的行数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null,statement,connection);//统一关闭
		}
		return n>0?true:false;
		
	}
	
	/**
	 * 执行增删改
	 * @param sql     
	 * @param paramList   
	 * @return
	 */
	public static boolean executeUpdate(String sql,List<Object> paramList) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int n=0;
		try {
			connection=createConnection();
			preparedStatement=connection.prepareStatement(sql);
			if(paramList!=null&&paramList.size()>0) {
				for(int i=0;i<paramList.size();i++) {
					preparedStatement.setObject(i+1, paramList.get(i));
				}
			}
			n=preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(null, preparedStatement, connection);
		}
		return n>0?true:false;
		
	}
	

	/**
	 * 执行查询
	 * @param sql
	 * @return
	 */
	public static ResultSet executeQuery(String sql) {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try {
			connection=createConnection();//调用方法创建连接
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	/**
	 * 执行查询
	 * @param sql
	 * @param paramList
	 * @return
	 */
	public static ResultSet executeQuery(String sql,List<Object> paramList) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=createConnection();//调用方法创建连接
			preparedStatement=connection.prepareStatement(sql);
			
			if(paramList!=null&&paramList.size()>0) {
				for(int i=0;i<paramList.size();i++) {
					preparedStatement.setObject(i+1, paramList.get(i));
				}
			}
			
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	
	/**
	 * 返回满足条件的记录数 
	 * @param sql
	 * @return
	 */
	public static int executeCount(String sql) {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		int n=0;
		try {
			connection=createConnection();//调用方法创建连接
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			while(resultSet.next()) {
				n=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(resultSet, statement, connection);
		}
		return n;
	}
	
	
	
	/**
	 * 返回满足条件的记录数
	 * @param sql
	 * @param paramList
	 * @return
	 */
	public static int executeCount(String sql,List<Object> paramList) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int n=0;
		try {
			connection=createConnection();//调用方法创建连接
			preparedStatement=connection.prepareStatement(sql);
			
			
			if(paramList!=null&&paramList.size()>0) {
				for(int i=0;i<paramList.size();i++) {
					preparedStatement.setObject(i+1, paramList.get(i));
				}
			}
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				n=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(resultSet, preparedStatement, connection);
		}
		return n;
	}
	
	
	
	/**
	 * 统一关闭资源
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void closeAll(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
