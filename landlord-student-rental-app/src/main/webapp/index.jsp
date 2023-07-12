<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="landlord.student.rental.daowork.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rental Website</title>
<style>
h1 {
	text-align: center;
}

.div1 {
	border: 5px inset red;
	background-color: blue;
	text-align: center;
}
.button1{
	background-color: #0ebfe3;
	color: white;
	border: solid;
	cursor: pointer;
	display: inline-block;
	padding: 44px 33px;
	border-radius: 3px;
	transition-duration: 1s;
	margin: 4px 2px;
	border-color: #0ebfe3;
	
}
.button1:hover{
	background-color: white ;
	color: #0ebfe3;
	border: solid;
	cursor: pointer;
	display: inline-block;
	padding: 44px 33px;
	border-radius: 3px;
    margin: 4px 2px;
   	border-color: #0ebfe3;
    
	
	
}

</style>
</head>
<body>
	<h1>Hello there</h1>
	<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSz97oIkbJAEONRA4DrPhBhcb2PMbv4XjB5wd8TPhSthA&s">
	<br>
	<a href="https://www.w3schools.com/html/html_attributes.asp"> Link
		to the sacred cow </a>
	<div class="div1">
		<%
		for (int i = 0; i < 5; i++) {
		%>
		<p>Experimental text</p>
		<%
		}
		%>

	</div>



	<blockquote>

		<table border="2">
			<thead>
				<td>Tenant Id</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Address before Move In</td>
				<td>City before Move In</td>
				<td>State before Move In</td>
				<td>Country before Move In</td>
				<td>Year of Birth</td>
				<td>Month of Birth</td>
				<td>Day of Birth</td>
				<td>Room</td>
				<td>Floor</td>
				<td>Landlord Id</td>

			</thead>
			<%
			TenantFacade tenantFac = new TenantFacade();
			List<Tenant> tenantList = tenantFac.getAllTenants();
			for (Tenant tenant : tenantList) {
			%>
			<tr>
				<td><%=tenant.getTenantId()%></td>
				<td><%=tenant.getFirstName()%></td>
				<td><%=tenant.getLastName()%></td>
				<td><%=tenant.getAddressBeforeMovein()%></td>
				<td><%=tenant.getCityBeforeMovein()%></td>
				<td><%=tenant.getStateBeforeMovein()%></td>
				<td><%=tenant.getCountryBeforeMovein()%></td>
				<td><%=tenant.getYearOfBirth()%></td>
				<td><%=tenant.getMonthOfBirth()%></td>
				<td><%=tenant.getDayOfBirth()%></td>
				<td><%=tenant.getRoom()%></td>
				<td><%= tenant.getFloor()%></td>
				<td><%=tenant.getLandlordId()%></td>
			</tr>
			<%
			}
			%>

		</table>

	</blockquote>
	<button class="button1" onclick ="redirect()"> Click here </button>
	
	 <script type="text/javascript">
	 function redirect(){
		 location.replace("createNewTenant.jsp")
	 }
	 
	 </script>
	
	

</body>
</html>