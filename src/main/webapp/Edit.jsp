<%@page import="dto.Student"%>
<%@page import="dao.Studentdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	Studentdao d = new Studentdao();
	Student student = d.find(id);
	%>
	<form action="Update">
		<table>
			<tr>
				<th>ID:</th>
				<td><input type="text" name="id" value="<%=id%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="Name"
					value="<%=student.getName()%>"></td>
			</tr>
			<tr>
				<th>Mobile:</th>
				<td><input type="tel" name="mobile" pattern="{0-9}[10]"
					value="<%=student.getMob()%>"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" name="email"
					value="<%=student.getEmail()%>"></td>
			</tr>
			<tr>
				<th>Gender:</th>
				<%
				if (student.getGender().equals("male")) {
				%>
				<td><input type="radio" name="gender" value="male"
					checked="checked">Male <input type="radio" name="gender"
					value="female">FeMale</td>
				<%
				} else {
				%>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female" checked="checked">FeMale</td>

				<%
				}
				%>
			</tr>
			<tr>
				<th>Date of Birth:</th>
				<td><input type="date" name="dob"
					value="<%=student.getDob()%>"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><textarea rows="5" cols="30" name="address"><%=student.getAddress()%></textarea></td>
			</tr>
			<tr>
				<th>Languages known:</th>
				<th>
					<%
					boolean f1 = true;
					boolean f2 = true;
					boolean f3 = true;
					for (String s : student.getLang()) {
						if (f1) {
							 f1 = false;
							if (s.equals("kannada")) {
					%> <input type="checkbox" name="language" value="kannada"
					checked="checked">Kannada <%

 } else {
 %> <input type="checkbox" name="language" value="kannada">Kannada
					<%
 }
							continue;
 }
 %> <%
 if(f2)
 {
	 f2=false;
 if (s.equals("english"))
 {
 %> <input type="checkbox" name="language" value="english"
					checked="checked">English <%
 } else {
 %> <input type="checkbox" name="language" value="english">English				<%
 }
 continue;
 }
 %> 
 <%
 if(f3)
 {
	 f3=false;
 if (s.equals("hindi")) {
 %> <input type="checkbox" name="language" value="hindi"
					checked="checked">Hindi <%

 } else {
 %> <input type="checkbox" name="language" value="hindi">Hindi
					<% }
 continue;
 }
 }
 %>
				</th>
			</tr>
			<tr>
				<th>Country:</th>
				<td><select name="country">
						<option>India</option>
						<option>Korea</option>
						<option>USA</option>
				</select></td>
			</tr>
			<tr>
				<td><button type="reset">Cancel</button></td>
				<td><button>Update</button></td>
			</tr>
		</table>
	</form>
</body>
</html>