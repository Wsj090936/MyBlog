package DAO_Interface;

import java.util.List;

import domain.Article;

public interface ArticleDao {
	/**
	 * 根据用户名查找该用户发表的所有文章
	 * @param username
	 * @return
	 */
	public List<Article> findAllArticles();
	/**
	 * 添加文章
	 * @param article
	 */
	public void publishArticle(Article article);
}
