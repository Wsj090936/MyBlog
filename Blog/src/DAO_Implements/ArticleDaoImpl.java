package DAO_Implements;

import java.util.List;

import DAO_Interface.ArticleDao;
import Utils.JDBCTool;
import domain.Article;

public class ArticleDaoImpl implements ArticleDao{

	@Override
	public List<Article> findAllArticles() {
		String sql = "SELECT * FROM article";
		List<Article> articles = JDBCTool.getForList(Article.class, sql);
		return articles;
	}

}
