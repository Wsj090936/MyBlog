package service_Interface;

import domain.User;
import exception.UserExistException;
import exception.UsersException;

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
	public User login(User user) throws UsersException;
	/**
	 * ����ע��ʱ������û��������ݿ��в����Ƿ�����֮��ͬ���û�������
	 * @param username
	 * @return
	 * @throws UserExistException
	 */
	public boolean findUserByName(String username) throws UserExistException;
	/**
	 * �����û������û�
	 * @param username
	 * @return
	 */
	public boolean findUserByName1(String username);
}
