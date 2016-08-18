package edu.npu.cs532;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class ReadArticle implements Serializable{
	// CS532
	// Feng, Pi - Hao
	// 18841

	public Connection connection;
    public PreparedStatement preparedStatement;
    public ArticleBean article_bean;
    
    // init
    public ReadArticle(){
    	connection = DBHelper.getConnection();
    	// set bean
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	String id = request.getParameter("id");
    	setArticleBean(id);
    }
    
    
    public void setArticleBean(String id){
    	System.out.println("setArticleBean");
    	getArticleData(id);
    }

    // get article bean (read article)
    public ArticleBean getArticleBean(){
    	System.out.println("getArticleBean");
    	return (article_bean);
    }

    
    // update views counts
    public void updateView(String id){
    	System.out.println("updateView");
    	 String queryString = "";
         if(id != null){
 	        try {
 	        	
 	        	queryString = "UPDATE `bulletin_board` SET `views` = `views` + 1 "
 	        				  + "WHERE `index` = ?";
 	        	
 				preparedStatement = connection.prepareStatement(queryString);
 	            preparedStatement.setString(1, id);
 	            preparedStatement.executeUpdate();
 	        } catch (SQLException ex) {
 	            ex.printStackTrace();
 	        }
         }
    }

    // get list data
    public void getArticleData(String id){
    	
        String queryString = "";
        if(id != null){
	        try {
	        	
	        	// update view count
	        	updateView(id);
	        	
	        	queryString = "SELECT * FROM `bulletin_board` "
			                    + "WHERE `status` = '1' "
			                    + "AND `index` = ?";
	        	
				preparedStatement = connection.prepareStatement(queryString);
	            preparedStatement.setString(1, id);
	
	            System.out.println(queryString);
	
	            ResultSet row = preparedStatement.executeQuery();
	
	            // use while loop to display
	            while(row.next()){
	            	
	            	ArticleBean articleBean = new ArticleBean();
	            	articleBean.setIndex(row.getString("index"));
	            	articleBean.setTitle(row.getString("title"));
	            	articleBean.setContent(row.getString("content"));
	            	articleBean.setViews(row.getString("views"));
	            	articleBean.setAuthor(row.getString("author"));
	            	articleBean.setCreateTime(row.getString("create_time"));
	            	articleBean.setStatus(row.getString("status"));
	            	
	            	this.article_bean = articleBean;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
        }
        
    }
}
