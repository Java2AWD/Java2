<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="dao.AdvertismentDAO"%>
<%@page import="dao.AdDAOImplHibernate"%>
<%@page import="domain.Ad"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="css/Advertisement.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adverts</title>
</head>
<body>
	<h4>Records from DB Advertisements</h4>
	
	<center>
		<table>
<tr>
<th>ID</th>
<th>Message</th>
<th>Date</th>
<th>User ID</th>
<th>Category ID</th>
</tr>
		
		<%
			AdvertismentDAO dao = new AdDAOImplHibernate();
			List<Ad> adsList = new ArrayList<Ad>();
			Ad ad = new Ad();
			for (int i = 791; i < 809; i++) {
				ad = dao.getById(i);
				adsList.add(ad);
				String message = ad.getMessage().toString();
				int id = ad.getAdId();
				int usersid = ad.getUsers_id();
				String date = ad.getDate().toString();
				int categoryid = ad.getCategory_id();
		%>
<tr>
<td><%out.print(id);%></td>
<td><%out.print(message);%></td>
<td><%out.print(date);%></td>
<td><%out.print(usersid);%></td>
<td><%out.print(categoryid);%></td>
</tr>		
			<%
			} 
			Date date = new Date();
			ad.setAdId(900);
			ad.setDate(date);
			ad.setCategory_id(1);
			ad.setMessage("jsp");
			ad.setUsers_id(1);
			dao.save(ad);
			System.out.print(ad.getAdId());
			%>
		</table>
	</center>

</body>
</html>