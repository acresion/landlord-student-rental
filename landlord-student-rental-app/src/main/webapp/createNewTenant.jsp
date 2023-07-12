<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="landlord.student.rental.daowork.*"%>
	<%@ page import="java.util.*"%>
	<%@ page import="java.sql.*"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
<form action ="AddTenant" method ="get">
	Tenant ID: <input type= "text" name= "tenant_id">
	<br>
	First Name: <input type= "text" name= "first_name">
	<br>
	Last Name: <input type= "text" name= "last_name">
	<br>
	Address Before Moving In: <input type= "text" name= "address_before_movein">
	<br>
	City Before Moving In: <input type= "text" name= "city_before_movein">
	<br>
	State Before Moving In: <input type= "text" name= "state_before_movein">
	<br>
	Country Before Moving In: <input type= "text" name= "country_before_movein">
	<br>
	Year of Birth: <input type= "text" name= "year_of_birth">
	<br>
	Month of Birth: <input type= "text" name= "month_of_birth">
	<br>
	Day of Birth: <input type= "text" name= "day_of_birth">
	<br>
	Room: <input type= "text" name= "room">
	<br>
	Floor: <input type= "text" name= "floor">
	<br>
	Landlord ID: <input type= "text" name= "landlord_id">
	<br>
	<input type= "submit" value = "Confirm" name= "submit">
</form>


<button class="button1" onclick ="redirect()"> Back </button>
	
	 <script type="text/javascript">
	 function redirect(){
		 location.replace("index.jsp")
	 }
	 
	 </script>
</body>

</body>
</html>