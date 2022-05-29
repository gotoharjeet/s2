package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dto.User;
import com.util.ConnectionManagerImpl;

public class UserDaoImp implements UserDao{
	private Connection connection;
	
	public UserDaoImp()
	{
	  connection=new ConnectionManagerImpl().getConnection();
	  
	}
	@Override
	public boolean validateUser(User user) {
		boolean isUserValid=false;
		String query="select * from userdetails where user_name=? and password=?";		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			
			ResultSet resultset=preparedStatement.executeQuery();
			
			if(resultset.next() == true)
			{
				isUserValid=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUserValid;
	}

}
