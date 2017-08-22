package service_Implements;

import java.sql.Connection;
import java.util.List;

import DAO_Implements.ArticleDaoImpl;
import DAO_Interface.ArticleDao;
import Utils.JDBCTool;
import domain.Article;
import domain.PageBean;
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
	@Override
	public Article findArticleById(String id) {
		return ad.findArticleById(id);
	}
	@Override
	public void editArticle(Article article) {
		ad.editArticle(article);	
	}
	@Override
	public void deleteArticle(String id) {
		ad.deleteArticle(id);
	}
	@Override
	public PageBean findArticlesPage(int currentPage, int pageSize) {
		int count = ad.count();//数据库中的文章总数
		int totalPage = (int) Math.ceil(count*1.0/pageSize);//向上取整，表示总页数
		List<Article> articles = ad.findArticles(currentPage,pageSize);
		
		PageBean pb = new PageBean();//将取到的数据疯转如PageBean对象中
		pb.setArticle(articles);
		pb.setCount(count);
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		return pb;
	}
}
