
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="dao.AdvertismentDAO"%>
<%@page import="dao.AdDAOImplHibernate"%>
<%@page import="domain.Ad"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body
{
background-color:aqua;
}
h2
{
color:lime;
text-align:center;
}
h4
{
color: orange;
text-align: left;
}
p
{
font-family:"Times New Roman";
font-size:20px;
}
table
{
text-align: center
border-collapse:collapse;
}
table, td, th
{
border:1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TestPage</title>
</head>
<script>

function displayDate()
{
document.getElementById("demo").innerHTML=Date();
}
</script>
<body>
		<center>
		<h2>Login form</h2>
        <form action= "Advertisements.jsp" method="post">
        <br/>Username:<input type="text" name="username">
        <br/>Password:<input type="password" name="password">
        <br/><input type="submit" value="Submit">
        </form>
        <h4> ADs from Data Base </h4>
        <% AdvertismentDAO dao = new AdDAOImplHibernate();
        List<Ad> adsList = new ArrayList<Ad>();
        Ad ad = new Ad();
        for(int i = 791; i< 809;i++)
        {
        	
        	ad=dao.getById(i);
        	adsList.add(ad);
        	String message = ad.getMessage().toString();
            int id = ad.getAdId();
            int usersid = ad.getUsers_id();
            String date = ad.getDate().toString();
            int categoryid = ad.getCategory_id();
            
        	%>
        <table border =1  >
        <tr>
        <td> ID </td>
        <td> Message </td>
        <td> Date </td>
        <td> User ID </td>
        <td> Category ID </td>
        </tr>
        <tr> 
         <td> <% out.print(id); %> </td> 
        <td> <% out.print(message); %> </td>
        <td> <% out.print(date); %> </td>
        <td> <% out.print(usersid); %> </td>
        <td> <% out.print(categoryid); %> </td>
        </tr>
        </table>
       <%} %> 
       
       
    </center>
		
		<%
		 Ad adl = new Ad();
        for(int j = 791; j<809;j++)
        {
        	adl=dao.getById(j);
        	adsList.add(ad);
        	String message = adl.getMessage().toString();
            int id = adl.getAdId();
            int usersid = adl.getUsers_id();
            String date = adl.getDate().toString();
            int categoryid = adl.getCategory_id();
          	%>
        <ul>
        <li><h4><% out.print(id); %>  <% out.print(message); %> <% out.print(date); %> <% out.print(usersid); %> <% out.print(categoryid); %></h4> <li>
       </ul>
       
       <%} %> 
       
       <h2>My First JavaScript</h2>
<p id="demo">This is a paragraph.</p>

<button type="button" onclick="displayDate()">Display Date</button>
</body>
</html>