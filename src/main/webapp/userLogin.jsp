<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
   <%@ page import="java.sql.*" %> 
    
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

		.logtable {
		
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
	.userlog{
		
		margin-left:440px;
		background-image: linear-gradient(to right,#FEF9EF,#350B40);
		margin-right:440px;
		padding-bottom:50px;
		padding-top:5px;
		border-radius:10px;
	}
	.log{
		margin-left:180px;
		margin-top:10px;
		padding: 10px 30px;
		border-radius:5px;
		background-color: #874356;
		color: white;
	}
	.log:hover{
		background-color:#C65D7B;
		cursor: pointer;
	}
	
	input{
		padding: 8px 50px;
		border: 2px solid purple;
		border-radius: 5px;
	}
	h1{
		text-align:center;
		margin-top:40px;
	}
</style>
</head>
<body>

<%! String userdbName;
String userdbPsw;
String dbUsertype;
%>
<%
Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;

String driverName = "org.postgresql.Driver";
String url = "jdbc:postgresql://localhost:5432/postgres";

String user = "postgres";
String pass = "test";
%>



	<h1>Enter Details for User Login </h1>
	<form action="/login" method="get" class="userlog">
		
			<table style="with: 50%">
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" /></td>
				</tr>
				
					<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				
				</table>
			<input type="submit" value="Login" class="log"/>
	</form>
	
	<%

String sql = "select * from users where email=? and password=? ";

String email = request.getParameter("username");
String password = request.getParameter("password");


if((!(email.equals(null) || email.equals("")) && !(password.equals(null) || password.equals(""))) )
{
try{
Class.forName(driverName);
con = DriverManager.getConnection(url, user, pass);
ps = con.prepareStatement(sql);
ps.setString(1, email);
ps.setString(2, password);

rs = ps.executeQuery();
if(rs.next())
{ 
userdbName = rs.getString("email");
userdbPsw = rs.getString("password");

if(email.equals(userdbName) && password.equals(userdbPsw))
{
session.setAttribute("email",userdbName);

response.sendRedirect("view.jsp"); 
} 
}
else
response.sendRedirect("error.jsp");
rs.close();
ps.close(); 
}
catch(SQLException sqe)
{
out.println(sqe);
} 
}
else
{
%>
<center><p style="color:red">Error In Login</p></center>
<% 
getServletContext().getRequestDispatcher("/userLogin.jsp").include(request, response);
} %>
	
</body>
</html>