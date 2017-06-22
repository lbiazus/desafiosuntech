<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />
		<title>Users Registration</title>
	</head>
	<body>
	
		<div class="jumbotron">
			
			<p class="bg-${messageType} text-center">
				<label>${message}</label>
			</p>
			
			<h3 class="text-center">Users Registration</h3><br>
			
			<s:url value="/users/save" var="action" />

			<sf:form method="POST" modelAttribute="user" action="${action}" cssClass="form-horizontal">
				<div class="form-group">
					<sf:hidden path="id" />
					<label for="userName" class="col-sm-4 control-label">User Name:</label>
					<div class="col-sm-4">
				    	<sf:input path="userName" cssClass="form-control" maxlength="20"/>
				    </div>
			  	</div>
			
				<div class="form-group">
					<label for="password" class="col-sm-4 control-label">Password:</label>
					<div class="col-sm-4">
				    	<sf:password path="password" cssClass="form-control" maxlength="20" showPassword="true"/>
				    </div>
			  	</div>
			  	
			  	<div class="form-group">
					<label for="name" class="col-sm-4 control-label">Name:</label>
					<div class="col-sm-4">
				    	<sf:input path="name" cssClass="form-control" maxlength="100"/>
				    </div>
			  	</div>

				<div class="form-group">
					<label for="surname" class="col-sm-4 control-label">Surname:</label>
					<div class="col-sm-4">
				    	<sf:input path="surname" cssClass="form-control" maxlength="100"/>
				    </div>
			  	</div>			  	
				
				<div class="form-group">
					<label for="email" class="col-sm-4 control-label">Email:</label>
					<div class="col-sm-4">
				    	<sf:input path="email" cssClass="form-control" maxlength="150"/>
				    </div>
			  	</div>
			  	
				<div class="form-group">
					<label for="phone" class="col-sm-4 control-label">Phone:</label>
					<div class="col-sm-4">
				    	<sf:input path="phone" cssClass="form-control" maxlength="11"/>
				    </div>
			  	</div>
				
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						<div class="checkbox">
							<label>
				    			<sf:checkbox path="isEnabled"/><span class="align-middle">Enabled</span>
							</label>
						</div>
				    </div>
			  	</div>
			  	
				<div class="form-group">
					<label for="registerDate" class="col-sm-4 control-label">Regiter Date:</label>
					<div class="col-sm-4">
				    	<sf:input path="registerDate" cssClass="form-control" maxlength="10"/>
				    </div>
			  	</div>
			
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-10">
						<button type="submit" class="btn btn-primary">Save</button>
						<button type="button" class="btn btn-danger" onclick='document.forms[0].action = "${pageContext.request.contextPath}/users/delete"; document.forms[0].submit();'>Delete</button>
						<a href="<s:url value="/users" />" class="btn btn-default">Return</a>
					</div>
				</div>
			</sf:form>
		
		</div>
	</body>
</html>