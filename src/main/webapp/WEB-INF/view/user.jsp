<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


        <h1>Hello <b><c:out value="${pageContext.request.remoteUser}"/></b> </h1>
<br >


<form id="form" >

Search By Topic : <input  type="text"  name="topic" id="topic" > <br>

<input type="submit" value="Search ...."> 


</form>




<br > 
<br > 
<br > 
<br > 
<form action="/logout" method="post">
          <input type="submit" value="Logout .........." /> 
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>   



<script type="text/javascript" src="assets/js/js.js"></script>

</body>
</html>