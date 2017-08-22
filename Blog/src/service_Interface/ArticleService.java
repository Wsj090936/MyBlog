package service_Interface;

import java.util.List;

import domain.Article;
import domain.PageBean;

public interface ArticleService {
	/**
	 * �����û������Ҹ��û��������������
	 * @param username
	 * @return
	 */
	public List<Article> findAllArticle();
	/**
	 * ��������
	 * @param article
	 */
	public void publishArticle(Article article);
	/**
	 * ����id�ҵ�����
	 * @param id
	 */
	public Article findArticleById(String id);
	/**
	 * �޸�����
	 * @param article
	 */
	public void editArticle(Article article);
	/**
	 * ɾ������
	 * @param id
	 */
	public void deleteArticle(String id);
	/**
	 * �ҵ�ÿҳ��ʾ�����ݣ�����һ��PageBean����
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean findArticlesPage(int currentPage, int pageSize);
}
