package DAO_Interface;

import domain.User;

public interface UserDao {
	/**
	 * ����û�
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception;
	/**
	 * ���ݱ�����Ѱ�����ݿ�����֮��ƥ�����Ϣ
	 * @param user
	 * @return
	 */
	public User findUser(User user);
}
