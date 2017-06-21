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
		<title>Users List</title>
	</head>
	<body>
		
		<div class="jumbotron">
			
			<div>
				<p class="bg-${messageType} text-center">
					<label>${message}</label>
				</p>
				
				<h3 class="text-center">Users Search</h3><br>
			
				<s:url value="/users/search" var="action" />
	
				<sf:form method="GET" modelAttribute="user" action="${action}" cssClass="form-horizontal">
					<div class="form-group">
						<label for="username" class="col-sm-4 control-label">User Name:</label>
						<div class="col-sm-4">
				    		<sf:input path="userName" cssClass="form-control"/>
				    	</div>
				  	</div>
				
					<div class="form-group">
						<label for="name" class="col-sm-4 control-label">Name:</label>
						<div class="col-sm-4">
							<sf:input path="name" cssClass="form-control"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="email" class="col-sm-4 control-label">Email:</label>
						<div class="col-sm-4">
							<sf:input path="email" cssClass="form-control"/>
						</div>
					</div>
				
					<div class="form-group">
						<div class="col-sm-offset-5 col-sm-10">
							<button type="submit" class="btn btn-primary">Search</button>
							<a href="<s:url value="/users/new"/>" class="btn btn-default">New</a>
						</div>
					</div>
				</sf:form>
		
			</div>
	
			<hr>
			<h3 class="text-left">Results</h3>
		
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>User Name</th>
						<th>Password</th>
						<th>Enabled</th>
						<th>Register Date</th>
						<th>Name</th>
						<th>Surname</th>
						<th>Email</th>
						<th>Phone</th>
						<th class="text-center">#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.userName}</td>
							<td>${user.password}</td>
							<td align="center">${user.isEnabled}</td>
							<td align="center"><fmt:formatDate value="${user.registerDate}" pattern="dd/MM/yyyy"/></td>
							<td>${user.name}</td>
							<td>${user.surname}</td>
							<td>${user.email}</td>
							<td class="text-center">${user.phone}</td>
							<td>
								<a href="<s:url value="/users/edit/${user.id}" />" class="btn btn-default">
									<span class="fa fa-edit"></span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>