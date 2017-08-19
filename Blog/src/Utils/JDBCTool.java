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
 * JDBC�Ĳ������������������ݿ���ͷ����ӵĹ���
 * @author wushijia
 *
 */
public class JDBCTool {
	/**
	 * �����ݿ��в�ѯ���ݵ�ͨ�÷���������Ĳ�������
	 * @param con  ��ʾһ���Ѿ���ȡ�����ӵ�Connection����
	 * @param clazz  ����ʱ��
	 * @param sql  SQL���
	 * @param args ռλ����Ӧ�Ĳ���
	 * @return
	 */
	public static <T> T select(Connection con,Class<T> clazz,String sql,Object ... args){
		PreparedStatement ps = null;
		ResultSet rs = null;
		T obj = null;//��ѯ���ö���
		
		try {
			ps = con.prepareStatement(sql);
			for(int i = 0;i < args.length;i++){//���ռλ��
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();//�õ���ѯ�Ľ�������Ӷ�֪����ѯ������������Լ�ĳһ��ĳһ�ж�Ӧ��ֵ
			ResultSetMetaData metaData = rs.getMetaData();//�ö������֪��������м��У��Լ�ÿһ������Ӧ�ı���
			Map<String,Object> valueMap = new HashMap<>();//��Map���ϱ������ ����-ֵ��ӳ��
			while(rs.next()){
				for (int i = 0; i < metaData.getColumnCount(); i++) {//������ѯ�������ÿһ�У��õ�������ֵ
					String columnLabel = metaData.getColumnLabel(i + 1);//�õ�����
					Object columnValue = rs.getObject(i + 1);//�õ�ֵ
					
					valueMap.put(columnLabel, columnValue);//��ӳ�����Map������
				}
				if(valueMap.size() > 0){//���Map���ϵĴ�С����0��˵����ѯ��������
					obj = clazz.newInstance();//������Ӧ����ʱ��Ķ���
					for(Map.Entry<String, Object> each : valueMap.entrySet()){//����Map���ϣ����÷��������ʱ������Ը�ֵ
						String fieldName = each.getKey();
						Object value = each.getValue();
						Field f = clazz.getDeclaredField(fieldName);
						f.setAccessible(true);
						f.set(obj, value);//Ϊ���Ը�ֵ
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
	 * ͨ�õĸ��²����ķ���������Ĳ���Ϊsql��䣬��Ϊnull��Connection����,���ռλ����Ҫ��ֵ
	 * @param con
	 * @param sql
	 * @param args
	 */
	public static void update(Connection con,String sql,Object ... args){
		PreparedStatement ps = null;
		try {
			 ps = con.prepareStatement(sql);
			 for(int i = 0;i < args.length;i++){//�������飬���ռλ��
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
	 * �������ݿ�
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{//�������ݿ�
		String driver = null;
		String user = null;
		String password = null;
		String url = null;
		Properties properties = new Properties();
		InputStream in = JDBCTool.class.getClassLoader().getResourceAsStream("jdbc.properties");//���÷����ȡ�����ļ�
		
		properties.load(in);
		driver = properties.getProperty("driver");
		user = properties.getProperty("user");
		url = properties.getProperty("jdbcurl");
		password = properties.getProperty("password");
		
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
	/**
	 * �ͷ����ݿ�����
	 * @param rs
	 * @param con
	 * @param state
	 */
	public static void release(ResultSet rs , Connection con , Statement state){//�ر����ݿ�����
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
