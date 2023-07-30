<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="form" uri= "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/style.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TraPWanGz | Edit Order</title>
</head>
<body>

	<nav class="navbar">
    
    <div class="logo">Welcome, ${user.firstName} | <a href = "/logout">Log out of your account</a>
    </div>
    
    <ul class="nav-links">

      <div class="menu">

        <li class="services">
          <a href="/createOrder">Create Order</a>

          <ul class="dropdown">
            <li><a href="/wings">Wings</a></li>
            <li><a href="/sides">Sides</a></li>
            <li><a href="/sets">Sets</a></li>
          </ul>

        </li>

        <li><a href="/home">Home</a></li>
        <li><a href="/contact">Contact</a></li>
        <li><a href="/login">Login</a></li>
        <li><a href="/register">Make an Account</a></li>
      </div>
    </ul>
  </nav>

<div id = "menuMain">
<form:form action = "/order/${order.id}" mode = "put" modelAttribute = "order">
	<input type = "hidden" name = "_method" value = "put">
	
			<form:label path = "comboChoice">Choose your combo</form:label>
			<form:select name = "comboChoice"  path = "comboChoice"  id ="comboChoice">
				<form:option value="1"   >6-Piece Combo</form:option>
				<form:option value="2"  >10-Piece Combo</form:option>
				<form:option value="3"   >15-Piece Combo</form:option>
			</form:select>
			
			<form:label path = "flavorChoice">Choose your sauce</form:label>
			<form:select  path = "flavorChoice" name="flavorChoice" id="flavorChoice">
				<form:option value="1" path = "flavorChoice">BMF</form:option>
				<form:option value="2" path = "flavorChoice">DSGB</form:option>
				<form:option value="3"  path = "flavorChoice" >Exotics</form:option>
				<form:option value="4" path = "flavorChoice">Trap Yak</form:option>
				<form:option value="5" path = "flavorChoice">Garlic Parm</form:option>
				<form:option value="6"   path = "flavorChoice">Trapping Apple</form:option>
				<form:option value="7" path = "flavorChoice">Bad & Boujee</form:option>
				<form:option value="8" path = "flavorChoice">Henndawgs</form:option>
				<form:option value="9"  path = "flavorChoice" >Trap Chili</form:option>
				<form:option value="10" path = "flavorChoice">Cilantro Lime Jalepeno</form:option>
				<form:option value="11" path = "flavorChoice">Strawberry Heat</form:option>
				<form:option value="12"  path = "flavorChoice" >Trap Habanero</form:option>
				<form:option value="13" path = "flavorChoice">Lemon Pepper</form:option>
				<form:option value="14" path = "flavorChoice">Honey Garlic</form:option>
				<form:option value="15"  path = "flavorChoice" >Gold Rush</form:option>
				<form:option value="16" path = "flavorChoice">Buffalo</form:option>
				<form:option value="17" path = "flavorChoice">Ranch</form:option>
				<form:option value="18"  path = "flavorChoice">24k</form:option>
			</form:select>
			
			<form:label path = "flavorChoice">Choose your side</form:label>
			<form:select  path = "sideChoice" name="sideChoice" id="sideChoice">
				<form:option value="1" path = "sideChoice">French Fries</form:option>
				<form:option value="2" path = "sideChoice">Mac & Cheese</form:option>
				<form:option value="3"  path = "sideChoice" >Baked Beans</form:option>
			</form:select>
			
			<form:label path = "flavorChoice">Choose your drink (optional)</form:label>
			<form:select  path = "drinkChoice" name="drinkChoice" id="drinkChoice">
				<form:option value="0" path = "drinkChoice">(None)</form:option>
				<form:option value="1"  path = "drinkChoice" >Sprite</form:option>
				<form:option value="2" path = "drinkChoice">Coke</form:option>
				<form:option value="3"  path = "drinkChoice" >Trap Juice (grade lemonade)</form:option>
			</form:select>
			
		<form:label for = "notes" class="form-label" path = "notes">Additional Requests</form:label>
		<form:errors path = "notes" class = "danger-text"/>
		<form:input type = "textarea" class = "form-control" id = "notes" path = "notes" />
				
			<form:input type="hidden"  path="user"  value="${user.id}"/>
			<form:errors path = "orderComplete" class = "danger-text"/>
			<form:input type="hidden"  path="orderComplete"  value = "no" />

			
		<button type = "submit"  value  = "createOrder" >Confirmation Screen</button>
		
	</form:form>
</div>

</body>
</html>