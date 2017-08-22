package domain;

import java.util.List;

public class PageBean {
	private int currentPage;//当前页面
	private int pageSize;//页面显示条数
	private int count;//数据库中文章的总数
	private int totalPage;//总页面数
	private List<Article> articles;//每页中的文章总数
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticle(List<Article> article) {
		this.articles = article;
	}
	
}
