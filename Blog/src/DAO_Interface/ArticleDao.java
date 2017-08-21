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
}
