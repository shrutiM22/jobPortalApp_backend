<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	body{
			background-image: linear-gradient(to right,#FEF9EF,#350B40);
			height: 100%;
		}

		.regtable {
		
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
	.userreg{
		
		margin-left:400px;
		background-image: linear-gradient(to right,#FEF9EF,#350B40);
		margin-right:430px;
		padding-bottom:50px;
		padding-top:5px;
		border-radius:10px;
	}
	.sub{
		margin-left:200px;
		padding: 10px 30px;
		border-radius:5px;
		background-color: #874356;
		color: white;
	}
	.sub:hover{
		background-color:#C65D7B;
		cursor: pointer;
	}
	
	input{
		padding: 8px 70px;
		border: 2px solid purple;
		border-radius: 5px;
	}
	h1{
		text-align:center;
	}
	
</style>
</head>
<body>
	<h1>User Register Form</h1>
	<form action="/register" method="post" class="userreg">
		
			<table style="with: 50%" class="regtable">
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="userName" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Role</td>
					<td><input type="text" name="role" /></td>
				</tr>
				</table>
			<input type="submit" value="Submit" class="sub"/>
	</form>
</body>
</html>