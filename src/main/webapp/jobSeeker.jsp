 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FindJob.com</title>
<style type="text/css">
	
	body{
			background-image: linear-gradient(to right,#FEF9EF,#350B40);
			height: 100%;
		}
		
		.getjobpost {
		  width: 80%;
		  margin-top:10px;
		  margin-bottom:20px;
		  border-collapse: collapse;
		  border: 2px solid purple;
	}
	tr{
		padding: 20px;
	}
	
	td{
		padding : 20px;
		text-align: left;
	}
	th{
		background-color: white;
		padding: 10px 20px;
		text-align: left;
	}
	.container{
		
		margin-left:250px;
	}
	
	.btn-add{
		padding: 10px 30px;
		border-radius:5px;
		background-color: #FFEDDA;
		color: Black;
		margin-bottom:20px;
	}
	.btn-update{
		padding: 10px 30px;
		border-radius:5px;
		background-color: #FFEDDA;
		color: Black;
		margin-bottom:20px;
	}
	.btn-add:hover{
		background-color:#C65D7B;
		cursor: pointer;
	}
	.btn-update:hover{
		background-color:#C65D7B;
		cursor: pointer;
	}
	.logout{
		margin-left: 1250px;
		padding: 10px 20px;
		border-radius:5px;
		margin-top: 3.3px;
		background-color: #F90716;
	
		
	}
	.nav{
		background-color: black;
		margin-top: -10px;
		margin-left: -10px;
		margin-right: -10px;
		height: 45px;
		
		
	}

	
	
	
</style>
</head>
<body>

<%
String driverName = "org.postgresql.Driver";
String connectionUrl = "jdbc:postgresql://localhost:5432/";
String db = "postgres";
String userId = "postgres";
String password = "test";
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection conn = null;
Statement s = null;
ResultSet rs = null;
%>

	<div class="nav">
		<a href="userLogin.jsp"><button class="logout">Logout</button> </a>
	</div>
	<div class="container">
	<h1>Add or update job Seeker profile </h1>
		<a href="addjobS.jsp"><button class="btn-add">Add jobSeeker</button></a>
		<a href="updateJobS.jsp"><button class="btn-update">Update Jobseeker</button></a>
		<h1>NEW JOBS</h1>
		<form  method="get">
	<table style="with: 50% " class="getjobpost">
				<tr>
				<th>Job Description</th>
				<th>Required Skills</th>
				<th>Required Experience</th>
				<th>Salary</th>
				<th>Job Location</th>
				<th>Job Role</th>
				</tr>
				
				<%
				
				try{ 
				conn = DriverManager.getConnection(connectionUrl+db, userId, password);
				s=conn.createStatement();
				String sql ="SELECT * FROM job_application";
				rs = s.executeQuery(sql);
				while(rs.next()){
				%>
				<tr>
				<td><%=rs.getString("job_description") %></td>
				<td><%=rs.getString("required_skills") %></td>
				<td><%=rs.getString("required_experience") %></td>
				<td><%=rs.getString("salary") %></td>
				<td><%=rs.getString("job_location") %></td>
				<td><%=rs.getString("job_role") %></td>
				</tr>
				
				<% 
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
				
				<tr>
					<td>JD</td>
					<td>RS</td>
					<td>S</td>
					<td>JL</td>
					<td>JR</td>
				</tr>
				
				</table>
			
	</form>
	</div>
</body>
</html>