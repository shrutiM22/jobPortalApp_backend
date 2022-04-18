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

		.updatetable {
		  width: 50%;
		  margin-top:40px;
		  margin-bottom:20px;
		  border-collapse: collapse;
		  
	}
	
	tr{
		padding: 20px;
	}
	
	td{
		padding : 20px;
	}
	.updatepost{
		
		margin-left:400px;
	}
	.update{
		margin-left:200px;
		padding: 10px 30px;
		border-radius:5px;
		background-color: #874356;
		color: white;
	}
	.update:hover{
		background-color:#C65D7B;
		cursor: pointer;
	}
	
	input{
		padding: 8px 70px;
		border: 2px solid purple;
		border-radius: 5px;
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
	<form action="/updatejobS" class=updatepost>
	<h1>Enter details to Update existing Job Seeker</h1>
	<table style="with: 50%" class="updatetable">
				<tr>
					<td>Id</td>
					<td><input type="text" name="jobseekerId" /></td>
				</tr>
				<tr>
					<td>Experience</td>
					<td><input type="text" name="experience" /></td>
				</tr>
				<tr>
					<td>Skills</td>
					<td><input type="text" name="skills" /></td>
				</tr>
					<tr>
					<td>Project</td>
					<td><input type="text" name="project" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" name="phoneNumber" /></td>
				</tr>
				<tr>
					<td>About Me</td>
					<td><input type="text" name="aboutMe" /></td>
				</tr>
				</table>
				<input type="submit" value="Update" class="update"/>
			
			<%
				
				try{ 
				conn = DriverManager.getConnection(connectionUrl+db, userId, password);
				s=conn.createStatement();
				String sqlid ="SELECT job_seeker_Id FROM job_seeker";
				if(sqlid ==%> <input type="text" name="jobseekerId" /> <% ){ 
					String sql = " INSERT INTO job_seeker VALUES (${experience}, ${skills}, ${project},${phoneNumber},${aboutMe});"
				}
				
				
				
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
			
	</form>
</body>
</html>