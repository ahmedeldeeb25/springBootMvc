<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:eval expression="@environment.getProperty('frontend.url')" var="frontendUrl" />

<link href="http://${frontendUrl}:60650/assets/css/ddd.css" rel="stylesheet"></link>


<html lang="en">
<body>
    <div>
        <div>
            <h1>Another page</h1>
            <h2>Hello ${message}</h2>
             
            Click on this <strong><a href="/">link</a></strong> to visit previous page.
        </div>
    </div>
</body>
</html>