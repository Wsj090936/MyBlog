package DAO_Implements;

import java.sql.Connection;
import java.util.List;

import DAO_Interface.ArticleDao;
import Utils.JDBCTool;
import Utils.UUIDUtil;
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
			String sql = "INSERT INTO ARTICLE(id,username,title,date,content) VALUES(?,?,?,?,?)";
			JDBCTool.update(con, sql, UUIDUtil.getUUID(),article.getUsername(),article.getTitle(),article.getDate(),article.getContent());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
	}
	public Article findArticleById(String id){
		Connection con = null;
		try {
			con = JDBCTool.getConnection();
			String sql = "SELECT * FROM article WHERE id=?";
			Article article = JDBCTool.select(con, Article.class, sql, id);
			return article;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
		return null;
	}

	@Override
	public void editArticle(Article article) {
		Connection con = null;
		try {
			con = JDBCTool.getConnection();
			String sql = "UPDATE article SET title=?,date=?,content=? WHERE id=?";
			JDBCTool.update(con, sql, article.getTitle(),article.getDate(),article.getContent(),article.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
		
	}

	@Override
	public void deleteArticle(String id) {
		Connection con = null;
		try {
			con = JDBCTool.getConnection();
			String sql = "DELETE FROM article WHERE id=?";
			JDBCTool.update(con, sql, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTool.release(null, con, null);
		}
	}

	@Override
	public int count() {
		String sql = "SELECT count(*) FROM article";
		int count = JDBCTool.getvalues(sql);
		return count;
	}

	@Override
	public List<Article> findArticles(int currentPage, int pageSize) {
		String sql = "SELECT * FROM article LIMIT ?,?";
		List<Article> list = JDBCTool.getForList(Article.class, sql, (currentPage-1)*pageSize,pageSize);
		return list;
	}
}
