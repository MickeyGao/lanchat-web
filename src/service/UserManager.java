package service;

import java.util.List;

import model.User;
import dao.UserDao;

public class UserManager {
private UserDao userDao;
	
	public List<User> getAllUsers(){
		userDao = new UserDao();
		return userDao.ListAll();
	}
	
	public void addUser(User user){
		userDao = new UserDao();
		userDao.save(user);
	}
	
	public User login(String id, String password){
		userDao = new UserDao();
		return userDao.login(id, password);
	}
}
