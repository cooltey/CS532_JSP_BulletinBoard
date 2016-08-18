<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<!DOCTYPE html>
<html lang="utf-8">
  <head>			    
  	<title>Simple Bulletin Board - CS532(H)</title>
	<%@ include file="../../header.jsp" %>
  </head>
  <body>
	<div class="container">
		<div class="page-header">
		  <h1><a href="./">Simple Bulletin Board</a> <small>Login</small></h1>
		</div>
		<div class="panel panel-default login">
			<div class="panel-body">
				<div class="alert alert-danger">
					<li>Bad UserName, please use <h:outputText value="#{loginBean.suggestion.name }"/> as the UserName</li>
				</div>
			</div>
			<div class="panel-footer">
				<button class="btn btn-info btn-block" onclick="window.history.back();">Go Back</button>
			</div>
		</div>
	</div>
	<%@ include file="../../footer.jsp" %>
  </body>
</html>
</f:view>
