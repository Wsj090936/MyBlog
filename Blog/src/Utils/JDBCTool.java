package Utils;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;





/**
 * JDBC的操作，包含了连接数据库和释放连接的功能
 * @author wushijia
 *
 */
public class JDBCTool {
	/**
	 * 向数据库中查询数据的通用方法，传入的参数如下
	 * @param con  表示一个已经获取了连接的Connection对象
	 * @param clazz  运行时类
	 * @param sql  SQL语句
	 * @param args 占位符对应的参数
	 * @return
	 */
	public static <T> T select(Connection con,Class<T> clazz,String sql,Object ... args){
		PreparedStatement ps = null;
		ResultSet rs = null;
		T obj = null;//查询所得对象
		
		try {
			ps = con.prepareStatement(sql);
			for(int i = 0;i < args.length;i++){//填充占位符
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();//得到查询的结果集，从而知道查询结果的行数，以及某一行某一列对应的值
			ResultSetMetaData metaData = rs.getMetaData();//该对象可以知道结果集有几列，以及每一列所对应的别名
			Map<String,Object> valueMap = new HashMap<>();//该Map集合保存的是 名字-值的映射
			while(rs.next()){
				for (int i = 0; i < metaData.getColumnCount(); i++) {//遍历查询结果集的每一行，得到名字与值
					String columnLabel = metaData.getColumnLabel(i + 1);//得到别名
					Object columnValue = rs.getObject(i + 1);//得到值
					
					valueMap.put(columnLabel, columnValue);//将映射放入Map集合中
				}
				if(valueMap.size() > 0){//如果Map集合的大小大于0，说明查询到了内容
					obj = clazz.newInstance();//创建对应运行时类的对象
					for(Map.Entry<String, Object> each : valueMap.entrySet()){//遍历Map集合，利用反射对运算时类的属性赋值
						String fieldName = each.getKey();
						Object value = each.getValue();
						Field f = clazz.getDeclaredField(fieldName);
						f.setAccessible(true);
						f.set(obj, value);//为属性赋值
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(rs, null, ps);
		}
		return obj;
		
	}
	/**
	 * 通用的更新操作的方法，传入的参数为sql语句，不为null的Connection对象,填充占位符需要的值
	 * @param con
	 * @param sql
	 * @param args
	 */
	public static void update(Connection con,String sql,Object ... args){
		PreparedStatement ps = null;
		try {
			 ps = con.prepareStatement(sql);
			 for(int i = 0;i < args.length;i++){//遍历数组，填充占位符
				 ps.setObject(i + 1, args[i]);
			 }
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, null, ps);
		}
	}
	/**
	 * 连接数据库
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{//连接数据库
		String driver = null;
		String user = null;
		String password = null;
		String url = null;
		Properties properties = new Properties();
		InputStream in = JDBCTool.class.getClassLoader().getResourceAsStream("jdbc.properties");//利用反射读取配置文件
		
		properties.load(in);
		driver = properties.getProperty("driver");
		user = properties.getProperty("user");
		url = properties.getProperty("jdbcurl");
		password = properties.getProperty("password");
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	/**
	 * 释放数据库连接
	 * @param rs
	 * @param con
	 * @param state
	 */
	public static void release(ResultSet rs , Connection con , Statement state){//关闭数据库连接
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(state != null){
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
