<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>

<spring:eval expression="@environment.getProperty('frontend.url')" var="frontendUrl" />

<link href="http://${frontendUrl}:60650/assets/css/ddd.css" rel="stylesheet"></link>


<html lang="en">
<body>
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">    
	<c:if test="${param.error != null}">        
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">       
		<p>
			You have been logged out.
		</p>
	</c:if>
	<p>
		<label for="username">Username</label>
		<input type="text" id="username" name="username"/>	
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password"/>	
	</p>
	<input type="checkbox" name="remember-me" id="remember-me" />
	<label>Remember me</label>
	<input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>
<!--     <div> -->
<!--         <div> -->
<!--             <h1>Spring Boot JSP Example</h1> -->
<%--             <h2>Hello ${message}</h2> --%>
             
<!--             Click on this <strong><a href="register">link</a></strong> to visit another page. -->
<!--         </div> -->
<!--     </div> -->
</body>
</html>