package DAO_Interface;

import java.util.List;

import domain.Article;

public interface ArticleDao {
	/**
	 * �����û������Ҹ��û��������������
	 * @param username
	 * @return
	 */
	public List<Article> findAllArticles();
	/**
	 * �������
	 * @param article
	 */
	public void publishArticle(Article article);
	/**
	 * ����id�ҵ�����
	 * @param id
	 * @return
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
	 * �������ݿ������µ�����
	 * @return
	 */
	public int count();
	/**
	 * ����pageSize�ҵ�����
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Article> findArticles(int currentPage, int pageSize);
}
