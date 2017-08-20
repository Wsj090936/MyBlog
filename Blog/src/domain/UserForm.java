package domain;

import java.util.HashMap;
import java.util.Map;

//用来验证表单数据的类
public class UserForm {
	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	
	private Map<String,String> msgMap = new HashMap<>(); 
	public boolean checked(){
		if("".equals(username)){
			msgMap.put("username", "用户名不能为空");
		}
		if("".equals(password)){
			msgMap.put("password", "密码不能为空");
		}
		if("".equals(repassword)){
			msgMap.put("repassword", "请再次输入密码");
		}
		if(!repassword.equals(password)){
			msgMap.put("repassword", "两次输入的密码不一致");
		}
		if("".equals(email)){
			msgMap.put("email", "请输入邮箱");
		}else if(!email.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
			//
			msgMap.put("email", "邮箱的格式不正确");
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
