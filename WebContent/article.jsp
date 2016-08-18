<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html lang="utf-8">
  <head>			    
  	<title>Simple Bulletin Board - CS532(H)</title>
	<%@ include file="header.jsp" %>
  </head>
  <body>
	<div class="container">
		<div class="page-header">
		  <h1><a href="./">Simple Bulletin Board</a> <small>Read Article</small></h1>
		</div>
		<div class="navbar">
			<p class="navbar-text navbar-right"><a href="./" class="btn btn-info manage">Back to list</a></p>
		</div>
		<div class="panel panel-default">
		  <div class="panel-heading">
			<h3 class="panel-title article-title"><h:outputText value="#{readArticle.articleBean.title}"/></h3>
		  </div>
		  <div class="panel-body article"><h:outputText value="#{readArticle.articleBean.content}" escape="false"/></div>
		  <ul class="list-group article-footer">
			<li class="list-group-item"><i class="glyphicon glyphicon-pencil">&nbsp;</i><b>Publisher:</b> <h:outputText value="#{readArticle.articleBean.author}"/><br>
			<i class="glyphicon glyphicon-tint">&nbsp;</i><b>Published Date:</b> <h:outputText value="#{readArticle.articleBean.createTime}"/>
			<span class="pull-right"><i class="glyphicon glyphicon-eye-open">&nbsp;</i> <b>View Times:</b> <h:outputText value="#{readArticle.articleBean.views}"/></span></li>
		  </ul>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
  </body>
</html>
</f:view>
