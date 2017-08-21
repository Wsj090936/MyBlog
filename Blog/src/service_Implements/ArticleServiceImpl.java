package service_Implements;

import java.util.List;

import DAO_Implements.ArticleDaoImpl;
import DAO_Interface.ArticleDao;
import domain.Article;
import service_Interface.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	ArticleDao ad = new ArticleDaoImpl();
	/**
	 * �����û������Ҹ��û��������������
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
