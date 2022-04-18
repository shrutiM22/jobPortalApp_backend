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

		.posttable {
		
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
	.addpost{
		
		margin-left:400px;
	}
	.add{
		margin-left:200px;
		padding: 10px 30px;
		border-radius:5px;
		background-color: #874356;
		color: white;
	}
	.add:hover{
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
	<div class="nav">
		<a href="userLogin.jsp"><button class="logout">Logout</button> </a>
	</div>
	<form action="/addjobS" method="post" class=addpost>
	<h1>Enter details to Add new Job Seeker</h1>
	<table class="posttable" style="with:">
				<tr >
					<td>Experience</td>
					<td><input type="number" name="experience" placeholder="in years"/></td>
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
					<td>About Me</td>
					<td><input type="text" name="aboutMe" /></td>
				</tr>
				<tr>
					<td>Phone number</td>
					<td><input type="text" name="phoneNumber" /></td>
				</tr>
				</table>
			<input type="submit" value="Add" class="add" />
	</form>
</body>
</html>