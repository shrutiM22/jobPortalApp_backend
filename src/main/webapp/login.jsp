<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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


String sql = "select * from users where email=? and password=? ";

String email = request.getParameter("email");
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
}
%>
</body>
</html>