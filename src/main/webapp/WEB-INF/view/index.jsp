<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:eval expression="@environment.getProperty('frontend.url')" var="frontendUrl" />

<link href="http://${frontendUrl}:60650/assets/css/ddd.css" rel="stylesheet"></link>


<html lang="en">
<body>
    <div>
        <div>
            <h1>Spring Boot JSP Example</h1>
            <h2>Hello ${message}</h2>
             
            Click on this <strong><a href="next">link</a></strong> to visit another page.
        </div>
    </div>
</body>
</html>