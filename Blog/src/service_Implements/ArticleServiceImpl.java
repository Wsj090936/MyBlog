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
		int count = ad.count();//���ݿ��е���������
		int totalPage = (int) Math.ceil(count*1.0/pageSize);//����ȡ������ʾ��ҳ��
		List<Article> articles = ad.findArticles(currentPage,pageSize);
		
		PageBean pb = new PageBean();//��ȡ�������ݷ�ת��PageBean������
		pb.setArticle(articles);
		pb.setCount(count);
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		return pb;
	}
}
