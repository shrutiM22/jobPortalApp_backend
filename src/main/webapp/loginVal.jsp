<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
<%
    try{
        String un = request.getParameter("username");   
        String pass = request.getParameter("password");
        Class.forName("org.postgresql.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres" + "user=postgres&password=test");    
        PreparedStatement pst = conn.prepareStatement("Select user_name,password from users where user=? and pass=?");
        pst.setString(1, un);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();                        
        if(rs.next())           %>
          <jsp:include page="index.jsp"></jsp:include>        
       <%  else %>
              <jsp:include page="userLogin.jsp"></jsp:include>         
   <% }
   catch(Exception e){       
       out.println("Something went wrong !! Please try again");       
   }      
%>
</body>
</html>