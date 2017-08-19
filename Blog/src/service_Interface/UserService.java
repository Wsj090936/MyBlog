package service_Interface;

import domain.User;

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
	public User login(User user);
}
