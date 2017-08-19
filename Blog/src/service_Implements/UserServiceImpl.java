package service_Implements;

import DAO_Implements.UserDaoimpl;
import DAO_Interface.UserDao;
import domain.User;
import service_Interface.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao= new UserDaoimpl(); 
	@Override
	public void register(User user) throws Exception {
		userDao.addUser(user);
	}
	@Override
	public User login(User user) {
		User u = null;
		u = userDao.findUser(user);
		return u;
	}

}
