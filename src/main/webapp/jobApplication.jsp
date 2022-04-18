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

		.jobappl {
		
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
	.jobpost{
		
		margin-left:400px;
		background-image: linear-gradient(to right,#FEF9EF,#350B40);
		margin-right:400px;
		padding-bottom:30px;
		padding-top:2px;
		border-radius:10px;
	}
	.sub{
		margin-left:230px;
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
	h3{
		color: white;
	}
	
</style>
</head>
<body>
	
	<div class="nav">
	
		<a href="userLogin.jsp"><button class="logout">Logout</button> </a>
	</div>
<h1>New Job Application </h1>
	<form action="/jobApplication" method="post" class="jobpost">
		
		
		
			<table style="with: 50%" class="jobappl">
				<tr>
					<td>Job Description</td>
					<td><input type="text" name="jobDescription" /></td>
				</tr>
				<tr>
					<td>Required Skills</td>
					<td><input type="text" name="requiredSkills" /></td>
				</tr>
				<tr>
					<td>Required Experience</td>
					<td><input type="number" name="requiredExperience" /></td>
				</tr>
					<tr>
					<td>Salary</td>
					<td><input type=number name="salary" /></td>
				</tr>
				<tr>
					<td>Job Location</td>
					<td><input type="text" name="jobLocation" /></td>
				</tr>
				<tr>
					<td>Job Role</td>
					<td><input type="text" name="JobRole" /></td>
				</tr>
				</table>
			<input type="submit" value="Post" class="sub"/>
	</form>
</body>
</html>