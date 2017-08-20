package domain;

import java.util.HashMap;
import java.util.Map;

//������֤�����ݵ���
public class UserForm {
	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	
	private Map<String,String> msgMap = new HashMap<>(); 
	public boolean checked(){
		if("".equals(username)){
			msgMap.put("username", "�û�������Ϊ��");
		}
		if("".equals(password)){
			msgMap.put("password", "���벻��Ϊ��");
		}
		if("".equals(repassword)){
			msgMap.put("repassword", "���ٴ���������");
		}
		if(!repassword.equals(password)){
			msgMap.put("repassword", "������������벻һ��");
		}
		if("".equals(email)){
			msgMap.put("email", "����������");
		}else if(!email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
			//
			msgMap.put("email", "����ĸ�ʽ����ȷ");
		}
		return msgMap.isEmpty();
	}
	
	public String getRepassword() {
		return repassword;
	}



	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Map<String, String> getMsgMap() {
		return msgMap;
	}
	public void setMsgMap(Map<String, String> msgMap) {
		this.msgMap = msgMap;
	}
	
}
