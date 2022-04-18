<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style>
body{
			background-image: linear-gradient(to right,#FEF9EF,#350B40);
			height: 100%;
		}
		h1{
		text-size:200%;
		Color:green;
		text-align:center;
		}
</style>
</head>
<body>
<h1>Welcome User</h1>
<button class="GFG" 
    onclick="window.location.href = '/jobSeeker.jsp';">
        JobSeeker
    </button>
	<button class="GFG" 
    onclick="window.location.href = '/jobRecruiter.jsp';">
       JobRecruiter
    </button>
</body>
</html>