package edu.npu.cs532;

import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageController{
	public int pageVar = 0;
	public int pageMany = 10;
	public int pageStart = 0;
	public int pageDisplay = 5;
	public String pageNameURI;
	public int pageTotal;
	
	public PageController(int page, int many, int display, int total, String pagename){
		int start;
		if(page == 0 || page == 1 || page <= 0){
			start = 0;
		}else{
			start = (page-1)*many;
		}
		
		pageVar 	= page;
		pageMany 	= many;
		pageStart 	= start;
		pageDisplay = display;
		pageTotal 	= total;
		pageNameURI = pagename;
		
	}
	
	
	public String showPage(){
		int total 			= (int) Math.ceil(pageTotal/pageMany);
		int now				= pageVar;
		int displayNum 		= pageDisplay;
		int many			= pageMany;
		String currentPage 	= pageNameURI;
		
		// config
		int new_now 		= 0;
		int head_page		= 0;
		int head			= 0;
		int last			= 0;
		
		String outputString = "<ul class=\"pagination pull-right\">";
		
		if(now == 0 || now <= 0 || now == 1){
			new_now = 1;
		}else{
			new_now = now;
			head_page = new_now - 1;
		}
		
		if((now - new_now) > displayNum){
			head = now-displayNum;
			last = total-displayNum;
		}
		
		if(now > 1 && ((total-last)+1) > displayNum && total > displayNum){
			outputString = outputString + " <li><a href={$current_page}page=1>HEAD...</a></li>";
		}
		
		boolean totalDisplay = false;
		for(int i = (1+head); i <= ((total-last)+1); i++){
			if(!((i-new_now) > displayNum || (new_now - i) > displayNum)){
				if(i == new_now){
					outputString = outputString + "<li class=\"active\"><span>"+ i +"<span class=\"sr-only\">(current)</span></span></li>";
				}else{
					outputString = outputString + "<li><a href="+ currentPage +"page="+ i +">"+ i +"</a></li>";
					if(i == total || i == (total-1)){
						totalDisplay = true;
					}
				}
			}
		}
		
		if(now != total && total > displayNum && totalDisplay == false){
			outputString = outputString + " <li><a href={$current_page}page="+ total +">...TAIL</a></li>";
		}
		
		outputString = outputString + "</ul>";
		
		return outputString;
	}
}
