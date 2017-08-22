package domain;

import java.util.List;

public class PageBean {
	private int currentPage;//��ǰҳ��
	private int pageSize;//ҳ����ʾ����
	private int count;//���ݿ������µ�����
	private int totalPage;//��ҳ����
	private List<Article> articles;//ÿҳ�е���������
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
