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
	<script>
	    setTimeout(function () {
	       window.location.href = "./manage_index.do"; 
	    }, 3000);  
	</script>
  </head>
  <body>
	<div class="container">
		<div class="page-header">
		  <h1><a href="./">Simple Bulletin Board</a> <small>Login</small></h1>
		</div>
		<div class="panel panel-default login">
			<div class="panel-body">
				<div class="alert alert-success">
					<li>UserName and Password are matched!</li>
					<li>Redirecting to the management page in 3 seconds...</li>
				</div>
				<div class="anim">
					<img src="./images/loading.gif" class="loading_anim"/>
				</div>
			</div>
			<div class="panel-footer">
				<button class="btn btn-info btn-block" onclick="window.location.href='./manage_index.do';">Click here if page does not redirect</button>
			</div>
		</div>
	</div>
	<%@ include file="../../footer.jsp" %>
  </body>
</html>
</f:view>
