<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Magazine catalog</h2>
<form action = "registration" method ="post">

<table>
	<tr>
		<td>Catalog`s Name</td>
		<td>
		<select name="catalogName">
			<option  selected value="Forbes">Forbes</option>
			<option  value="Time">Time</option>
			<option  value="TheWeek">The Week</option>
			<option  value="boutique">boutique</option>
			<option  value="Money">Money</option>
			<option  value="Bloomberg">Bloomberg</option>
			<option  value="TheEconomist">The Economist</option>
			<option  value="ModernHealthcare">Modern Healthcare</option>
			<option  value="TechnologyReview">Technology Review</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>Frequency of publication</td>
		<td>
		<select name="frequency">
			<option selected value="Weekly">Weekly</option>
			<option value="Monthly">Monthly</option>
		</select>
		<td>
	</tr>
	<tr>
		<td>Price</td>
		<td><input name="price"></td>
	</tr>
</table>

<!--  
<label for="catalogName">Catalog Name :</label> <input name="catalogName">
<label for="catalogType">Catalog Type :</label> <input name="catalogType">
<label for="price">Price :</label> <input name="price">
-->

<h3>Client`s data</h3>
	<p><label for="firstName">First Name :</label> <input name="firstName"></p>
	<p><label for="lastName">Last Name :</label> <input name="laststName"></p>
	<p><label for="email">Email :</label> <input name="email"></p>
	<p><label for="password">Password :</label> <input name="password"></p>
	<p><input type="submit" value="submit"></p>
</form>
	
	




</body>
</html>
