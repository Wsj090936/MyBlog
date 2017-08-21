package service_Implements;

import java.util.List;

import DAO_Implements.ArticleDaoImpl;
import DAO_Interface.ArticleDao;
import domain.Article;
import service_Interface.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	ArticleDao ad = new ArticleDaoImpl();
	/**
	 * 根据用户名查找该用户发表的所有文章
	 * @param username
	 * @return
	 */
	public List<Article> findAllArticle(){
		return ad.findAllArticles();
	}
	public void publishArticle(Article article){
		ad.publishArticle(article);
	}
}
