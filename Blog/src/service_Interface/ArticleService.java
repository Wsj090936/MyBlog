package service_Interface;

import java.util.List;

import domain.Article;
import domain.PageBean;

public interface ArticleService {
	/**
	 * 根据用户名查找该用户发表的所有文章
	 * @param username
	 * @return
	 */
	public List<Article> findAllArticle();
	/**
	 * 发表文章
	 * @param article
	 */
	public void publishArticle(Article article);
	/**
	 * 根据id找到文章
	 * @param id
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
	 * 找到每页显示的数据，返回一个PageBean对象
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean findArticlesPage(int currentPage, int pageSize);
}
