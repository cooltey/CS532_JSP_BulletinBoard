<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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
		  <h1><a href="./">Simple Bulletin Board</a> <small>Index</small></h1>
		</div>
		<div class="navbar">
			<p class="navbar-text navbar-right"><a href="./login.do" class="btn btn-info manage">Manage</a></p>
			<form class="navbar-form navbar-right" role="search" action="./" method="get">
			  <div class="form-group">
				<input type="text" class="form-control" placeholder="Keyword" value="" name="keyword">
			  </div>
			  <button type="submit" class="btn btn-default">Search</button>
			</form>
		</div>
		<div class="panel panel-default">
			<table class="table table-hover table-striped">
			  <thead>
				<tr>
					<th width="5%"><h:outputText value="#{bulletinBoard.orderByColumn('ID', 'id')}" escape="false"/></th>
					<th width="45%"><h:outputText value="#{bulletinBoard.orderByColumn('Title', 'title')}" escape="false"/></th>
					<th width="10%"><h:outputText value="#{bulletinBoard.orderByColumn('Views', 'views')}" escape="false"/></th>
					<th width="20%"><h:outputText value="#{bulletinBoard.orderByColumn('Published Date', 'date')}" escape="false"/></th>
					<th width="10%"><h:outputText value="#{bulletinBoard.orderByColumn('Publisher', 'author')}" escape="false"/></th>
				</tr>
			  </thead>
			  <tbody>
			  		<c:forEach var="row" items="#{bulletinBoard.getArticleBeans()}">
					<tr>
						<td><h:outputText value="#{row.index}"/></td>
						<td><a href="article.do?id=<h:outputText value="#{row.index}"/>"><h:outputText value="#{row.title}"/></a></td>
						<td><h:outputText value="#{row.views}"/></td>
						<td><h:outputText value="#{row.createTime}"/></td>
						<td><h:outputText value="#{row.author}"/></td>
					</tr>
					</c:forEach>
			  </tbody>
			</table>
		</div>
		
		<h:outputText value="#{bulletinBoard.showPagination()}" escape="false"/>
	</div>
	<%@ include file="footer.jsp" %>
  </body>
</html>
</f:view>
