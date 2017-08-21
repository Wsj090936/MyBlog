package domain;

import java.io.Serializable;

/**
 * ÎÄÕÂÀà
 * @author wushijia
 *
 */
public class Article implements Serializable{
	private String id;
	private String title;
	private String date;
	private String username;
	private String content;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", date=" + date + ", username=" + username + ", content="
				+ content + "]";
	}
	
}
