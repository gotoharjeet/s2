package com.service;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.dto.User;

public class UserServiceImp implements UserService {
	private UserDao dao;
	
	
	public UserServiceImp() {
	    dao=new UserDaoImp();	
	}


	@Override
	public boolean validateUser(User user) {
		return dao.validateUser(user);
	}

	

}
