<%@page import="java.util.Arrays"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Student> list=(List<Student>)request.getAttribute("list"); %>
<table border='1'>
<tr>
<th>id</th>
<th>Name</th>
<th>mobile</th>
<th>email</th>
<th>Gender</th>
<th>Address</th>
<th>country</th>
<th>Languages</th>
</tr>
<%for(Student student:list){ %>
<tr>
<th><%=student.getId() %></th>
<th><%=student.getName() %></th>
<th><%=student.getMob()%></th>
<th><%=student.getEmail()%></th>
<th><%=student.getGender() %></th>
<th><%=student.getAddress()%></th>
<th><%=student.getCountry() %></th>
<th><%= Arrays.toString(student.getLang())%></th>
<th><a href="delete?id=<%=student.getId() %>"><button>Delete</button></a></th>
<th><a href="Edit.jsp?id=<%=student.getId() %>"><button>Edit</button></a></th>
</tr>
<% }%>
</table>
<a href="home.html"><button>HOME</button></a>
</body>
</body>
</html>