package service_Implements;

import DAO_Implements.UserDaoimpl;
import DAO_Interface.UserDao;
import domain.User;
import exception.UserExistException;
import exception.UsersException;
import service_Interface.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao= new UserDaoimpl(); 
	@Override
	public void register(User user) throws Exception {
		userDao.addUser(user);
	}
	@Override
	public User login(User user) throws UsersException{
		User u = null;
			u = userDao.findUser(user);
			if(u == null){//���û�鵽�����׳�һ���Զ����쳣
				throw new UsersException("�û������������");
			}
		return u;
	}
	@Override
	public boolean findUserByName(String username) throws UserExistException {
		boolean exist = userDao.findUserByName(username);
		if(exist){
			throw new UserExistException("���û��Ѵ���");
		}
		return exist;
	}
	@Override
	public boolean findUserByName1(String username) {
		// TODO Auto-generated method stub
		return userDao.findUserByName(username);
	}

}
