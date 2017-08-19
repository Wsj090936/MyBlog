package DAO_Implements;

import java.sql.Connection;

import DAO_Interface.UserDao;
import Utils.JDBCTool;
import domain.User;

public class UserDaoimpl implements UserDao {

	@Override
	public void addUser(User user) throws Exception {
		Connection con = null;
		
		try {
			con = JDBCTool.getConnection();
			String sql = "INSERT INTO USER(username,password,email) VALUES(?,?,?)";
			JDBCTool.update(con, sql, user.getUsername(),user.getPassword(),user.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
	}

	@Override
	public User findUser(User user) {
		Connection con = null;
		User u = null;
		try {
			con = JDBCTool.getConnection();
			String sql = "SELECT * FROM USER WHERE username=? AND password=?";
			u = JDBCTool.select(con, User.class, sql, user.getUsername(),user.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
		return u;
	}

}
