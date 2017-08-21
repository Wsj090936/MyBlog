package service_Interface;

import java.util.List;

import domain.Article;

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
}
