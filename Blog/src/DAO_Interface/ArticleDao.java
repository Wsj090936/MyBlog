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
	/**
	 * 根据id找到文章
	 * @param id
	 * @return
	 */
	public Article findArticleById(String id);
	/**
	 * 修改文章
	 * @param article
	 */
	public void editArticle(Article article);
	/**
	 * 删除文章
	 * @param id
	 */
	public void deleteArticle(String id);
	/**
	 * 返回数据库中文章的总数
	 * @return
	 */
	public int count();
	/**
	 * 根据pageSize找到文章
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Article> findArticles(int currentPage, int pageSize);
}
