<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<c:if test="${param.username.equals('cs532') and param.password.equals('cs532')}" >
    <c:set var="user" value="cs532" scope="session" />
    <c:redirect url="manage_index.jsp" />
</c:if>
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
		  <h1><a href="./">Simple Bulletin Board</a> <small>Login</small></h1>
		</div>
		<div class="navbar">
			<p class="navbar-text navbar-right"><a href="./" class="btn btn-info manage">Back to list</a></p>
		</div>
		<div class="panel panel-default login">
			<div class="panel-body">
		         <h:form styleClass="form-horizontal"> 
				  <div class="form-group">
					<label for="admin_username" class="col-lg-2 control-label">UserName</label>
					<div class="col-lg-10">
						<h:inputText value="#{loginBean.username}" styleClass="form-control"/>
					</div>
				  </div>
				  <div class="form-group">
					<label for="admin_password" class="col-lg-2 control-label">Password</label>
					<div class="col-lg-10">
						<h:inputSecret value="#{loginBean.password}" styleClass="form-control"/>
					</div>
				  </div>
				  <div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
					  <h:commandButton value="Login" 
		                                     action="#{loginBean.login}" styleClass="btn btn-default"/>
					</div>
				  </div>
				</h:form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>
  </body>
</html>
</f:view>
