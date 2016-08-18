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
		  <h1><a href="./">Simple Bulletin Board</a> <small>Manage</small></h1>
		</div>
		<%@ include file="manage_menu.jsp" %>
		<div class="panel panel-default">
			<table class="table table-hover table-striped">
			  <thead>
				<tr>
					<th width="5%"><h:outputText value="#{bulletinBoard.orderByColumn('ID', 'id')}" escape="false"/></th>
					<th width="45%"><h:outputText value="#{bulletinBoard.orderByColumn('Title', 'title')}" escape="false"/></th>
					<th width="10%"><h:outputText value="#{bulletinBoard.orderByColumn('Views', 'views')}" escape="false"/></th>
					<th width="20%"><h:outputText value="#{bulletinBoard.orderByColumn('Published Date', 'date')}" escape="false"/></th>
					<th width="10%"><h:outputText value="#{bulletinBoard.orderByColumn('Publisher', 'author')}" escape="false"/></th>
					<th width="5%">Manage</th>
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
						<td><a href="manage_edit.do?id=<h:outputText value="#{row.index}"/>" class="btn btn-success">UPDATE</a></td>
					</tr>
					</c:forEach>
			  </tbody>
			</table>
		</div>
		
		<h:outputText value="#{bulletinBoard.showPaginationOnAdmin()}" escape="false"/>
	</div>
	<%@ include file="footer.jsp" %>
  </body>
</html>
</f:view>
