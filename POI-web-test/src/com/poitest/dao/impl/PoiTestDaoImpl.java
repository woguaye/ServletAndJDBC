package com.poitest.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.poitest.dao.PoiTestDao;

public class PoiTestDaoImpl implements PoiTestDao {

	@Override
	public String login(String username) {
		String password = "";
		String sql = "select PASSWORD from user where USERNAME = ?";
		try {
			//加载数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获取数据库连接
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.155:3306/user", "root", "123456");
			//创建连接状态
			PreparedStatement prepareStatement = connection.prepareStatement(sql);//此处有占位符号
			//设置sql中的参数
			prepareStatement.setString(1, username);
			//对数据库进行操作,返回结果
			ResultSet resultSet = prepareStatement.executeQuery();
		    password = resultSet.getString("PASSWORD");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return password;
	}

}
