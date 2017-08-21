package DAO_Implements;

import java.sql.Connection;
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

	@Override
	public void publishArticle(Article article) {
		Connection con = null;
		try {
			con = JDBCTool.getConnection();
			String sql = "INSERT INTO ARTICLE(username,title,date,content) VALUES(?,?,?,?)";
			JDBCTool.update(con, sql, article.getUsername(),article.getTitle(),article.getDate(),article.getContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
	}

}
