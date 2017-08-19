package DAO_Interface;

import domain.User;

public interface UserDao {
	/**
	 * 添加用户
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	/**
	 * 根据表单数据寻找数据库中与之相匹配的信息
	 * @param user
	 * @return
	 */
	public User findUser(User user);
}
