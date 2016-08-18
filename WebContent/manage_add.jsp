<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		  <h1><a href="./">Simple Bulletin Board</a> <small>Add Article</small></h1>
		</div>
		<%@ include file="manage_menu.jsp" %>
		<!--CK Editor -->
		<script src="js/ckeditor/ckeditor.js"></script>
	    <script src="js/ckeditor/adapters/jquery.js"></script>
		<!--CK Editor -->
		<!-- Response Message -->
		<c:if test="${articleBean.getSuggestion().length() > 0}">
			<script>
				alert('<h:outputText value="#{articleBean.suggestion}" escape="false"/>');
			</script>
			<c:if test="${not articleBean.getErrorStatus()}">
				<script>
					window.location.href="./manage_index.do";
				</script>
			</c:if>
		</c:if>
		<h:form styleClass="form-horizontal"> 
		 <div class="form-group">
			<label for="article_title" class="col-lg-2 control-label">Title</label>
			<div class="col-lg-10">
				<h:inputText value="#{articleBean.title}" styleClass="form-control"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="article_author" class="col-lg-2 control-label">Publisher</label>
			<div class="col-lg-10">
				<h:inputText value="#{articleBean.author}" styleClass="form-control"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="article_file" class="col-lg-2 control-label">Publish Date</label>
			<div class="col-lg-10">
				<h:inputText value="#{articleBean.createTime}" styleClass="form-control auto_selectbar"/>
				(Format: YYYY-MM-DD HH:MM:SS) 
			</div>
		  </div>
		  <div class="form-group">
			<label for="article_author" class="col-lg-2 control-label">Content</label>
			<div class="col-lg-10">
				<h:inputTextarea value="#{articleBean.content}" styleClass="ckeditor"/>
			</div>
		  </div>
		  <div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
					  <h:commandButton value="Submit" 
		                                     action="#{articleBean.addArticle}" styleClass="btn btn-default"/>
			</div>
		  </div>
		</h:form>
	</div>
	<%@ include file="footer.jsp" %>
  </body>
</html>
</f:view>
