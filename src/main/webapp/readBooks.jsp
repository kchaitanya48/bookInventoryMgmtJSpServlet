<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.takeo.model.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.takeo.model.Book"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="bookRead" method="get">

<input type="submit" value="getBookDetails">
</form>

<% if(request.getAttribute("books")!=null){ 
	List<Book> books=(ArrayList)request.getAttribute("books");%>
		
	<table>
	<%for(Book book:books){ %>

	<tr >
	<td><%=book.getBookName() %></td>
	</tr>
	
	
	<% } 
	   } %>
	   </table>

</body>
</html>