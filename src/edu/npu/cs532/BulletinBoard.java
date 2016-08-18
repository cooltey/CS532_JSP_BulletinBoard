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

public class BulletinBoard implements Serializable{
	// CS532
	// Feng, Pi - Hao
	// 18841 

	public Connection connection;
    public PreparedStatement preparedStatement;
    public ArrayList<ArticleBean> article_beans = new ArrayList<ArticleBean>();
    public ArticleBean article_bean;
    
    public PageController pageController;
    
    
    // request
	String keyword;
	String orderby;
	String ordermode;
	String page;
    
    int pagenationMany = 10; // display per page
    int pagenationDisplay = 5; // display page numbers
    
    // init
    public BulletinBoard(){
    	connection = DBHelper.getConnection();
    	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    	keyword = request.getParameter("keyword");
    	orderby = request.getParameter("orderby");
    	ordermode = request.getParameter("ordermode");
    	page = request.getParameter("page");
    
    	getListData(page, keyword, orderby, ordermode);
    }
    
    // get article beans (article list)
    public ArrayList<ArticleBean> getArticleBeans(){
    	return (article_beans);
    }
    
    // show order by column
    public String orderByColumn(String display_title, String this_column){
    	if(this_column.equals(orderby)){
    		if(ordermode.equals("desc")){
    	    	return "<a href=\"?orderby="+ this_column +"&ordermode=asc\">" + display_title + "<span class=\"glyphicon glyphicon-chevron-down\"></span></a>";
    		}else{

    	    	return "<a href=\"?orderby="+ this_column +"&ordermode=desc\">" + display_title + "<span class=\"glyphicon glyphicon-chevron-up\"></span></a>";
    		}
    	}
    	return "<a href=\"?orderby="+ this_column +"&ordermode=desc\">" + display_title + "</a>";
    }
    
    // get pagination
    public String showPagination(){
    	return pageController.showPage();
    }

    // get pagination
    public String showPaginationOnAdmin(){
    	pageController.pageNameURI = "./manage_index.do?";
    	return pageController.showPage();
    }
    
    // get list data
    public void getListData(String page, String keyword, String orderby, String ordermode){
    	
        String queryString = "";
        String keywordString = "";
        String keywordUrl = "";
        String orderByString = " ORDER BY `index` DESC ";
        String orderByUrl = "";
        try {
        	
        	// keyword
        	if(keyword != null){
        		keywordString = " AND(`title` LIKE '%"+ keyword +"%' OR "
        						+" `content` LIKE '%"+ keyword +"%' OR"
        						+" `author` LIKE '%"+ keyword + "%' ) ";
        		keywordUrl = "keyword=" + keyword + "&";
        	}
        	
        	// order by
        	if(orderby != null){
	        	if(orderby.equals("id")){
	        		orderByString = "ORDER BY `index`";
	        	}else if(orderby.equals("title")){
	        		orderByString = "ORDER BY `title`";
	        	}else if(orderby.equals("views")){
	        		orderByString = "ORDER BY `views`";
	        	}else if(orderby.equals("date")){
	        		orderByString = "ORDER BY `create_time`";
	        	}else if(orderby.equals("author")){
	        		orderByString = "ORDER BY `author`";
	        	}else{
	        		// default
	        		orderByString = " `create_time`";
	        	}
	        	
	        	if(ordermode.equals("desc")){
	        		orderByString = orderByString + " DESC ";
	        	}else{
	        		orderByString = orderByString + " ASC ";
	        	}
	        	

        		orderByUrl = "orderby=" + orderby + "&ordermode=" + ordermode + "&";
        	}
        	
        	// get total 
        	queryString = "SELECT COUNT(`index`) AS `count` FROM `bulletin_board` "
	                    + "WHERE `status` = '1' "
	                    + keywordString
	                    + orderByString;
		
        	preparedStatement = connection.prepareStatement(queryString);
            ResultSet rowCount = preparedStatement.executeQuery();
            int totalRows = 0;
            while(rowCount.next()){
            	totalRows = rowCount.getInt("count");
            }
            
            System.out.println("TOTAL ROW" + totalRows);

        	int getPage = 0;
            if(page != null){
            	if(page.length() > 0){
            		getPage = Integer.parseInt(page);
            	}
            }
            
        	pageController = new PageController(getPage, pagenationMany, pagenationDisplay, totalRows, "./?"+keywordUrl+orderByUrl);
        	
        	queryString = "SELECT * FROM `bulletin_board` "
		                    + "WHERE `status` = '1' "
		                    + keywordString
		                    + orderByString
		                    + "LIMIT " + pageController.pageStart + "," + pageController.pageMany;
        	
			preparedStatement = connection.prepareStatement(queryString);

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
            	
            	// add into list
            	article_beans.add(articleBean);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
   
}
