package edu.npu.cs532;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleBean implements Serializable{
	// CS532
	// Feng, Pi - Hao
	// 18841

	public String index = "";
	public String title = "";
	public String content = "";
	public String author = "";
	public String views = "";
	public String create_time = "2016-08-18 00:00:00";
	public String status = "";
	public String suggestion = "";
	public boolean has_error = false;
	
    public String getIndex() {
        return (index);
    }

    public void setIndex(String index) {
        this.index = index;
    }
    
    public String getTitle() {
        return (title);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return (content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return (author);
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getViews() {
        return (views);
    }

    public void setViews(String views) {
        this.views = views;
    }
    
    public String getCreateTime() {
        return (create_time);
    }

    public void setCreateTime(String create_time) {
        this.create_time = create_time;
    }
    
    public String getStatus() {
        return (status);
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setSuggestion(String suggestion){
    	this.suggestion = suggestion;
    }
    
    public String getSuggestion(){
    	return (suggestion);
    }
    
    public boolean getErrorStatus(){
    	return has_error;
    }

    public void addArticle() {
        System.out.println("addArticle");
       
       Connection connection = DBHelper.getConnection();
       
       if(getTitle().length() <= 0){
    	   setSuggestion("Please enter article title");
    	   has_error = true;
       }

       if(getAuthor().length() <= 0){
    	   if(!has_error){
	    	   setSuggestion("Please enter article author");
	    	   has_error = true;
    	   }
       }
       
       if(getCreateTime().length() <= 0){
    	   if(!has_error){
	    	   setSuggestion("Please enter article publish time");
	    	   has_error = true;
    	   }
       }

       if(getContent().length() <= 0){
    	   if(!has_error){
	    	   setSuggestion("Please enter article content");
	    	   has_error = true;
    	   }
       }
       
       // set default values
       setViews("0");
       setStatus("1");
       
       if(!has_error){
    	   // start database insert process
    	   String queryString = "";
   	        try {
   	        	
   	        	queryString = "INSERT INTO `bulletin_board`(`title`, `author`, `views`, `content`, `create_time`, `status`)" +
   	        					" VALUES(?, ?, ?, ?, ?, ?)";
   	        	
   				PreparedStatement preparedStatement = connection.prepareStatement(queryString);
   	            preparedStatement.setString(1, getTitle());
   	            preparedStatement.setString(2, getAuthor());
   	            preparedStatement.setString(3, getViews());
   	            preparedStatement.setString(4, getContent());
   	            preparedStatement.setString(5, getCreateTime());
   	            preparedStatement.setString(6, getStatus());
   	            preparedStatement.executeUpdate();
   	            
   	            // setup success message
	    	    setSuggestion("Your article has been added");
	    	    has_error = false;
	    	    
   	        } catch (SQLException ex) {
   	            ex.printStackTrace();

   	    	   setSuggestion("Database Error");
   	    	   has_error = true;
   	        }
       }
       
    }
    
    public void setUpArticle(){
    	try{
	        ReadArticle readArticle = new ReadArticle();
	        ArticleBean updateBean = readArticle.article_bean;
	    	setTitle(updateBean.title);
	    	setAuthor(updateBean.author);
	    	setContent(updateBean.content);
	    	setCreateTime(updateBean.create_time);
	    	setIndex(updateBean.index);
    	}catch(Exception e){
    		
    	}
    }
    
    public void updateArticle() {
        System.out.println("updateArticle");
        
        Connection connection = DBHelper.getConnection();
        
        if(getTitle().length() <= 0){
     	   setSuggestion("Please enter article title");
     	   has_error = true;
        }

        if(getAuthor().length() <= 0){
     	   if(!has_error){
 	    	   setSuggestion("Please enter article author");
 	    	   has_error = true;
     	   }
        }
        
        if(getCreateTime().length() <= 0){
     	   if(!has_error){
 	    	   setSuggestion("Please enter article publish time");
 	    	   has_error = true;
     	   }
        }

        if(getContent().length() <= 0){
     	   if(!has_error){
 	    	   setSuggestion("Please enter article content");
 	    	   has_error = true;
     	   }
        }
        
        if(getIndex().length() <= 0){
     	   if(!has_error){
 	    	   setSuggestion("No article index included");
 	    	   has_error = true;
     	   }
        }
        
        // set default values
        setViews("0");
        setStatus("1");
        
        if(!has_error){
     	   // start database insert process
     	   String queryString = "";
    	        try {
    	        	
    	        	queryString = "UPDATE `bulletin_board` SET `title` = ?, `author` = ?, `views` = ?, `content` = ?, `create_time` = ?"
    	        				+ " WHERE `index` = ?";
    	        	
    				PreparedStatement preparedStatement = connection.prepareStatement(queryString);
    	            preparedStatement.setString(1, getTitle());
    	            preparedStatement.setString(2, getAuthor());
    	            preparedStatement.setString(3, getViews());
    	            preparedStatement.setString(4, getContent());
    	            preparedStatement.setString(5, getCreateTime());
    	            preparedStatement.setString(6, getIndex());
    	            preparedStatement.executeUpdate();
    	            
    	            // setup success message
 	    	    setSuggestion("Your article has been updated");
 	    	    has_error = false;
 	    	    
    	        } catch (SQLException ex) {
    	            ex.printStackTrace();

    	    	   setSuggestion("Database Error");
    	    	   has_error = true;
    	        }
        }
        
     }
    
    public void deleteArticle() {
        System.out.println("deleteArticle");
        
        Connection connection = DBHelper.getConnection();
        
        
        if(getIndex().length() <= 0){
     	   if(!has_error){
 	    	   setSuggestion("No article index included");
 	    	   has_error = true;
     	   }
        }
        
        
        if(!has_error){
     	   // start database insert process
     	   String queryString = "";
    	        try {
    	        	
    	        	queryString = "UPDATE `bulletin_board` SET `status` = '0'"
    	        				+ " WHERE `index` = ?";
    	        	
    				PreparedStatement preparedStatement = connection.prepareStatement(queryString);
    	            preparedStatement.setString(1, getIndex());
    	            preparedStatement.executeUpdate();
    	            
    	            // setup success message
 	    	    setSuggestion("Your article has been deleted");
 	    	    has_error = false;
 	    	    
    	        } catch (SQLException ex) {
    	            ex.printStackTrace();

    	    	   setSuggestion("Database Error");
    	    	   has_error = true;
    	        }
        }
        
     }
}
