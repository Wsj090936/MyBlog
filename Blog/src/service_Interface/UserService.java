package service_Interface;

import domain.User;

public interface UserService {
	/**
	 * ע�ᣬ����û���Ϣ
	 * @param user
	 * @throws Exception
	 */
	public void register(User user) throws Exception;
	/**
	 * ���ݱ��е��û�������������ݿ��в��Ҷ�Ӧ����
	 * @param user
	 * @return
	 */
	public User login(User user);
}
