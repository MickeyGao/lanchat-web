package service;

import java.util.List;

import model.UserId;

import dao.UserIdDao;

public class UserIdManager {
	private UserIdDao useridDao;
	
	public List<UserId> getAllUserIds(){
		useridDao = new UserIdDao();
		return useridDao.ListAll();
	}
	
	public void addUserId(UserId userId){
		useridDao = new UserIdDao();
		useridDao.save(userId);
	}
}
