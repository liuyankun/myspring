package com.lyk.myspring.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyk.myspring.common.BaseService;
import com.lyk.myspring.user.dao.IUserDao;
import com.lyk.myspring.user.model.User;

@Service("userService") 
public class UserService<User> extends BaseService<User>{
	@Autowired	
	private IUserDao<User> userDao;
	
	@Override
	public IUserDao<User> getDao(){
		return userDao;
	}	
	public User getUserById(int userId) {   
	        return userDao.selectByPrimaryKey(userId); 
	}
	public List<String> getPermissionByUsername(String name){
		return userDao.getPermissionByUsername(name);
	}
	
	public User getUserByName(String name){
		System.out.println("------调用了UserService-----");
		User user = userDao.selectByUsername(name);
		return user;
	}
	
}
