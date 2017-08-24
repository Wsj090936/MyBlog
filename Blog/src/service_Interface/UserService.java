package service_Interface;

import domain.User;
import exception.UserExistException;
import exception.UsersException;

public interface UserService {
	/**
	 * 注册，添加用户信息
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	/**
	 * 根据表单中的用户名和密码从数据库中查找对应对象
	 * @param user
	 * @return
	 */
	public User login(User user) throws UsersException;
	/**
	 * 根据注册时填入的用户名在数据库中查找是否有与之相同的用户名存在
	 * @param username
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String username) throws UserExistException;
	/**
	 * 根据用户名找用户
	 * @param username
	 * @return
	 */
	public boolean findUserByName1(String username);
}
